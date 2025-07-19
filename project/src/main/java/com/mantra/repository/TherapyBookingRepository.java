package com.mantra.repository;

import com.mantra.entity.TherapyBooking;
import com.mantra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TherapyBookingRepository extends JpaRepository<TherapyBooking, Long> {
    List<TherapyBooking> findByUser(User user);
    List<TherapyBooking> findByUserId(Long userId);
}