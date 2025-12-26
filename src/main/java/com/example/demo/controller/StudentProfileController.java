package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student-profile")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public StudentProfile saveStudentProfile(@RequestBody StudentProfile studentProfile) {
        return service.saveStudentProfile(studentProfile);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentProfile(@PathVariable Long id) {
        return service.getStudentProfileById(id);
    }

    @GetMapping("/all")
    public List<StudentProfile> getAllProfiles() {
        return service.getAllStudentProfiles();
    }
}
