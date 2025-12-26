package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompatibilityScoreRecord saveScore(CompatibilityScoreRecord score) {
        return repository.save(score);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompatibilityScoreRecord not found with id: " + id));
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return repository.findAll();
    }
}
