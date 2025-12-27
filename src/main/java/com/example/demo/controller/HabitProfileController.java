package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {
    private final HabitProfileService service;
    
    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getHabitByStudent(studentId));
    }
}