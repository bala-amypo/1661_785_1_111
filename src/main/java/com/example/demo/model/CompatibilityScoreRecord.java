package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="compatibility_score")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompatibilityScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    private Double score = 0.0;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel = CompatibilityLevel.AVERAGE;

    private LocalDateTime computedAt = LocalDateTime.now();

    private String detailsJson;

    public enum CompatibilityLevel { POOR, AVERAGE, GOOD, EXCELLENT }
}
