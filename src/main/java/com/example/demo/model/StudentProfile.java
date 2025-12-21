package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserAccount userAccount;

    private String name;
    private Integer age;
    private String course;
    private Integer yearOfStudy;
    private String roomTypePreference;

    public Long getId() { return id; }
    public UserAccount getUserAccount() { return userAccount; }
    public Integer getAge() { return age; }
    public String getRoomTypePreference() { return roomTypePreference; }

    public void setId(Long id) { this.id = id; }
    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }
    public void setAge(Integer age) { this.age = age; }
    public void setRoomTypePreference(String roomTypePreference) { this.roomTypePreference = roomTypePreference; }
}
