package com.ibrahim.spring.lesson02.task1_http_method_and_status_code;

import java.util.Map;

public class HttpSimulator {
    public static void main(String[] args){
        FakeRouter router = new FakeRouter();

        Runnable sep = () -> System.out.println("\n" + "-".repeat(55));

        sep.run();
        HttpRequest getUsers = new HttpRequest(
                HttpMethod.GET, "/users",
                Map.of("Accept", "application/json"),
                null);
        System.out.println("REQUEST : GET /users");
        System.out.println(router.dispatch(getUsers));

        // 2. POST /users (new user)  →  201 Created
        sep.run();
        HttpRequest postNew = new HttpRequest(
                HttpMethod.POST, "/users",
                Map.of("Content-Type", "application/json"),
                "{\"name\":\"charlie\"}");
        System.out.println("REQUEST : POST /users  (new user)");
        System.out.println(router.dispatch(postNew));

        // 3. POST /users (duplicate)  →  409 Conflict
        sep.run();
        HttpRequest postDuplicate = new HttpRequest(
                HttpMethod.POST, "/users",
                Map.of("Content-Type", "application/json"),
                "{\"name\":\"alice\"}");
        System.out.println("REQUEST : POST /users  (duplicate)");
        System.out.println(router.dispatch(postDuplicate));

        // 4. DELETE /users/999 (not found)  →  404 Not Found
        sep.run();
        HttpRequest deleteGhost = new HttpRequest(
                HttpMethod.DELETE, "/users/999",
                Map.of(),
                null);
        System.out.println("REQUEST : DELETE /users/999");
        System.out.println(router.dispatch(deleteGhost));

        // 5. DELETE /users/1 (exists)  →  204 No Content
        sep.run();
        HttpRequest deleteReal = new HttpRequest(
                HttpMethod.DELETE, "/users/1",
                Map.of(),
                null);
        System.out.println("REQUEST : DELETE /users/1");
        System.out.println(router.dispatch(deleteReal));

        // 6. Unknown route  →  404
        sep.run();
        HttpRequest unknown = new HttpRequest(
                HttpMethod.GET, "/products",
                Map.of(),
                null);
        System.out.println("REQUEST : GET /products  (no route)");
        System.out.println(router.dispatch(unknown));
    }
}
