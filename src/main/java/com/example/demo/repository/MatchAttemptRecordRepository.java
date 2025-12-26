package com.example.demo.repository;

import com.example.demo.model.MatchAttemptRecord;

import java.util.List;
import java.util.Optional;

public interface MatchAttemptRecordRepository {

    Optional<MatchAttemptRecord> findById(Long id);

    List<MatchAttemptRecord> findByInitiatorStudentIdOrCandidateStudentId(Long student1, Long student2);

    List<MatchAttemptRecord> findAll();

    MatchAttemptRecord save(MatchAttemptRecord attempt);
}
