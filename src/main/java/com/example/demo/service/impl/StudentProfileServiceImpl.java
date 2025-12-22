package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository repository;

    @Override
    public StudentProfile save(StudentProfile student) {
        return repository.save(student);
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public StudentProfile getById(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
