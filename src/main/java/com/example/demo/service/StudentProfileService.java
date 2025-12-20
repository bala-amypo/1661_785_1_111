package com.example.demo.service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentPeofileService{
    private final StudentProfileRepository repo;
    public StudentProfileService(StudentProfileRepository repo){
        this.repo=repo;
    }
    public StudentProfile create)StudentProfile create(StudentProfile profile){
        if(profile.getAge()<=0)
        throw new IllegalArgumentException("age must be>0");
        return repo.save(profile);
    }
    public
}