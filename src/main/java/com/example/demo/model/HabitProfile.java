\package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile student;

    private Integer cleanlinessLevel;
    private Integer noisePreference;

    public Long getId() { return id; }
    public StudentProfile getStudent() { return student; }
    public Integer getCleanlinessLevel() { return cleanlinessLevel; }
    public Integer getNoisePreference() { return noisePreference; }

    public void setId(Long id) { this.id = id; }
    public void setStudent(StudentProfile student) { this.student = student; }
    public void setCleanlinessLevel(Integer cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }
    public void setNoisePreference(Integer noisePreference) { this.noisePreference = noisePreference; }
}
