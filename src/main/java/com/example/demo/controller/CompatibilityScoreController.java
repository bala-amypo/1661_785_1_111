package com.example.demo.controller;

import com.example.demo.entity.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compatibility-score")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public CompatibilityScoreRecord saveScore(@RequestBody CompatibilityScoreRecord score) {
        return service.saveScore(score);
    }

    @GetMapping("/{id}")
    public CompatibilityScoreRecord getScore(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @GetMapping("/all")
    public List<CompatibilityScoreRecord> getAllScores() {
        return service.getAllScores();
    }
}
