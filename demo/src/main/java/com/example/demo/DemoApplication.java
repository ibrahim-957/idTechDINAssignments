package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        String password = "123654";
        String hashed = new BCryptPasswordEncoder().encode(password);
        System.out.println(hashed);

    }

}
