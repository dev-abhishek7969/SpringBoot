package com.code.snippet.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @GetMapping("/hello")
    public String getWelcomeMsg(){
        return "This is a welcome message from controller.!!";
    }
}
