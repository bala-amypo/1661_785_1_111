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
    public Double getScore() { return score; }

    public void setId(Long id) { this.id = id; }
    public void setStudentA(StudentProfile studentA) { this.studentA = studentA; }
    public void setStudentB(StudentProfile studentB) { this.studentB = studentB; }
    public void setScore(Double score) { this.score = score; }
}
