package com.example.demo.repository;

import com.example.demo.model.HabitProfile;

import java.util.List;
import java.util.Optional;

public interface HabitProfileRepository {

    Optional<HabitProfile> findByStudentId(Long studentId);

    Optional<HabitProfile> findById(Long id);

    List<HabitProfile> findAll();

    HabitProfile save(HabitProfile h);
}
