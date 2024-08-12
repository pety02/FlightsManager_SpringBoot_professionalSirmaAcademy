package com.example.flightsmanager.controllers;

import com.example.flightsmanager.dtoes.LoginUserDTO;
import com.example.flightsmanager.dtoes.UserDTO;
import com.example.flightsmanager.services.interfaces.UserService;
import com.example.flightsmanager.utils.UserValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.validation.BindingResult.MODEL_KEY_PREFIX;

@Controller
@Slf4j
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDTO userDTO,
                           final BindingResult binding,
                           Model model,
                           RedirectAttributes redirectAttributes,
                           HttpSession httpSession) {
        // TODO: to add simple validation if there is logged in user and so on.
        if(UserValidator.hesLoggedInUser(httpSession)) {
            httpSession.invalidate();
        }
        if (binding.hasErrors()) {
            log.error("Error registering user: {}", binding.getAllErrors());
            redirectAttributes.addFlashAttribute("user", userDTO);
            redirectAttributes.addFlashAttribute(MODEL_KEY_PREFIX + "user", binding);
            return "redirect:/register";
        }
        try {
            UserDTO registeredUser = userService.register(userDTO);

            if (registeredUser == null) {
                String errors = "Unsuccessful registration because of incorrect registration data!";
                redirectAttributes.addFlashAttribute("errors", errors);

                if (!redirectAttributes.containsAttribute("user")) {
                    redirectAttributes.addFlashAttribute("user", userDTO);
                }
                return "redirect:/register";
            }

            if (!redirectAttributes.containsAttribute("user")) {
                redirectAttributes.addFlashAttribute("user", userDTO);
            }
            return "redirect:/login";
        } catch (Exception ex) {
            if (!redirectAttributes.containsAttribute("user")) {
                redirectAttributes.addFlashAttribute("user", userDTO);
            }
            return "redirect:/register";
        }
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginUserDTO user,
                        final BindingResult binding,
                        Model model,
                        RedirectAttributes redirectAttributes,
                        HttpSession httpSession) {
        // TODO: to add simple validation if there is logged in user and so on.
        if (UserValidator.hesLoggedInUser(httpSession)) {
            httpSession.invalidate();
        }
        if (binding.hasErrors()) {
            log.error("Error logging user in: {}", binding.getAllErrors());
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute(MODEL_KEY_PREFIX + "user", binding);
            return "redirect:/login";
        }
        try {
            LoginUserDTO loggedInUser = userService.login(user);
            if (loggedInUser == null) {
                String errors = "Invalid user credentials.";
                redirectAttributes.addAttribute("errors", errors);
                return "redirect:/login";
            }
            httpSession.setAttribute("user", loggedInUser);

            return "redirect:/home";
        } catch (Exception e) {
            if (!model.containsAttribute("user")) {
                model.addAttribute("user", user);
            }
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}