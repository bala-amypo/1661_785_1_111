package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class HabitProfile{
    @Id
    @generatedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private StudentProfile student;
    private boolean smoking;
    private boolean drinking;
    private int cleanlinessLevel;
}