package az.ibrahim.inventory_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @Builder.Default
    private final LocalDateTime timestamp =  LocalDateTime.now();
    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final List<FieldViolation> violations;
}
