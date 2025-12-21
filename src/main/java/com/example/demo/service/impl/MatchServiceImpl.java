package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MatchResult;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchResultRepository repo;

    public MatchServiceImpl(MatchResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public MatchResult computeMatch(Long studentAId, Long studentBId) {
        MatchResult result = new MatchResult();
        result.setScore(50.0); // fixed score for now
        return repo.save(result);
    }

    @Override
    public List<MatchResult> getMatchesFor(Long studentId) {
        return repo.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }

    @Override
    public MatchResult getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
}
