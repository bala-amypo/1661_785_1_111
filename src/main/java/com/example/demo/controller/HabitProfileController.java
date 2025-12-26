package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/habit")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service){ this.service = service; }

    @PostMapping("/save")
    public ResponseEntity<HabitProfile> save(@RequestBody HabitProfile h){
        return ResponseEntity.ok(service.createOrUpdateHabit(h));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getById(@PathVariable Long id){
        return ResponseEntity.of(service.getHabitById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long studentId){
        return ResponseEntity.ok(service.getHabitByStudent(studentId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<HabitProfile>> getAll(){
        return ResponseEntity.ok(service.getAllHabitProfiles());
    }
}
