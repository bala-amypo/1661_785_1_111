package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final Map<String, String> users = new HashMap<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        if (users.containsKey(request.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        users.put(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        String token = jwtUtil.generateToken(
            request.getUsername(), 
            request.getRole() != null ? request.getRole() : "USER",
            request.getEmail(),
            "1"
        );
        return ResponseEntity.ok(Map.of("token", token));
    }
}