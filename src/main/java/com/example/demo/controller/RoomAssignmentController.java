package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomAssignmentController {
    private final RoomAssignmentService service;
    
    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord assignment) {
        return ResponseEntity.ok(service.assignRoom(assignment));
    }
}