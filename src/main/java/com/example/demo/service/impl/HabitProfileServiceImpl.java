package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    @Autowired
    private HabitProfileRepository repository;

    @Override
    public HabitProfile save(HabitProfile habit) {
        return repository.save(habit);
    }

    @Override
    public List<HabitProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public HabitProfile getById(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("HabitProfile not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
