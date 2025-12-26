package com.example.demo.controller;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomAssignmentController {
    private final RoomAssignmentService service;

    @PostMapping("/save")
    public RoomAssignmentRecord save(@RequestBody RoomAssignmentRecord r){ return service.save(r); }
}
