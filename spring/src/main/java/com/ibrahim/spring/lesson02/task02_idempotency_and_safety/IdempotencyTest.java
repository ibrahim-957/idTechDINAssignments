package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

import java.util.UUID;

public class IdempotencyTest {
    static void printAnnotations(UserResource resource, String methodName, Class<?>... params) {
        try {
            var method = UserResource.class.getMethod(methodName, params);
            boolean safe       = method.isAnnotationPresent(Safe.class);
            boolean idempotent = method.isAnnotationPresent(Idempotent.class);
            System.out.printf("  %-14s → @Safe=%-5b @Idempotent=%b%n",
                    methodName, safe, idempotent);
        } catch (NoSuchMethodException e) {
            System.out.println("  Method not found: " + methodName);
        }
    }

    // ── Test 1: annotation inspection ────────────────────────────────────

    static void testAnnotations() {
        System.out.println("\n══ TEST 1 — Annotation Inspection ══════════════════");
        UserResource r = new UserResource();

        printAnnotations(r, "getUser",       int.class);
        printAnnotations(r, "createUser",    String.class, String.class);
        printAnnotations(r, "updateUser",    int.class, String.class, String.class);
        printAnnotations(r, "partialUpdate", int.class, String.class);
        printAnnotations(r, "deleteUser",    int.class);
    }

    // ── Test 2: PUT idempotency — call 3× with same data ─────────────────

    static void testPutIdempotency() {
        System.out.println("\n══ TEST 2 — PUT Idempotency (3 calls, same payload) ═");
        UserResource resource = new UserResource();

        String name  = "Alice-Updated";
        String email = "alice.new@example.com";

        UserResponse r1 = resource.updateUser(1, name, email);
        UserResponse r2 = resource.updateUser(1, name, email);
        UserResponse r3 = resource.updateUser(1, name, email);

        System.out.println("  Call 1: " + r1);
        System.out.println("  Call 2: " + r2);
        System.out.println("  Call 3: " + r3);

        // Idempotency assertion: all three responses must agree
        boolean statusEqual = r1.status() == r2.status() && r2.status() == r3.status();
        boolean userEqual   = r1.user().equals(r2.user()) && r2.user().equals(r3.user());
        boolean dbConsistent = resource.peek(1).equals(r3.user());

        System.out.println("\n  ✔ Same HTTP status?  " + statusEqual);
        System.out.println("  ✔ Same user state?   " + userEqual);
        System.out.println("  ✔ DB matches last?   " + dbConsistent);
        System.out.printf("%n  RESULT: PUT is idempotent = %b%n", statusEqual && userEqual && dbConsistent);
    }

    // ── Test 3: POST non-idempotency — each call makes a new resource ─────

    static void testPostNonIdempotency() {
        System.out.println("\n══ TEST 3 — POST Non-idempotency (3 calls, same body) ");
        UserResource resource = new UserResource();

        UserResponse r1 = resource.createUser("Charlie", "c@c.com");
        UserResponse r2 = resource.createUser("Charlie", "c@c.com");
        UserResponse r3 = resource.createUser("Charlie", "c@c.com");

        System.out.println("  Call 1: " + r1);
        System.out.println("  Call 2: " + r2);
        System.out.println("  Call 3: " + r3);

        boolean differentIds = r1.user().id() != r2.user().id()
                && r2.user().id() != r3.user().id();

        System.out.printf("%n  Each POST created a distinct resource (ids %d, %d, %d)%n",
                r1.user().id(), r2.user().id(), r3.user().id());
        System.out.printf("  RESULT: POST is non-idempotent = %b%n", differentIds);
    }

    // ── Test 4: DELETE idempotency — second delete is a no-op ────────────

    static void testDeleteIdempotency() {
        System.out.println("\n══ TEST 4 — DELETE Idempotency ══════════════════════");
        UserResource resource = new UserResource();

        UserResponse first  = resource.deleteUser(1);
        UserResponse second = resource.deleteUser(1);   // already gone

        System.out.println("  First  DELETE /users/1 → " + first);
        System.out.println("  Second DELETE /users/1 → " + second);
        System.out.printf("  RESULT: Both return 204 = %b%n",
                first.status() == 204 && second.status() == 204);
    }

    // ── Test 5: Idempotency-Key middleware ────────────────────────────────

    static void testIdempotencyKeyMiddleware() {
        System.out.println("\n══ TEST 5 — IdempotencyKey Middleware ═══════════════");
        UserResource       resource   = new UserResource();
        IdempotencyMiddleware middleware = new IdempotencyMiddleware();

        String key = UUID.randomUUID().toString();
        System.out.println("  Idempotency-Key: " + key);

        // First call — handler executes
        System.out.println("\n  ── First POST (fresh key) ──");
        UserResponse r1 = middleware.handlePost(key,
                () -> resource.createUser("Dana", "dana@example.com"));
        System.out.println("  Response: " + r1);

        // Second call — same key within TTL → cached, handler NOT executed
        System.out.println("\n  ── Second POST (same key, within 60 s) ──");
        UserResponse r2 = middleware.handlePost(key,
                () -> resource.createUser("Dana", "dana@example.com"));
        System.out.println("  Response: " + r2);

        // Third call — new key → fresh execution
        System.out.println("\n  ── Third POST (new key) ──");
        String newKey = UUID.randomUUID().toString();
        UserResponse r3 = middleware.handlePost(newKey,
                () -> resource.createUser("Eve", "eve@example.com"));
        System.out.println("  Response: " + r3);

        // Missing key → rejected
        System.out.println("\n  ── Fourth POST (missing key) ──");
        UserResponse r4 = middleware.handlePost(null,
                () -> resource.createUser("Frank", "frank@example.com"));
        System.out.println("  Response: " + r4);

        System.out.printf("%n  Cache entries: %d (key1 + key3 cached, null rejected)%n",
                middleware.cacheSize());
        System.out.printf("  r1 id == r2 id (duplicate blocked)? %b%n",
                r1.user().id() == r2.user().id());
        System.out.printf("  r3 is a NEW resource? %b%n",
                r3.user() != null && r3.user().id() != r1.user().id());
    }
}
