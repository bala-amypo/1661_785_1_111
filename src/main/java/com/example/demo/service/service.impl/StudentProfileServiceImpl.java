package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {
    private final StudentProfileRepository repo;

    @Override
    public StudentProfile save(StudentProfile s) { return repo.save(s); }

    @Override
    public List<StudentProfile> getAll() { return repo.findAll(); }

    @Override
    public StudentProfile getById(Long id) { return repo.findById(id).orElse(null); }

    @Override
    public void delete(Long id) { repo.deleteById(id); }
}
