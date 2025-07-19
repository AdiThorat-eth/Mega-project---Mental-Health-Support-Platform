package com.mantra.service;

import com.mantra.dto.meditation.MeditationRequest;
import com.mantra.dto.meditation.MeditationResponse;

import java.util.List;

public interface MeditationService {
    List<MeditationResponse> getAllMeditations();
    MeditationResponse createMeditation(MeditationRequest request);
}