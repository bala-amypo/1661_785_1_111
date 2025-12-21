package com.example.demo.service;

import java.util.List;
import com.example.demo.model.MatchResult;

public interface MatchService {

    MatchResult computeMatch(Long studentAId, Long studentBId);

    List<MatchResult> getMatchesFor(Long studentId);

    MatchResult getById(Long id);
}
