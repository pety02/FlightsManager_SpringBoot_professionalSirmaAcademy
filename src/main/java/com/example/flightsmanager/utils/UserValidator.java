package com.example.flightsmanager.utils;

import jakarta.servlet.http.HttpSession;

public class UserValidator {
    public static boolean hesLoggedInUser(HttpSession httpSession) {
        return httpSession.getAttribute("user") != null;
    }
}