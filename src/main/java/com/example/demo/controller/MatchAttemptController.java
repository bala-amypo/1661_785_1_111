package com.example.demo.controller;

import com.example.demo.entity.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/match-attempt")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public MatchAttemptRecord saveAttempt(@RequestBody MatchAttemptRecord attempt) {
        return service.saveAttempt(attempt);
    }

    @GetMapping("/{id}")
    public MatchAttemptRecord getAttempt(@PathVariable Long id) {
        return service.getAttemptById(id);
    }

    @GetMapping("/all")
    public List<MatchAttemptRecord> getAllAttempts() {
        return service.getAllAttempts();
    }
}
