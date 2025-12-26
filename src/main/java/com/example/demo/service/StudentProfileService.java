package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface StudentProfileService {
    StudentProfile saveStudentProfile(StudentProfile studentProfile);
    StudentProfile getStudentProfileById(Long id) throws ResourceNotFoundException;
    List<StudentProfile> getAllStudentProfiles();
}
