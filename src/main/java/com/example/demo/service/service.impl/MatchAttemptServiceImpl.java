package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;

import java.util.List;
import java.util.Optional;

public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo, CompatibilityScoreRecordRepository scoreRepo) {
        this.repo = repo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        // If there is a computed score, mark as MATCHED, else PENDING_REVIEW
        if (attempt.getResultScoreId() != null) {
            Optional<CompatibilityScoreRecord> score = scoreRepo.findById(attempt.getResultScoreId());
            attempt.setStatus(score.isPresent() ? MatchAttemptRecord.Status.MATCHED : MatchAttemptRecord.Status.PENDING_REVIEW);
        } else {
            attempt.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }

        return repo.save(attempt);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long attemptId, String statusStr) {
        MatchAttemptRecord attempt = repo.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Match attempt not found"));

        MatchAttemptRecord.Status status;
        try {
            status = MatchAttemptRecord.Status.valueOf(statusStr);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid status value");
        }

        attempt.setStatus(status);
        return repo.save(attempt);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return repo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }
}
