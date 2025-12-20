package com.example.demmo.service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitprofileService{
    private final HabitProfilerepository repo;
    public HabitprofileService(HabitProfileRepository repo){
        return repo.save(h);
    }
    public HabitProfile create(HabitProfile h){
        return repo.save(h);
    }
    public HabitProfile getById(Long id){
        return repo findById(id).orElseThrow
    }
}