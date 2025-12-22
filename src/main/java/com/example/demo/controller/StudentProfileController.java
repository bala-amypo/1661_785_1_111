package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/student")
public class StudentProfileController {

    @Autowired
    private StudentProfileService service;

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile student) {
        return service.save(student);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "Student deleted with id: " + id;
    }
}
