package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "habit_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule = SleepSchedule.REGULAR;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel = CleanlinessLevel.MEDIUM;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance = NoiseTolerance.MEDIUM;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference = SocialPreference.BALANCED;

    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum SleepSchedule { EARLY, REGULAR, LATE }
    public enum CleanlinessLevel { LOW, MEDIUM, HIGH }
    public enum NoiseTolerance { LOW, MEDIUM, HIGH }
    public enum SocialPreference { INTROVERT, BALANCED, EXTROVERT }
}
