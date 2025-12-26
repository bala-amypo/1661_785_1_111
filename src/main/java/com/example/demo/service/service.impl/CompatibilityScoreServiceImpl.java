package com.example.demo.service.impl;

import com.example.demo.entity.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {
    private final CompatibilityScoreRecordRepository repo;

    @Override
    public CompatibilityScoreRecord save(CompatibilityScoreRecord s) { return repo.save(s); }
}
