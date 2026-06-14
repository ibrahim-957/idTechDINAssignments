package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.exception.BusinessException;
import com.ibrahim.spring.assetmanagement.model.request.LoginRequest;
import com.ibrahim.spring.assetmanagement.model.request.RefreshTokenRequest;
import com.ibrahim.spring.assetmanagement.model.response.AuthResponse;
import com.ibrahim.spring.assetmanagement.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;
    private final TokenBlacklistService tokenBlacklistService;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String accessToken = jwtTokenProvider.generateAccessToken(userDetails);
        String refreshToken = jwtTokenProvider.generateRefreshToken(userDetails);
        log.info("User '{}' logged in", request.getUsername());
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .build();
    }

    @Override
    public AuthResponse refresh(RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();
        String jti = jwtTokenProvider.extractJti(refreshToken);

        if (tokenBlacklistService.isBlacklisted(jti)) {
            throw new BusinessException("Refresh token has been revoked");
        }

        String username = jwtTokenProvider.extractUsername(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!jwtTokenProvider.isTokenValid(refreshToken, userDetails)) {
            throw new BusinessException("Invalid or expired refresh token");
        }

        tokenBlacklistService.blacklist(jti, jwtTokenProvider.extractExpiration(refreshToken));
        String newAccessToken = jwtTokenProvider.generateAccessToken(userDetails);
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(userDetails);
        log.info("Token rotated for user '{}'", username);
        return AuthResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .tokenType("Bearer")
                .build();
    }

    @Override
    public void logout(String token) {
        String jti = jwtTokenProvider.extractJti(token);
        long expiration = jwtTokenProvider.extractExpiration(token);
        tokenBlacklistService.blacklist(jti, expiration);
        log.info("Token jti={} logged out and blacklisted", jti);
    }
}
