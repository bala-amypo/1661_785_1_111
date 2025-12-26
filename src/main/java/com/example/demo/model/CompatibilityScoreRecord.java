package com.example.demo.model;

import java.time.LocalDateTime;

public class CompatibilityScoreRecord {

    private Long id;
    private Long studentAId;
    private Long studentBId;
    private Double score;
    private CompatibilityLevel compatibilityLevel;
    private LocalDateTime computedAt;
    private String detailsJson;

    public enum CompatibilityLevel { POOR, AVERAGE, GOOD, EXCELLENT }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) { this.compatibilityLevel = compatibilityLevel; }

    public LocalDateTime getComputedAt() { return computedAt; }
    public void setComputedAt(LocalDateTime computedAt) { this.computedAt = computedAt; }

    public String getDetailsJson() { return detailsJson; }
    public void setDetailsJson(String detailsJson) { this.detailsJson = detailsJson; }
}
