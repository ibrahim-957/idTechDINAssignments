package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class IdempotencyMiddleware {
    private static final long TTL_SECONDS = 60;

    private final Map<String, CachedEntry> cache = new ConcurrentHashMap<>();

    public UserResponse handlePost(String idempotencyKey, Supplier<UserResponse> handler){
        if (idempotencyKey == null || idempotencyKey.isBlank()){
            return new UserResponse(400,
                    "Bad Request - Idempotency-Key header is required for POST", null);
        }

        CachedEntry existing = cache.get(idempotencyKey);

        if (existing != null && !existing.isExpired(TTL_SECONDS)){
            System.out.printf(
                    "  [middleware] CACHE HIT for key '%s' - returning cached response%n",
                    idempotencyKey);
            return existing.response;
        }

        System.out.printf(
                "  [middleware] CACHE MISS for key '%s' - executing handler%n",
                idempotencyKey
        );
        UserResponse response = handler.get();
        cache.put(idempotencyKey, new CachedEntry(response));
        return response;
    }

    int cacheSize(){
        return cache.size();
    }
}
