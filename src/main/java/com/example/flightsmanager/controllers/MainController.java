package com.example.flightsmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "redirect:/login";
    }
}