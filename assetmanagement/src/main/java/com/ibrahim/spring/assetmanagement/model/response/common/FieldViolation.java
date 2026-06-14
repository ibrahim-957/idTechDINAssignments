package com.ibrahim.spring.assetmanagement.model.response.common;

import lombok.Builder;

@Builder
public record FieldViolation(String field, String message, Object rejectedValue) {
}
