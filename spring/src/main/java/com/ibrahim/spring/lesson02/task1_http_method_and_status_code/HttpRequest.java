package com.ibrahim.spring.lesson02.task1_http_method_and_status_code;

import java.util.Map;

public record HttpRequest(
        HttpMethod method,
        String path,
        Map<String, String> headers,
        String body
) {}
