package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {
    private final CompatibilityScoreRecordRepository repository;
    private final HabitProfileRepository habitRepository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repository, HabitProfileRepository habitRepository) {
        this.repository = repository;
        this.habitRepository = habitRepository;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {
        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("Cannot compute score for same student");
        }

        HabitProfile habitA = habitRepository.findByStudentId(studentAId)
            .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));
        HabitProfile habitB = habitRepository.findByStudentId(studentBId)
            .orElseThrow(() -> new ResourceNotFoundException("Habit profile not found"));

        double score = calculateCompatibility(habitA, habitB);
        
        Optional<CompatibilityScoreRecord> existing = repository.findByStudentAIdAndStudentBId(studentAId, studentBId);
        CompatibilityScoreRecord record;
        
        if (existing.isPresent()) {
            record = existing.get();
            record.setScore(score);
            record.setComputedAt(LocalDateTime.now());
        } else {
            record = new CompatibilityScoreRecord();
            record.setStudentAId(studentAId);
            record.setStudentBId(studentBId);
            record.setScore(score);
            record.setComputedAt(LocalDateTime.now());
        }
        
        return repository.save(record);
    }

    private double calculateCompatibility(HabitProfile a, HabitProfile b) {
        double score = 50.0; // base score
        
        if (a.getSleepSchedule() == b.getSleepSchedule()) score += 20;
        if (a.getCleanlinessLevel() == b.getCleanlinessLevel()) score += 15;
        if (a.getNoiseTolerance() == b.getNoiseTolerance()) score += 10;
        if (a.getSocialPreference() == b.getSocialPreference()) score += 5;
        
        return Math.min(100.0, Math.max(0.0, score));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }
     @Override
public CompatibilityScoreRecord saveScore(
        CompatibilityScoreRecord score) {
    return repository.save(score);
}

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return repository.findAll();
    }
}