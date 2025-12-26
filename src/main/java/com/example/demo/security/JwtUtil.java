package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "mysecretkey"; // change to your secret

    // Updated method to accept extra claims
    public String generateToken(String username, String firstName, String lastName, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("firstName", firstName)
                .claim("lastName", lastName)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    // Optional: simple token validation method
    public boolean isTokenValid(String token, String username) {
        String tokenUsername = Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return tokenUsername.equals(username);
    }
}
