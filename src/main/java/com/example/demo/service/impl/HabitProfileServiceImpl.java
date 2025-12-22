package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public StudentProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        StudentProfile existing = getById(id); // will throw exception if not found
        repository.delete(existing);
    }
}
