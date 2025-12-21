package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.repository.StudentProfileRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchResultRepository matchRepo;
    private final StudentProfileRepository studentRepo;
    private final HabitProfileRepository habitRepo;

    public MatchServiceImpl(MatchResultRepository matchRepo,
                            StudentProfileRepository studentRepo,
                            HabitProfileRepository habitRepo) {
        this.matchRepo = matchRepo;
        this.studentRepo = studentRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public MatchResult computeMatch(Long studentAId, Long studentBId) {

        StudentProfile a = studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        StudentProfile b = studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile habitA = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        HabitProfile habitB = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = 100 - Math.abs(habitA.getCleanlinessLevel() - habitB.getCleanlinessLevel())
                - Math.abs(habitA.getNoisePreference() - habitB.getNoisePreference());
        if(score < 0) score = 0;
        if(score > 100) score = 100;

        MatchResult result = new MatchResult();
        result.setStudentA(a);
        result.setStudentB(b);
        result.setScore(score);

        return matchRepo.save(result);
    }

    @Override
    public List<MatchResult> getMatchesFor(Long studentId) {
        return matchRepo.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }
}
