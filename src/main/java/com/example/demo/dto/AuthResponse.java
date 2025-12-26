package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;

    // No-arg constructor
    public AuthResponse() {}

    // Constructor for token response
    public AuthResponse(String token) {
        this.token = token;
    }
}
