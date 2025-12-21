package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping("/api/students")
    public StudentProfile create(@RequestBody StudentProfile profile) {
        return service.create(profile);
    }

    @GetMapping("/api/students/{id}")
    public StudentProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/api/students")
    public List<StudentProfile> getAll() {
        return service.getAll();
    }
}
