package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private int studyHoursPerDay;
    private boolean nightOwl;
    private boolean earlyRiser;
    private LocalDateTime updatedAt;
}
