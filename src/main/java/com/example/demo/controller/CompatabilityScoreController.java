package com.example.demo.controller;

import com.example.demo.entity.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compatibility")
@RequiredArgsConstructor
public class CompatibilityScoreController {
    private final CompatibilityScoreService service;

    @PostMapping("/save")
    public CompatibilityScoreRecord save(@RequestBody CompatibilityScoreRecord s){ return service.save(s); }
}
