package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo, CompatibilityScoreRecordRepository scoreRepo){
        this.repo=repo; this.scoreRepo=scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord m){
        if(m.getResultScoreId()!=null){
            m.setStatus(MatchAttemptRecord.Status.MATCHED);
        } else {
            m.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return repo.save(m);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status){
        MatchAttemptRecord m = repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        m.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repo.save(m);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId){
        return repo.findByInitiatorStudentIdOrCandidateStudentId(studentId,studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts(){ return repo.findAll(); }
}
