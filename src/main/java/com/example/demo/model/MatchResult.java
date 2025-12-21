package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentA;

    @ManyToOne
    private StudentProfile studentB;

    private Double score;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentProfile getStudentA() { return studentA; }
    public void setStudentA(StudentProfile studentA) { this.studentA = studentA; }

    public StudentProfile getStudentB() { return studentB; }
    public void setStudentB(StudentProfile studentB) { this.studentB = studentB; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
}
