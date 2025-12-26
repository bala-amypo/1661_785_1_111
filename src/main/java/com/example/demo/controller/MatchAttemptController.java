package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/match")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service){ this.service = service; }

    @PostMapping("/log")
    public ResponseEntity<MatchAttemptRecord> log(@RequestBody MatchAttemptRecord m){
        return ResponseEntity.ok(service.logMatchAttempt(m));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<MatchAttemptRecord>> getByStudent(@PathVariable Long id){
        return ResponseEntity.ok(service.getAttemptsByStudent(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MatchAttemptRecord>> getAll(){
        return ResponseEntity.ok(service.getAllMatchAttempts());
    }
}
