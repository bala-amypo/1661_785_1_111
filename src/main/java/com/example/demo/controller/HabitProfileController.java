package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        profile.setStudent(profile.getStudent());
        return service.createOrUpdate(profile);
    }

    @GetMapping("/api/habits/{studentId}")
    public HabitProfile get(@PathVariable Long studentId) {
        return service.getByStudentId(studentId);
    }

    @DeleteMapping("/api/habits/{studentId}")
    public String delete(@PathVariable Long studentId) {
        service.deleteByStudentId(studentId);
        return "Deleted Successfully!";
    }
}
