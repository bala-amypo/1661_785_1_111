package com.example.demo.repository;

import com.example.demo.model.CompatibilityScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompatibilityScoreRecordRepository
        extends JpaRepository<CompatibilityScoreRecord, Long> {

    // already used
    List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(
            Long studentAId,
            Long studentBId
    );

    // 👉 ADD THIS (FOR YOUR CURRENT ERROR)
    Optional<CompatibilityScoreRecord> findByStudentAIdAndStudentBId(
            Long studentAId,
            Long studentBId
    );
}
