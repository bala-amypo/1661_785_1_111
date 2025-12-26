package com.example.demo.repository;

import com.example.demo.model.CompatibilityScoreRecord;

import java.util.List;
import java.util.Optional;

public interface CompatibilityScoreRecordRepository {

    Optional<CompatibilityScoreRecord> findByStudentAIdAndStudentBId(Long aId, Long bId);

    List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(Long studentId1, Long studentId2);

    Optional<CompatibilityScoreRecord> findById(Long id);

    List<CompatibilityScoreRecord> findAll();

    CompatibilityScoreRecord save(CompatibilityScoreRecord r);
}
