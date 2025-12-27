package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
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
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        if (users.containsKey(request.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        users.put(request.getUsername(), request.getPassword());
        AuthResponse response = new AuthResponse();
        response.setMessage("User registered successfully");
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = jwtUtil.generateToken(request.getUsername(), 
            request.getRole() != null ? request.getRole() : "USER", 
            request.getEmail(), "1");
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return ResponseEntity.ok(response);
    }
}