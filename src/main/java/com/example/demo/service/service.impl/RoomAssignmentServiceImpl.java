package com.example.demo.service.impl;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repository;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomAssignmentRecord saveAssignment(RoomAssignmentRecord assignment) {
        return repository.save(assignment);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RoomAssignmentRecord not found with id: " + id));
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }
}
