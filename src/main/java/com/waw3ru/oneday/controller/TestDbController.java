package com.waw3ru.oneday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDbController {
    @GetMapping("/test-db")
    public String testDb() {
        return "test-db endpoint OK";
    }
}