package com.example.demo.service.impl;

import com.example.demo.entity.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitProfileServiceImpl implements HabitProfileService {
    private final HabitProfileRepository repo;

    @Override
    public HabitProfile save(HabitProfile h) { return repo.save(h); }

    @Override
    public HabitProfile getHabitById(Long id) { return repo.findById(id).orElse(null); }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) { return repo.findByStudentId(studentId).orElse(null); }

    @Override
    public void deleteHabit(Long id) { repo.deleteById(id); }
}
