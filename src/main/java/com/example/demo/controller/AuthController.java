package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    // simple in-memory user store (for demo / review purpose)
    private final Map<String, AuthRequest> users = new ConcurrentHashMap<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * REGISTER
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {

        if (users.containsKey(request.getUsername())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User already exists");
        }

        users.put(request.getUsername(), request);
        return ResponseEntity.ok("User registered successfully");
    }

    /**
     * LOGIN
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        AuthRequest storedUser = users.get(request.getUsername());

        if (storedUser == null ||
                !storedUser.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                request.getUsername(),
                storedUser.getRole(),
                storedUser.getEmail(),
                "1"
        );

        return ResponseEntity.ok(token);
    }
}
