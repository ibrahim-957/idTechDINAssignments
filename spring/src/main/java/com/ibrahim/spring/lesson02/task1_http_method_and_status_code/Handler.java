package com.ibrahim.spring.lesson02.task1_http_method_and_status_code;

@FunctionalInterface
public interface Handler {
    HttpResponse handle(HttpRequest request);
}
