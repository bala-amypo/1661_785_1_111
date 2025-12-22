package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchResultRepository matchRepo;

    @Override
    public MatchResult createMatch(StudentProfile studentA, StudentProfile studentB, double score) {
        MatchResult result = new MatchResult();
        result.setStudentA(studentA);
        result.setStudentB(studentB);
        result.setScore(score);
        return matchRepo.save(result);
    }

    @Override
    public List<MatchResult> getMatchesForStudent(Long studentId) {
        return matchRepo.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }
}
