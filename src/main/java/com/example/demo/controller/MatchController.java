package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService service;

    @PostMapping
    public MatchResult createMatch(@RequestBody MatchResult match) {
        return service.createMatch(match.getStudentA(), match.getStudentB(), match.getScore());
    }

    @GetMapping("/student/{id}")
    public List<MatchResult> getMatches(@PathVariable Long id) {
        return service.getMatchesForStudent(id);
    }
}
