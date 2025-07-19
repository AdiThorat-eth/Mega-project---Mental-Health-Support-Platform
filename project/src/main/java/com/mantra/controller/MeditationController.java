package com.mantra.controller;

import com.mantra.dto.ApiResponse;
import com.mantra.dto.meditation.MeditationRequest;
import com.mantra.dto.meditation.MeditationResponse;
import com.mantra.service.MeditationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meditations")
@RequiredArgsConstructor
@Tag(name = "Meditation", description = "Meditation resources management")
@SecurityRequirement(name = "bearerAuth")
public class MeditationController {
    private final MeditationService meditationService;

    @GetMapping
    @Operation(summary = "Get all meditation resources")
    public ResponseEntity<ApiResponse<List<MeditationResponse>>> getAllMeditations() {
        List<MeditationResponse> meditations = meditationService.getAllMeditations();
        return ResponseEntity.ok(ApiResponse.success(meditations));
    }

    @PostMapping
    @Operation(summary = "Create new meditation resource (Admin only)")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<MeditationResponse>> createMeditation(@Valid @RequestBody MeditationRequest request) {
        MeditationResponse response = meditationService.createMeditation(request);
        return ResponseEntity.ok(ApiResponse.success("Meditation created successfully", response));
    }
}