package com.mantra.service;

import com.mantra.dto.booking.BookingRequest;
import com.mantra.dto.booking.BookingResponse;
import com.mantra.dto.therapist.TherapistResponse;

import java.util.List;

public interface TherapyService {
    List<TherapistResponse> getAllTherapists();
    BookingResponse createBooking(BookingRequest request, String username);
    List<BookingResponse> getUserBookings(Long userId);
}