package com.mantra.repository;

import com.mantra.entity.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {
    List<Therapist> findByIsAvailable(Boolean isAvailable);
}