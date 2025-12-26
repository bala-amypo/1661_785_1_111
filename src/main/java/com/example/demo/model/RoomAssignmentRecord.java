package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="room_assignment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAssignmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public enum Status { ACTIVE, COMPLETED }
}
