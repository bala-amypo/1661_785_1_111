package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private static final Map<String, AuthRequest> USERS = new HashMap<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest req) {

        if (USERS.containsKey(req.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        USERS.put(req.getUsername(), req);

        String token = jwtUtil.generateToken(
                req.getUsername(),
                req.getRole(),
                req.getEmail(),
                "1"
        );

        return ResponseEntity.ok(token);
    }
}
