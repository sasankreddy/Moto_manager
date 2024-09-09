package com.example.rentalmanager.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/session")
public class SessionController {

    // Endpoint to handle user login
    @PostMapping("/login")
    public String login(@RequestParam String username, HttpSession session) {
        // Assuming the login process is successful
        session.setAttribute("isLoggedIn", true);
        session.setAttribute("username", username);
        return "Logged in successfully!";
    }

    // Endpoint to handle user logout
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Ends the session
        return "Logged out successfully!";
    }

    // Endpoint to check login status
    @GetMapping("/status")
    public boolean isLoggedIn(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        return isLoggedIn != null && isLoggedIn;
    }
}
