package com.example.demo.service;

import java.util.List;
import com.example.demo.model.HabitProfile;

public interface HabitProfileService {
    HabitProfile save(HabitProfile habit);
    List<HabitProfile> getAll();
    HabitProfile getById(Long id) throws Exception;
    void deleteById(Long id);
}
