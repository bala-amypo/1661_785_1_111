package com.example.demo.service;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface RoomAssignmentService {
    RoomAssignmentRecord saveAssignment(RoomAssignmentRecord assignment);
    RoomAssignmentRecord getAssignmentById(Long id) throws ResourceNotFoundException;
    List<RoomAssignmentRecord> getAllAssignments();
}
