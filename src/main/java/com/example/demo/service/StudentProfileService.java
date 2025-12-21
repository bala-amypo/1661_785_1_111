package com.example.demo.service;

import java.util.List;
import com.example.demo.model.StudentProfile;

public interface StudentProfileService {

    StudentProfile create(StudentProfile profile);

    StudentProfile get(Long id);

    List<StudentProfile> getAll();
}
