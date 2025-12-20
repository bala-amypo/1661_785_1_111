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
    private int yearOfStudy;
    private String gender;
    private String roomTypePreference;

    public Long getId() { return id; }
    public UserAccount getUserAccount() { return userAccount; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public int getYearOfStudy() { return yearOfStudy; }
    public String getGender() { return gender; }
    public String getRoomTypePreference() { return roomTypePreference; }

    public void setId(Long id) { this.id = id; }
    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setYearOfStudy(int yearOfStudy) { this.yearOfStudy = yearOfStudy; }
    public void setGender(String gender) { this.gender = gender; }
    public void setRoomTypePreference(String roomTypePreference) { this.roomTypePreference = roomTypePreference; }
}
