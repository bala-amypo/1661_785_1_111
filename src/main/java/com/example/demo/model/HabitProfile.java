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
    private int noisePreference;

    public Long getId() { return id; }
    public boolean isSmoking() { return smoking; }
    public boolean isDrinking() { return drinking; }
    public int getCleanlinessLevel() { return cleanlinessLevel; }
    public int getNoisePreference() { return noisePreference; }

    public void setId(Long id) { this.id = id; }
    public void setSmoking(boolean smoking) { this.smoking = smoking; }
    public void setDrinking(boolean drinking) { this.drinking = drinking; }
    public void setCleanlinessLevel(int cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }
    public void setNoisePreference(int noisePreference) { this.noisePreference = noisePreference; }
}
