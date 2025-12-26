package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/habit-profile")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public HabitProfile saveHabitProfile(@RequestBody HabitProfile habitProfile) {
        return service.saveHabitProfile(habitProfile);
    }

    @GetMapping("/{id}")
    public HabitProfile getHabitProfile(@PathVariable Long id) {
        return service.getHabitProfileById(id);
    }

    @GetMapping("/all")
    public List<HabitProfile> getAllHabitProfiles() {
        return service.getAllHabitProfiles();
    }
}
