package com.example.demo.service;

import java.util.List;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;

public interface MatchService {
    MatchResult createMatch(StudentProfile studentA, StudentProfile studentB, double score);
    List<MatchResult> getMatchesForStudent(Long studentId);
}
