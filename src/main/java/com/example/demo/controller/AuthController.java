package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ConcurrentHashMap;

@Controller
public class AuthController {

    private final JwtUtil jwtUtil;

    private final ConcurrentHashMap<String, AuthRequest> users = new ConcurrentHashMap<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Register a user (mock)
    public ResponseEntity<?> register(AuthRequest request) {
        if (users.containsKey(request.getUsername())) {
            return ResponseEntity.badRequest().body("User exists");
        }
        users.put(request.getUsername(), request);
        return ResponseEntity.ok("Registered");
    }

    // Login
    public ResponseEntity<?> login(AuthRequest request) {
        AuthRequest user = users.get(request.getUsername());
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole(), user.getEmail(), "1");
        return ResponseEntity.ok(token);
    }
}
