package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final Map<String, AuthRequest> users = new HashMap<>();

    public AuthController(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;

        // Seeded admin
        AuthRequest admin = new AuthRequest();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole("ADMIN");
        admin.setEmail("admin@example.com");
        users.put("admin", admin);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest req){
        if(users.containsKey(req.getUsername())){
            return ResponseEntity.badRequest().body("User already exists");
        }
        users.put(req.getUsername(), req);
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req){
        AuthRequest user = users.get(req.getUsername());
        if(user==null || !user.getPassword().equals(req.getPassword())){
            return ResponseEntity.status(401).build();
        }
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole(), user.getEmail(), "1");
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
