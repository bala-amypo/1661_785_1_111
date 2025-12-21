package com.example.demo.repository;

import com.example.demo.model.HabitProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {
    Optional<HabitProfile> findByStudentId(Long studentId);
}
