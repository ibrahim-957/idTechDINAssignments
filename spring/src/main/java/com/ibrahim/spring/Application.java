package com.ibrahim.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "com.ibrahim.spring.lesson10.task02_specification_and_dynamic_queries"
)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
