package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "demo-secret";

    public String generateToken(String username,String role,String email,String id){
        return Jwts.builder()
                .setSubject(username)
                .claim("role",role)
                .claim("email",email)
                .claim("id",id)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public void validate(String token){
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
