package com.example.demo.service;

import com.example.demo.entity.HabitProfile;

public interface HabitProfileService {
    HabitProfile save(HabitProfile h);
    HabitProfile getHabitById(Long id);
    HabitProfile getHabitByStudent(Long studentId);
    void deleteHabit(Long id);
}
