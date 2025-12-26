package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile student) {
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}/status")
    public StudentProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateStudentStatus(id, active);
    }
}
