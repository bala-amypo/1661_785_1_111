package com.example.demo.controller;

import com.example.demo.entity.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchAttemptController {
    private final MatchAttemptService service;

    @PostMapping("/save")
    public MatchAttemptRecord save(@RequestBody MatchAttemptRecord m){ return service.save(m); }
}
