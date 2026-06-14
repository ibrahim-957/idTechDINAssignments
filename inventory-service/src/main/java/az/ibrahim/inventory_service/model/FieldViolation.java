package az.ibrahim.inventory_service.model;

import lombok.Builder;

@Builder
public record FieldViolation(String field, String message, Object rejectedValue) {
}
