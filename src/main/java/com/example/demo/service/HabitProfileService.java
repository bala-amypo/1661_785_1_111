package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface HabitProfileService {
    HabitProfile saveHabitProfile(HabitProfile habitProfile);
    HabitProfile getHabitProfileById(Long id) throws ResourceNotFoundException;
    List<HabitProfile> getAllHabitProfiles();
}
