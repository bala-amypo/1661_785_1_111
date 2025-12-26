package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttemptRecord saveAttempt(MatchAttemptRecord attempt) {
        return repository.save(attempt);
    }

    @Override
    public MatchAttemptRecord getAttemptById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MatchAttemptRecord not found with id: " + id));
    }

    @Override
    public List<MatchAttemptRecord> getAllAttempts() {
        return repository.findAll();
    }
}
