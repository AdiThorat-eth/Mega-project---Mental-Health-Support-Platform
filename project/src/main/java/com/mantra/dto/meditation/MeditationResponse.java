package com.mantra.dto.meditation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeditationResponse {
    private Long id;
    private String title;
    private String description;
    private String url;
    private Integer durationMinutes;
    private String createdAt;
}