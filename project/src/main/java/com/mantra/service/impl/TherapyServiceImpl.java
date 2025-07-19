package com.mantra.service.impl;

import com.mantra.dto.booking.BookingRequest;
import com.mantra.dto.booking.BookingResponse;
import com.mantra.dto.therapist.TherapistResponse;
import com.mantra.entity.Therapist;
import com.mantra.entity.TherapyBooking;
import com.mantra.entity.User;
import com.mantra.repository.TherapistRepository;
import com.mantra.repository.TherapyBookingRepository;
import com.mantra.repository.UserRepository;
import com.mantra.service.TherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TherapyServiceImpl implements TherapyService {
    private final TherapistRepository therapistRepository;
    private final TherapyBookingRepository therapyBookingRepository;
    private final UserRepository userRepository;

    @Override
    public List<TherapistResponse> getAllTherapists() {
        return therapistRepository.findAll().stream()
                .map(this::convertToTherapistResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponse createBooking(BookingRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Therapist therapist = therapistRepository.findById(request.getTherapistId())
                .orElseThrow(() -> new RuntimeException("Therapist not found"));

        TherapyBooking booking = new TherapyBooking();
        booking.setUser(user);
        booking.setTherapist(therapist);
        booking.setSessionDateTime(request.getSessionDateTime());
        booking.setNotes(request.getNotes());
        booking.setStatus(TherapyBooking.BookingStatus.SCHEDULED);

        TherapyBooking savedBooking = therapyBookingRepository.save(booking);
        return convertToBookingResponse(savedBooking);
    }

    @Override
    public List<BookingResponse> getUserBookings(Long userId) {
        return therapyBookingRepository.findByUserId(userId).stream()
                .map(this::convertToBookingResponse)
                .collect(Collectors.toList());
    }

    private TherapistResponse convertToTherapistResponse(Therapist therapist) {
        return new TherapistResponse(
                therapist.getId(),
                therapist.getName(),
                therapist.getSpecialty(),
                therapist.getBio(),
                therapist.getYearsOfExperience(),
                therapist.getIsAvailable()
        );
    }

    private BookingResponse convertToBookingResponse(TherapyBooking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getTherapist().getName(),
                booking.getSessionDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                booking.getStatus().name(),
                booking.getNotes(),
                booking.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}