package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.model.request.LoginRequest;
import com.ibrahim.spring.assetmanagement.model.request.RefreshTokenRequest;
import com.ibrahim.spring.assetmanagement.model.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(RefreshTokenRequest request);
    void logout(String token);
}
