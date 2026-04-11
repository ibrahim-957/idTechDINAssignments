package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiResponse<T> {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;
    private final T data;

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(200, "OK", data);
    }

    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(201, "Created", data);
    }

    public static <T> ApiResponse<T> noContent() {
        return new ApiResponse<>(204, "No Content", null);
    }

    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(404, message, null);
    }

    public static <T> ApiResponse<T> conflict(String message) {
        return new ApiResponse<>(409, message, null);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        String ts = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("""
                        {
                          "status"    : %d,
                          "message"   : "%s",
                          "timestamp" : "%s",
                          "data"      : %s
                        }""",
                status, message, ts, formatData(data));
    }

    protected String formatData(Object d) {
        return d == null ? "null" : d.toString();
    }
}
