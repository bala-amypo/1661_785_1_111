package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile create(StudentProfile profile) {
        if (profile.getAge() <= 0) {
            throw new IllegalArgumentException("age must be > 0");
        }
        return repo.save(profile);
    }

    @Override
    public StudentProfile get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repo.findAll();
    }
}
