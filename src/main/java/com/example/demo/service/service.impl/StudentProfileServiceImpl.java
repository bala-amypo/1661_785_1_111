package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) { this.repo = repo; }

    @Override
    public StudentProfile createStudent(StudentProfile s) {
        repo.findByStudentId(s.getStudentId()).ifPresent(st -> { throw new IllegalArgumentException("studentId exists"); });
        repo.findByEmail(s.getEmail()).ifPresent(st -> { throw new IllegalArgumentException("email exists"); });
        return repo.save(s);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile s = getStudentById(id);
        s.setActive(active);
        return repo.save(s);
    }

    @Override
    public List<StudentProfile> getAllStudents() { return repo.findAll(); }

    @Override
    public Optional<StudentProfile> findByStudentId(String studentId) { return repo.findByStudentId(studentId); }
}
