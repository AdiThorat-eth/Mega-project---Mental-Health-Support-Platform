package com.mantra.service.impl;

import com.mantra.dto.meditation.MeditationRequest;
import com.mantra.dto.meditation.MeditationResponse;
import com.mantra.entity.Meditation;
import com.mantra.repository.MeditationRepository;
import com.mantra.service.MeditationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeditationServiceImpl implements MeditationService {
    private final MeditationRepository meditationRepository;

    @Override
    public List<MeditationResponse> getAllMeditations() {
        return meditationRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MeditationResponse createMeditation(MeditationRequest request) {
        Meditation meditation = new Meditation();
        meditation.setTitle(request.getTitle());
        meditation.setDescription(request.getDescription());
        meditation.setUrl(request.getUrl());
        meditation.setDurationMinutes(request.getDurationMinutes());

        Meditation savedMeditation = meditationRepository.save(meditation);
        return convertToResponse(savedMeditation);
    }

    private MeditationResponse convertToResponse(Meditation meditation) {
        return new MeditationResponse(
                meditation.getId(),
                meditation.getTitle(),
                meditation.getDescription(),
                meditation.getUrl(),
                meditation.getDurationMinutes(),
                meditation.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}