package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile saveHabitProfile(HabitProfile habitProfile) {
        return repository.save(habitProfile);
    }

    @Override
    public HabitProfile getHabitProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HabitProfile not found with id: " + id));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }
}
