package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByStudentId(String studentId);
    Optional<StudentProfile> findByEmail(String email);
}

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {
    Optional<HabitProfile> findByStudentId(Long studentId);
}

public interface CompatibilityScoreRecordRepository extends JpaRepository<CompatibilityScoreRecord, Long> {
    Optional<CompatibilityScoreRecord> findByStudentAIdAndStudentBId(Long a, Long b);
    List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(Long a, Long b);
}

public interface MatchAttemptRecordRepository extends JpaRepository<MatchAttemptRecord, Long> {
    List<MatchAttemptRecord> findByInitiatorStudentIdOrCandidateStudentId(Long a, Long b);
}

public interface RoomAssignmentRecordRepository extends JpaRepository<RoomAssignmentRecord, Long> {
    List<RoomAssignmentRecord> findByStudentAIdOrStudentBId(Long a, Long b);
}
