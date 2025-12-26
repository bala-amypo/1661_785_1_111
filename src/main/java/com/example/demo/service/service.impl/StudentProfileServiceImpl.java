package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
        return repository.save(studentProfile);
    }

    @Override
    public StudentProfile getStudentProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found with id: " + id));
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return repository.findAll();
    }
}
