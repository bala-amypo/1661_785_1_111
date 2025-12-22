package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile save(StudentProfile student);
    List<StudentProfile> getAll();
    StudentProfile getById(Long id);
    void deleteById(Long id);
}
