package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {

    StudentProfile create(StudentProfile profile);
    StudentProfile getById(Long id);
    List<StudentProfile> getAll();
}
