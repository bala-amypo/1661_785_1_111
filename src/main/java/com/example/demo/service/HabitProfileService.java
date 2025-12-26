package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import java.util.Optional;
import java.util.List;

public interface HabitProfileService {

    HabitProfile createOrUpdateHabit(HabitProfile habit);

    Optional<HabitProfile> getHabitByStudentId(Long studentId);

    HabitProfile getHabitById(Long id);

    List<HabitProfile> getAllHabitProfiles();

    void deleteHabit(Long id); // added
}
