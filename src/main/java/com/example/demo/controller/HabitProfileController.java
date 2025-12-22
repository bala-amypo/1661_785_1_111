package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;

@RestController
@RequestMapping("/habit")
public class HabitProfileController {

    @Autowired
    private HabitProfileService service;

    @PostMapping
    public HabitProfile createHabit(@RequestBody HabitProfile habit) {
        return service.save(habit);
    }

    @GetMapping
    public List<HabitProfile> getAllHabits() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HabitProfile getHabitById(@PathVariable Long id) throws Exception {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteHabit(@PathVariable Long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
