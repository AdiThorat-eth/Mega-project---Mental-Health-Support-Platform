package com.mantra.dto.booking;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    @NotNull(message = "Therapist ID is required")
    private Long therapistId;

    @NotNull(message = "Session date and time is required")
    private LocalDateTime sessionDateTime;

    private String notes;
}