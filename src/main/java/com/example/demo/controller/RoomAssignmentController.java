package com.example.demo.controller;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/room-assignment")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public RoomAssignmentRecord saveAssignment(@RequestBody RoomAssignmentRecord assignment) {
        return service.saveAssignment(assignment);
    }

    @GetMapping("/{id}")
    public RoomAssignmentRecord getAssignment(@PathVariable Long id) {
        return service.getAssignmentById(id);
    }

    @GetMapping("/all")
    public List<RoomAssignmentRecord> getAllAssignments() {
        return service.getAllAssignments();
    }
}
