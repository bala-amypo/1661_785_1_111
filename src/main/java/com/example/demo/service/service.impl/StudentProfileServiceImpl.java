package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

import java.util.List;
import java.util.Optional;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile s) {

        repo.findByStudentId(s.getStudentId()).ifPresent(existing -> {
            throw new IllegalArgumentException("studentId exists");
        });

        repo.findByEmail(s.getEmail()).ifPresent(existing -> {
            throw new IllegalArgumentException("email exists");
        });

        return repo.save(s);
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        s.setActive(active);
        return repo.save(s);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Optional<StudentProfile> findByStudentId(String studentId) {
        return repo.findByStudentId(studentId);
    }
}
