package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service){ this.service = service; }

    @PostMapping("/save")
    public ResponseEntity<StudentProfile> create(@RequestBody StudentProfile s){
        StudentProfile created = service.createStudent(s);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentProfile>> getAll(){
        return ResponseEntity.ok(service.getAllStudents());
    }
}
