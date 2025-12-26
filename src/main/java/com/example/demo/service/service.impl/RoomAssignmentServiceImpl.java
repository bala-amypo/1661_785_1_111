package com.example.demo.service.impl;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomAssignmentServiceImpl implements RoomAssignmentService {
    private final RoomAssignmentRecordRepository repo;

    @Override
    public RoomAssignmentRecord save(RoomAssignmentRecord r) { return repo.save(r); }
}
