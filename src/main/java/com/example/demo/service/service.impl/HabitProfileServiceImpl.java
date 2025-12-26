package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;
    public HabitProfileServiceImpl(HabitProfileRepository repo){ this.repo=repo; }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile h) {
        if(h.getStudyHoursPerDay()!=null && h.getStudyHoursPerDay()<0)
            throw new IllegalArgumentException("study hours invalid");

        HabitProfile existing = repo.findByStudentId(h.getStudentId()).orElse(null);
        if(existing!=null){
            h.setId(existing.getId());
        }
        h.setUpdatedAt(java.time.LocalDateTime.now());
        return repo.save(h);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) { return repo.findById(id); }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repo.findByStudentId(studentId).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() { return repo.findAll(); }
}
