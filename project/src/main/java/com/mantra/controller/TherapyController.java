package com.mantra.controller;

import com.mantra.dto.ApiResponse;
import com.mantra.dto.booking.BookingRequest;
import com.mantra.dto.booking.BookingResponse;
import com.mantra.dto.therapist.TherapistResponse;
import com.mantra.service.TherapyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Therapy", description = "Therapy booking and therapist management")
@SecurityRequirement(name = "bearerAuth")
public class TherapyController {
    private final TherapyService therapyService;

    @GetMapping("/therapists")
    @Operation(summary = "Get all available therapists")
    public ResponseEntity<ApiResponse<List<TherapistResponse>>> getAllTherapists() {
        List<TherapistResponse> therapists = therapyService.getAllTherapists();
        return ResponseEntity.ok(ApiResponse.success(therapists));
    }

    @PostMapping("/bookings")
    @Operation(summary = "Book a therapy session")
    public ResponseEntity<ApiResponse<BookingResponse>> createBooking(
            @Valid @RequestBody BookingRequest request,
            Authentication authentication) {
        BookingResponse response = therapyService.createBooking(request, authentication.getName());
        return ResponseEntity.ok(ApiResponse.success("Booking created successfully", response));
    }

    @GetMapping("/bookings/user/{userId}")
    @Operation(summary = "Get user's bookings")
    public ResponseEntity<ApiResponse<List<BookingResponse>>> getUserBookings(@PathVariable Long userId) {
        List<BookingResponse> bookings = therapyService.getUserBookings(userId);
        return ResponseEntity.ok(ApiResponse.success(bookings));
    }
}