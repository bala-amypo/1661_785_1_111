package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RoomAssignmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { ACTIVE, INACTIVE }
}
