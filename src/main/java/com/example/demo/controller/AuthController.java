package com.example.demo.controller;

import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) { return new AuthResponse("dummy-token"); }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest req) { return new AuthResponse("registered-token"); }
}
