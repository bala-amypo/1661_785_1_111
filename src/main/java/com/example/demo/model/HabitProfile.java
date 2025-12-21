package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile student;

    private boolean smoking;
    private boolean drinking;
    private int cleanlinessLevel;
    private int noisePreference;

    // getters & setters
}
