package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {

        if (habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours must be non-negative");
        }

        Optional<HabitProfile> existing = repository.findByStudentId(habit.getStudentId());

        if (existing.isPresent()) {
            HabitProfile h = existing.get();
            h.setStudyHoursPerDay(habit.getStudyHoursPerDay());
            h.setSleepSchedule(habit.getSleepSchedule());
            h.setCleanlinessLevel(habit.getCleanlinessLevel());
            h.setNoiseTolerance(habit.getNoiseTolerance());
            h.setSocialPreference(habit.getSocialPreference());
            h.setUpdatedAt(LocalDateTime.now());
            return repository.save(h);
        }

        habit.setCreatedAt(LocalDateTime.now());
        habit.setUpdatedAt(LocalDateTime.now());
        return repository.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Habit profile not found"));
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }
}
