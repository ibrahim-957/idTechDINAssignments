package com.ibrahim.spring.assetmanagement.service;

public interface TokenBlacklistService {
    void blacklist(String jti, long expirationTimeMillis);
    boolean isBlacklisted(String jti);
}
