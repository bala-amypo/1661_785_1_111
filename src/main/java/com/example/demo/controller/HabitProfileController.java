package com.example.demo.controller;

import com.example.demo.entity.HabitProfile;
import com.example.demo.service.HabitProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/habit")
@RequiredArgsConstructor
public class HabitProfileController {
    private final HabitProfileService service;

    @PostMapping("/save")
    public HabitProfile save(@RequestBody HabitProfile h){ return service.save(h); }

    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getById(@PathVariable Long id){ return ResponseEntity.ok(service.getHabitById(id)); }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long studentId){ return ResponseEntity.ok(service.getHabitByStudent(studentId)); }
}
