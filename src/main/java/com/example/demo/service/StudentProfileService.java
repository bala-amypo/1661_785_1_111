package com.example.demo.service;

import java.util.List;
import com.example.demo.model.StudentProfile;

public interface StudentProfileService {
    StudentProfile save(StudentProfile student);
    List<StudentProfile> getAll();
    StudentProfile getById(Long id);
    void deleteById(Long id);
}
