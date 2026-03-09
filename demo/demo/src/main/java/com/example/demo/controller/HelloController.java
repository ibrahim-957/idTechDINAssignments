package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

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
