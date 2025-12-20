package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserAccount{
    @Id
    @GenerataedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
}