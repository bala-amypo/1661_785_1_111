package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MatchResult;
import java.util.List;

public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {
    List<MatchResult> findByStudentAIdOrStudentBIdOrderByScoreDesc(Long studentAId, Long studentBId);
}
