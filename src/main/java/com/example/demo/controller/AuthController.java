package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
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
        
        AuthResponse response = new AuthResponse();
        response.setToken(jwtUtil.generateToken(request.getUsername(), request.getRole(), request.getEmail(), "1"));
        response.setUserId("1");
        response.setEmail(request.getEmail());
        response.setRole(request.getRole());
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if (!users.containsKey(request.getUsername())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        
        AuthResponse response = new AuthResponse();
        response.setToken(jwtUtil.generateToken(request.getUsername(), "USER", request.getUsername() + "@example.com", "1"));
        response.setUserId("1");
        response.setEmail(request.getUsername() + "@example.com");
        response.setRole("USER");
        
        return ResponseEntity.ok(response);
    }
}