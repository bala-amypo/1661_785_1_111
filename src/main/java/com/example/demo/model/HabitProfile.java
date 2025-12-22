package com.example.demo.model;

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

    private String sleepPattern;
    private String studyHours;
    private String dietPreference;

    @OneToOne
    private StudentProfile studentProfile; // One-to-One with StudentProfile

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSleepPattern() { return sleepPattern; }
    public void setSleepPattern(String sleepPattern) { this.sleepPattern = sleepPattern; }

    public String getStudyHours() { return studyHours; }
    public void setStudyHours(String studyHours) { this.studyHours = studyHours; }

    public String getDietPreference() { return dietPreference; }
    public void setDietPreference(String dietPreference) { this.dietPreference = dietPreference; }

    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
}
