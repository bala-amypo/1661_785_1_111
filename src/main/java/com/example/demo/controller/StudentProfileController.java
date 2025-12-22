package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService service;

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile student) {
        return service.save(student);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return "Student deleted successfully with id " + id;
    }
}
