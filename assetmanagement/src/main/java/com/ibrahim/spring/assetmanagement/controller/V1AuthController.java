package com.ibrahim.spring.assetmanagement.controller;

import com.ibrahim.spring.assetmanagement.model.request.LoginRequest;
import com.ibrahim.spring.assetmanagement.model.request.RefreshTokenRequest;
import com.ibrahim.spring.assetmanagement.model.response.AuthResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.ApiResponse;
import com.ibrahim.spring.assetmanagement.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class V1AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login (
            @Valid @RequestBody LoginRequest request
            ){
        return ResponseEntity.ok(ApiResponse.success(authService.login(request)));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<AuthResponse>> refresh (
            @Valid @RequestBody RefreshTokenRequest request
    ){
        return ResponseEntity.ok(ApiResponse.success(authService.refresh(request)));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<AuthResponse>> logout(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authService.logout(authHeader.substring(7));
        }
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
