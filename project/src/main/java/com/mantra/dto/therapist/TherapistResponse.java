package com.mantra.dto.therapist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TherapistResponse {
    private Long id;
    private String name;
    private String specialty;
    private String bio;
    private Integer yearsOfExperience;
    private Boolean isAvailable;
}