package com.ibrahim.spring.lesson02.task02_idempotency_and_safety;

public record User(int id, String name, String email) {
    User withName(String newName) {
        return new User(id, newName, email);
    }
    User withEmail(String newEmail) {
        return new User(id, name, newEmail);
    }
}
