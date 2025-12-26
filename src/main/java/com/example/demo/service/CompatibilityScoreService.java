package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScoreRecord saveScore(CompatibilityScoreRecord score);
    CompatibilityScoreRecord getScoreById(Long id) throws ResourceNotFoundException;
    List<CompatibilityScoreRecord> getAllScores();
}
