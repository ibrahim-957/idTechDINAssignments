package com.ibrahim.spring.assetmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenBlacklistServiceImpl implements TokenBlacklistService {

    private final StringRedisTemplate redisTemplate;
    private static final String BLACKLIST_PREFIX = "blacklist:";

    @Override
    public void blacklist(String jti, long expirationTimeMillis) {
        long ttlMillis = expirationTimeMillis - System.currentTimeMillis();
        if (ttlMillis > 0) {
            redisTemplate.opsForValue().set(
                    BLACKLIST_PREFIX + jti,
                    "revoked",
                    ttlMillis,
                    TimeUnit.MILLISECONDS
            );
            log.debug("Token jti={} blacklisted, TTL={}ms", jti, ttlMillis);
        }
    }

    @Override
    public boolean isBlacklisted(String jti) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(BLACKLIST_PREFIX + jti));
    }
}
