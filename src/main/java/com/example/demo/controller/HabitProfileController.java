package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habit")
public class HabitProfileController {

    private final HabitProfileService habitService;

    public HabitProfileController(HabitProfileService habitService) {
        this.habitService = habitService;
    }

    // Create or update habit profile
    @PostMapping("/")
    public ResponseEntity<HabitProfile> createOrUpdate(@RequestBody HabitProfile habit) {
        HabitProfile saved = habitService.createOrUpdateHabit(habit);
        return ResponseEntity.ok(saved);
    }

    // Get habit profile by studentId
    @GetMapping("/student/{studentId}")
    public ResponseEntity<HabitProfile> getByStudent(@PathVariable Long studentId) {
        // Unwrap Optional safely
        HabitProfile habit = habitService.getHabitByStudent(studentId);
        return ResponseEntity.ok(habit);
    }

    // Get habit profile by habitId
    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getById(@PathVariable Long id) {
        HabitProfile habit = habitService.getHabitById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HabitProfile not found with id " + id));
        return ResponseEntity.ok(habit);
    }

    // List all habit profiles
    @GetMapping("/all")
    public ResponseEntity<Iterable<HabitProfile>> getAll() {
        return ResponseEntity.ok(habitService.getAllHabitProfiles());
    }

    // Delete habit profile by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
