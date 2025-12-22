package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/student")
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
    public StudentProfile getStudentById(@PathVariable Long id) throws Exception {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
