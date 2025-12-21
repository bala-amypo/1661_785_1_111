package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String course;
    private String gender;
    private String roomTypePreference;

    public StudentProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {   // 🔥 REQUIRED
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // other getters/setters optional for now
}
