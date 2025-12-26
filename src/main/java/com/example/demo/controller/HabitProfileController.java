package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit")
public class HabitProfileController {

    private final HabitProfileService habitService;

    @Autowired
    public HabitProfileController(HabitProfileService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/")
    public ResponseEntity<HabitProfile> createOrUpdate(@RequestBody HabitProfile habit) {
        HabitProfile saved = habitService.createOrUpdateHabit(habit);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long studentId) {
        HabitProfile habit = habitService.getHabitByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "HabitProfile not found for studentId " + studentId));
        return ResponseEntity.ok(habit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getById(@PathVariable Long id) {
        HabitProfile habit = habitService.getHabitById(id);
        return ResponseEntity.ok(habit);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HabitProfile>> getAll() {
        return ResponseEntity.ok(habitService.getAllHabitProfiles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
