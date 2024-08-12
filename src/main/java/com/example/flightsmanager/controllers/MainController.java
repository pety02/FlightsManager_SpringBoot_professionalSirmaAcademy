package com.example.flightsmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/register")
    public String getRegisterForm() {
        return "register";
    }

    @GetMapping("/")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }
}