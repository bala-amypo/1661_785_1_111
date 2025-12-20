package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class HabitProfile{
    @Id
    @generatedValue(strategy)
}