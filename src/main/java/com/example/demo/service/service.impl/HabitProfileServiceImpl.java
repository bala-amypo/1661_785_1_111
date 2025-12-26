package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;

    @Autowired
    public HabitProfileServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("Study hours cannot be negative");
        }
        Optional<HabitProfile> existing = habitRepo.findByStudentId(habit.getStudentId());
        if (existing.isPresent()) {
            habit.setId(existing.get().getId()); // update existing
        }
        return habitRepo.save(habit);
    }

    @Override
    public Optional<HabitProfile> getHabitByStudentId(Long studentId) {
        return habitRepo.findByStudentId(studentId);
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return habitRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HabitProfile not found with id " + id));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return habitRepo.findAll();
    }

    @Override
    public void deleteHabit(Long id) {
        HabitProfile habit = habitRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HabitProfile not found with id " + id));
        habitRepo.delete(habit);
    }
}
