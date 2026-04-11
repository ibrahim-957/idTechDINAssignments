package com.ibrahim.simpleshop.controller;

import com.ibrahim.simpleshop.model.request.CreateUserRequest;
import com.ibrahim.simpleshop.model.response.UserResponse;
import com.ibrahim.simpleshop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
@Validated
public class V1UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request){
        UserResponse userResponse = userService.createUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }
}
