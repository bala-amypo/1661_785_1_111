package com.example.demo.service;

import java.util.List;
import com.example.demo.model.HabitProfile;

public interface HabitProfileService {

    HabitProfile create(HabitProfile habit);

    HabitProfile update(Long id, HabitProfile habit);

    HabitProfile getById(Long id);

    List<HabitProfile> getAll();

    void delete(Long id);
}
