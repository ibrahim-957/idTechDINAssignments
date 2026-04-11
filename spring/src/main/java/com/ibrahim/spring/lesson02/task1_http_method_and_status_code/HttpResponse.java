package com.ibrahim.spring.lesson02.task1_http_method_and_status_code;

import java.util.Map;

public record HttpResponse(
        HttpStatus status,
        Map<String, String> headers,
        String body
) {
    @Override
    public String toString() {
        return "HTTP " + status + "\n"
                + "Headers : " + headers + "\n"
                + "Body    : " + (body == null || body.isBlank() ? "(empty)" : body);
    }
}
