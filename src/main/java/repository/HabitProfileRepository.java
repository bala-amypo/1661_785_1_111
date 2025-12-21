package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HabitProfile;

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {
    Optional<HabitProfile> findByStudentId(Long studentId);
}
