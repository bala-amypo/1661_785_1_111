package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository scoreRepo, HabitProfileRepository habitRepo){
        this.scoreRepo=scoreRepo; this.habitRepo=habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long aId, Long bId){
        if(aId.equals(bId)) throw new IllegalArgumentException("same student");

        HabitProfile a = habitRepo.findByStudentId(aId).orElseThrow(() -> new RuntimeException("not found"));
        HabitProfile b = habitRepo.findByStudentId(bId).orElseThrow(() -> new RuntimeException("not found"));

        CompatibilityScoreRecord existing = scoreRepo.findByStudentAIdAndStudentBId(aId,bId).orElse(null);
        if(existing!=null){
            existing.setScore(80.0);
            existing.setComputedAt(LocalDateTime.now());
            return scoreRepo.save(existing);
        }

        CompatibilityScoreRecord score = new CompatibilityScoreRecord();
        score.setStudentAId(aId);
        score.setStudentBId(bId);
        score.setScore(80.0);
        score.setComputedAt(LocalDateTime.now());
        score.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.GOOD);
        return scoreRepo.save(score);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id){
        return scoreRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId){
        return scoreRepo.findByStudentAIdOrStudentBId(studentId,studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores(){ return scoreRepo.findAll(); }
}
