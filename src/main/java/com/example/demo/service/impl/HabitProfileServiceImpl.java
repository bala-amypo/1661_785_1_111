package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile create(HabitProfile habit) {
        return repo.save(habit);
    }

    @Override
    public HabitProfile update(Long id, HabitProfile habit) {
        HabitProfile existing = getById(id);
        habit.setId(existing.getId());
        return repo.save(habit);
    }

    @Override
    public HabitProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }

    @Override
    public List<HabitProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
