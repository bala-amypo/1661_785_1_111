package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="match_attempt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchAttemptRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long initiatorStudentId;
    private Long candidateStudentId;

    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING_REVIEW;

    public enum Status { PENDING_REVIEW, MATCHED, COMPLETED }
}
