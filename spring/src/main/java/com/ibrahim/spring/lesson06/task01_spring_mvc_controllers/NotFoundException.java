package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
