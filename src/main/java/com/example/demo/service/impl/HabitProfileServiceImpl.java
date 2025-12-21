package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;
    private final StudentProfileRepository studentRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo, StudentProfileRepository studentRepo) {
        this.habitRepo = habitRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public HabitProfile createOrUpdate(HabitProfile profile) {
        Long studentId = profile.getStudent().getId();
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        profile.setStudent(student);

        // check if already exists
        return habitRepo.findByStudentId(studentId)
                .map(existing -> {
                    profile.setId(existing.getId());
                    return habitRepo.save(profile);
                })
                .orElseGet(() -> habitRepo.save(profile));
    }

    @Override
    public HabitProfile getByStudentId(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit Profile not found"));
    }
}
