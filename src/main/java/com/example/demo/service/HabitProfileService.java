package com.example.demo.service;

import com.example.demo.model.HabitProfile;

public interface HabitProfileService {

    HabitProfile createOrUpdate(HabitProfile profile);
    HabitProfile getByStudentId(Long studentId);
    void deleteByStudentId(Long studentId);
}
