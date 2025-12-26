package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Stub for generating token (adjust as needed)
    public String generateToken(String username) {
        // TODO: Implement real JWT generation
        return "dummy-token-for-" + username;
    }

    // Overloaded version used in your controller (stub)
    public String generateToken(String a, String b, String c, String d) {
        // TODO: implement proper token generation logic
        return "dummy-token";
    }

    // Extract username from token
    public String extractUsername(String token) {
        // TODO: implement real parsing
        return "demoUser";
    }

    // Validate token
    public boolean validate(String token) {
        // TODO: implement real JWT validation
        return true;
    }

    // Optional: validate token with username (stub)
    public boolean isTokenValid(String token, String username) {
        // TODO: implement proper validation
        return true;
    }
}
