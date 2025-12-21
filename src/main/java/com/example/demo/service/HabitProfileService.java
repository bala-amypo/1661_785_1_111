package com.example.demo.service;

import com.example.demo.model.HabitProfile;

public interface HabitProfileService {
    HabitProfile createOrUpdate(Long studentId, HabitProfile habit);
    HabitProfile getForStudent(Long studentId);
}
