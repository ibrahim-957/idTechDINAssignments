package com.ibrahim.spring.assetmanagement.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String resource, Long id) {
        super(resource + " not found with id: " + id);
    }

    public NotFoundException(String resource, String identifier){
        super(resource + " not found with identifier: " + identifier);
    }
}
