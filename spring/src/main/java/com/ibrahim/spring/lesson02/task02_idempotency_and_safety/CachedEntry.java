package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

import java.time.Instant;

public class CachedEntry {
    final UserResponse response;
    final Instant cachedAt;

    public CachedEntry(UserResponse response) {
        this.response = response;
        this.cachedAt = Instant.now();
    }

    boolean isExpired(long ttlSeconds){
        return Instant.now().isAfter(cachedAt.plusSeconds(ttlSeconds));
    }
}
