package com.example.task.controller;

import com.example.task.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping
    public String hello() {
        return helloService.getGreeting(null);
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return helloService.getGreeting(name);
    }

    @GetMapping("/status")
    public String status() {
        return helloService.getStatus();
    }
}
