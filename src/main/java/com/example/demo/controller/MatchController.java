package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/api/matches/compute")
    public MatchResult compute(@RequestParam Long studentAId, @RequestParam Long studentBId) {
        return service.computeMatch(studentAId, studentBId);
    }

    @GetMapping("/api/matches/student/{studentId}")
    public List<MatchResult> getMatches(@PathVariable Long studentId) {
        return service.getMatchesFor(studentId);
    }
}
