package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getGreeting(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "!";
    }

    public String getStatus() {
        return "Service is running smoothly";
    }
}
