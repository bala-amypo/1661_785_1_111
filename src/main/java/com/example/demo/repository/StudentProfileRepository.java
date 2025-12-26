package com.example.demo.repository;

import com.example.demo.model.StudentProfile;
import java.util.List;
import java.util.Optional;

public interface StudentProfileRepository {

    Optional<StudentProfile> findByStudentId(String studentId);

    Optional<StudentProfile> findByEmail(String email);

    Optional<StudentProfile> findById(Long id);

    List<StudentProfile> findAll();

    StudentProfile save(StudentProfile s);
}
