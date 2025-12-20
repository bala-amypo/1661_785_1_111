package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean smoking;
    private boolean drinking;
    private int cleanlinessLevel;

    public boolean isSmoking() {
        return smoking;
    }

    public boolean isDrinking() {
        return drinking;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }
}
