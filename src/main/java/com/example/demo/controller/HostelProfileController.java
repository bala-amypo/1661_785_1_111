package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping
    public HabitProfile create(@RequestBody HabitProfile h) {
        return service.create(h);
    }

    @GetMapping("/{id}")
    public HabitProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<HabitProfile> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public HabitProfile update(@PathVariable Long id,
                               @RequestBody HabitProfile h) {
        return service.update(id, h);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
