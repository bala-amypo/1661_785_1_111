package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentProfileController {
    private final StudentProfileService service;

    @PostMapping("/save")
    public StudentProfile save(@RequestBody StudentProfile s){ return service.save(s); }

    @GetMapping("/all")
    public List<StudentProfile> getAll(){ return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getById(@PathVariable Long id){ return ResponseEntity.ok(service.getById(id)); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}
