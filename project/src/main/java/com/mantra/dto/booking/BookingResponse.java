package com.mantra.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    private Long id;
    private String therapistName;
    private String sessionDateTime;
    private String status;
    private String notes;
    private String createdAt;
}