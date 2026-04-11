package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

import java.util.HashMap;
import java.util.Map;

public class UserResource {
    private final Map<Integer, User> db = new HashMap<>(Map.of(
            1, new User(1, "Alice", "alice@example.com"),
            2, new User(2, "Bob", "bob@example.com")
    ));

    private int nextId = 3;

    @Safe
    @Idempotent
    public UserResponse getUser(int id){
        User user = db.get(id);
        return user != null
                ? new UserResponse(200, "OK", user)
                : new UserResponse(404, "NOT FOUND", null);
    }

    public UserResponse createUser(String name, String email){
        User created = new User(nextId++, name, email);
        db.put(created.id(), created);
        return new UserResponse(201, "Created - id=" + created.id(), created);
    }

    @Idempotent
    public UserResponse updateUser(int id, String name, String email) {
        if (!db.containsKey(id)) return new UserResponse(404, "Not Found", null);
        User updated = new User(id, name, email);
        db.put(id, updated);
        return new UserResponse(200, "Updated (full replace)", updated);
    }

    public UserResponse partialUpdate(int id, String newName) {
        User existing = db.get(id);
        if (existing == null) return new UserResponse(404, "Not Found", null);
        User patched = existing.withName(newName);
        db.put(id, patched);
        return new UserResponse(200, "Updated (partial)", patched);
    }

    @Idempotent
    public UserResponse deleteUser(int id) {
        boolean existed = db.remove(id) != null;
        String msg = existed ? "Deleted" : "Already absent — no-op";
        return new UserResponse(204, msg, null);
    }

    User peek(int id) {
        return db.get(id);
    }
}
