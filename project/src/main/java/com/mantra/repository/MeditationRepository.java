package com.mantra.repository;

import com.mantra.entity.Meditation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeditationRepository extends JpaRepository<Meditation, Long> {
}