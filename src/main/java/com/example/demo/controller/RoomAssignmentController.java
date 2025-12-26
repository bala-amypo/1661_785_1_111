package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/room")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service){ this.service = service; }

    @PostMapping("/assign")
    public ResponseEntity<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord r){
        return ResponseEntity.ok(service.assignRoom(r));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<RoomAssignmentRecord>> getByStudent(@PathVariable Long id){
        return ResponseEntity.ok(service.getAssignmentsByStudent(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomAssignmentRecord>> getAll(){
        return ResponseEntity.ok(service.getAllAssignments());
    }
}
