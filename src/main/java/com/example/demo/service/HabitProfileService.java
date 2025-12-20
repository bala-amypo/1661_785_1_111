package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileService(HabitProfileRepository repo) {
        this.repo = repo;
    }

    public HabitProfile create(HabitProfile h) {
        return repo.save(h);
    }

    public HabitProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }

    public List<HabitProfile> getAll() {
        return repo.findAll();
    }

    public HabitProfile update(Long id, HabitProfile updated) {
        HabitProfile h = getById(id);
        h.setSmoking(updated.isSmoking());
        h.setDrinking(updated.isDrinking());
        h.setCleanlinessLevel(updated.getCleanlinessLevel());
        return repo.save(h);
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}