package com.ibrahim.spring.lesson02.task1_http_method_and_status_code;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FakeRouter {
    private final Map<String, Handler> routes = new LinkedHashMap<>();

    private final Set<String> existingUsers = new HashSet<>(List.of("alice", "bob"));

    FakeRouter() {
        register(HttpMethod.GET, "/users", req -> {
            String body = """
                    [
                      {"id":1,"name":"alice"},
                      {"id":2,"name":"bob"}
                    ]""";
            return ok(body);
        });

        register(HttpMethod.POST, "/users", req -> {
            String name = extractField(req.body(), "name");

            if (name != null && existingUsers.contains(name.toLowerCase())) {
                return response(HttpStatus.CONFLICT,
                        Map.of("Content-Type", "application/json"),
                        "{\"error\":\"User '" + name + "' already exists\"}");
            }

            if (name != null) existingUsers.add(name.toLowerCase());

            return response(HttpStatus.CREATED,
                    Map.of("Content-Type", "application/json",
                            "Location", "/users/3"),
                    "{\"id\":3,\"name\":\"" + name + "\"}");
        });

        register(HttpMethod.DELETE, "/users/:id", req -> {
            String id = lastSegment(req.path());
            boolean found = id.equals("1") || id.equals("2");

            return found
                    ? response(HttpStatus.NO_CONTENT, Map.of(), "")
                    : response(HttpStatus.NOT_FOUND,
                    Map.of("Content-Type", "application/json"),
                    "{\"error\":\"User with id " + id + " not found\"}");
        });
    }


    void register(HttpMethod method, String pattern, Handler handler) {
        routes.put(routeKey(method, pattern), handler);
    }


    HttpResponse dispatch(HttpRequest request) {
        String exact = routeKey(request.method(), request.path());
        if (routes.containsKey(exact)) {
            return routes.get(exact).handle(request);
        }

        for (Map.Entry<String, Handler> entry : routes.entrySet()) {
            if (matches(entry.getKey(), request.method(), request.path())) {
                return entry.getValue().handle(request);
            }
        }

        return response(HttpStatus.NOT_FOUND,
                Map.of("Content-Type", "application/json"),
                "{\"error\":\"No route for " + request.method() + " " + request.path() + "\"}");
    }


    private static String routeKey(HttpMethod m, String path) {
        return m.name() + " " + path;
    }

    private static boolean matches(String routeKey, HttpMethod method, String incomingPath) {
        String[] parts = routeKey.split(" ", 2);
        if (!parts[0].equals(method.name())) return false;

        String pattern = parts[1];
        String[] patSegments = pattern.split("/");
        String[] inSegments  = incomingPath.split("/");

        if (patSegments.length != inSegments.length) return false;

        for (int i = 0; i < patSegments.length; i++) {
            if (!patSegments[i].startsWith(":") && !patSegments[i].equals(inSegments[i])) {
                return false;
            }
        }
        return true;
    }

    private static HttpResponse ok(String body) {
        return response(HttpStatus.OK, Map.of("Content-Type", "application/json"), body);
    }

    private static HttpResponse response(HttpStatus status,
                                         Map<String, String> headers,
                                         String body) {
        return new HttpResponse(status, headers, body);
    }

    private static String extractField(String body, String field) {
        if (body == null) return null;
        String key = "\"" + field + "\"";
        int idx = body.indexOf(key);
        if (idx == -1) return null;
        int colon = body.indexOf(':', idx) + 1;
        int start  = body.indexOf('"', colon) + 1;
        int end    = body.indexOf('"', start);
        return (start > 0 && end > start) ? body.substring(start, end) : null;
    }

    private static String lastSegment(String path) {
        String[] parts = path.split("/");
        return parts[parts.length - 1];
    }
}
