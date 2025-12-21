package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserAccount userAccount;

    private String name;
    private int age;
    private String course;
    private String gender;
    private String roomTypePreference;

    // getters & setters
}
