package com.example.demo.service;

import com.example.demo.model.StudentProfile;

import java.util.List;
import java.util.Optional;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile s);

    StudentProfile updateStudentStatus(Long id, boolean active);

    StudentProfile getStudentById(Long id);

    List<StudentProfile> getAllStudents();

    Optional<StudentProfile> findByStudentId(String studentId);
}
