package com.example.demo.repository;

import com.example.demo.model.MatchResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {
    List<MatchResult> findByStudentAIdOrStudentBIdOrderByScoreDesc(Long a, Long b);
}
