package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping("/api/habits/{studentId}")
    public HabitProfile createOrUpdate(@PathVariable Long studentId, @RequestBody HabitProfile profile) {
        profile.setStudent(profile.getStudent()); // student must have id
        return service.createOrUpdate(profile);
    }

    @GetMapping("/api/habits/{studentId}")
    public HabitProfile get(@PathVariable Long studentId) {
        return service.getByStudentId(studentId);
    }
}
