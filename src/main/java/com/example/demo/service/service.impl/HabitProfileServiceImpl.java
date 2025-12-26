package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile h) {

        if (h.getStudyHoursPerDay() != null && h.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours cannot be negative");
        }

        Optional<HabitProfile> existingOpt = repo.findByStudentId(h.getStudentId());
        if (existingOpt.isPresent()) {
            HabitProfile existing = existingOpt.get();
            h.setId(existing.getId());
        }

        h.setUpdatedAt(LocalDateTime.now());
        return repo.save(h);
    }

    @Override
    public Optional<HabitProfile> getHabitByStudent(Long studentId) {
        HabitProfile h = repo.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        return Optional.of(h);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repo.findAll();
    }
}
