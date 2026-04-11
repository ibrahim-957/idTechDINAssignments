package com.ibrahim.simpleshop.service;

import com.ibrahim.simpleshop.dao.entity.User;
import com.ibrahim.simpleshop.dao.repository.UserRepository;
import com.ibrahim.simpleshop.mapper.UserMapper;
import com.ibrahim.simpleshop.model.request.CreateUserRequest;
import com.ibrahim.simpleshop.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }
    @Override
    public UserResponse getUserById(Long id) {
        User user = findById(id);
        return userMapper.toResponse(user);
    }

    private User findById(Long id){
        return  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
