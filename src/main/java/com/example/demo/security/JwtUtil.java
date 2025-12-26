package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String secret = "mySecretKey";

    public String generateToken(String username, String role, String email, String userId) {
        return "jwt.token." + username + "." + role + "." + email + "." + userId;
    }

    public boolean validate(String token) {
        if (token == null || !token.startsWith("jwt.token.")) {
            throw new RuntimeException("Invalid token");
        }
        return true;
    }

    public String extractUsername(String token) {
        String[] parts = token.split("\\.");
        return parts.length > 2 ? parts[2] : null;
    }
}