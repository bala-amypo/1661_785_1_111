package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;

    public AuthServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount register(UserAccount user) {
        repo.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("email already exists");
        });
        return repo.save(user);
    }

    @Override
    public UserAccount login(String email, String password) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
