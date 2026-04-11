package com.ibrahim.simpleshop.service;

import com.ibrahim.simpleshop.model.request.CreateUserRequest;
import com.ibrahim.simpleshop.model.response.UserResponse;

public interface UserService {
    UserResponse  createUser(CreateUserRequest request);

    UserResponse getUserById(Long id);
}
