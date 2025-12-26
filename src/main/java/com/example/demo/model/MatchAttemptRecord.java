package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class MatchAttemptRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private Long resultScoreId;
    private LocalDateTime attemptedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { PENDING, SUCCESS, FAIL }
}
