package com.example.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    // GET http://localhost:8080/api/hello
    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello, Spring Boot!");
    }

    // GET http://localhost:8080/api/hello/greet?name=Ivan
    @GetMapping("/api/hello/greet")
    public Map<String, String> greet(@RequestParam(defaultValue = "World") String name) {
        return Map.of("message", "Hello, " + name + "!");
    }
}
