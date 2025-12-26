package com.example.demo.repository;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;
import java.util.Optional;

public interface RoomAssignmentRecordRepository {

    RoomAssignmentRecord save(RoomAssignmentRecord assignment);

    Optional<RoomAssignmentRecord> findById(Long id);

    List<RoomAssignmentRecord> findByStudentAIdOrStudentBId(Long studentAId, Long studentBId);

    List<RoomAssignmentRecord> findAll();
}
