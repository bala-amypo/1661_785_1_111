package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;

import java.util.List;
import java.util.Optional;

public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository roomRepo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository roomRepo, StudentProfileRepository studentRepo) {
        this.roomRepo = roomRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) {
        StudentProfile a = studentRepo.findById(assignment.getStudentAId())
                .orElseThrow(() -> new RuntimeException("Student A not found"));
        StudentProfile b = studentRepo.findById(assignment.getStudentBId())
                .orElseThrow(() -> new RuntimeException("Student B not found"));

        if (!Boolean.TRUE.equals(a.getActive()) || !Boolean.TRUE.equals(b.getActive())) {
            throw new IllegalArgumentException("Both students must be active to assign a room");
        }

        assignment.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return roomRepo.save(assignment);
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long assignmentId, String statusStr) {
        RoomAssignmentRecord assignment = roomRepo.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Room assignment not found"));

        RoomAssignmentRecord.Status status;
        try {
            status = RoomAssignmentRecord.Status.valueOf(statusStr);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid status value");
        }

        assignment.setStatus(status);
        return roomRepo.save(assignment);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room assignment not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return roomRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return roomRepo.findAll();
    }
}
