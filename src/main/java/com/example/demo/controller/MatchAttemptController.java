package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchAttemptController {
    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MatchAttemptRecord> log(@RequestBody MatchAttemptRecord attempt) {
        return ResponseEntity.ok(service.logMatchAttempt(attempt));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<MatchAttemptRecord> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateAttemptStatus(id, status));
    }
}