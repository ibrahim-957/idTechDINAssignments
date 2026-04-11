package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

public record UserResponse(int status, String message, User user) {
    @Override
    public String toString() {
        return String.format("HTTP %d | %-35s | user=%s", status, message, user);
    }
}
