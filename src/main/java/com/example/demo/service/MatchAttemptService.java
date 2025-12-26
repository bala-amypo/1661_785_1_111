package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface MatchAttemptService {
    MatchAttemptRecord saveAttempt(MatchAttemptRecord attempt);
    MatchAttemptRecord getAttemptById(Long id) throws ResourceNotFoundException;
    List<MatchAttemptRecord> getAllAttempts();
}
