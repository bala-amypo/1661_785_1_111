package com.example.demo.service.impl;

import com.example.demo.entity.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchAttemptServiceImpl implements MatchAttemptService {
    private final MatchAttemptRecordRepository repo;

    @Override
    public MatchAttemptRecord save(MatchAttemptRecord m) { return repo.save(m); }
}
