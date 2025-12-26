package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;

import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment);

    RoomAssignmentRecord updateStatus(Long assignmentId, String status);

    RoomAssignmentRecord getAssignmentById(Long id);

    List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId);

    List<RoomAssignmentRecord> getAllAssignments();
}
