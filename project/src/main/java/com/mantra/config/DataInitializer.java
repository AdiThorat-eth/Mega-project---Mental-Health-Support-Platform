package com.mantra.config;

import com.mantra.entity.Meditation;
import com.mantra.entity.Therapist;
import com.mantra.entity.User;
import com.mantra.repository.MeditationRepository;
import com.mantra.repository.TherapistRepository;
import com.mantra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TherapistRepository therapistRepository;
    private final MeditationRepository meditationRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create admin user
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@mantra.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
        }

        // Create sample user
        if (!userRepository.existsByUsername("user")) {
            User user = new User();
            user.setUsername("user");
            user.setEmail("user@mantra.com");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setRole(User.Role.USER);
            userRepository.save(user);
        }

        // Create sample therapists
        if (therapistRepository.count() == 0) {
            Therapist therapist1 = new Therapist();
            therapist1.setName("Dr. Sarah Johnson");
            therapist1.setSpecialty("Anxiety and Depression");
            therapist1.setBio("Experienced clinical psychologist specializing in cognitive behavioral therapy with over 10 years of practice.");
            therapist1.setYearsOfExperience(10);
            therapist1.setIsAvailable(true);
            therapistRepository.save(therapist1);

            Therapist therapist2 = new Therapist();
            therapist2.setName("Dr. Michael Chen");
            therapist2.setSpecialty("Trauma and PTSD");
            therapist2.setBio("Licensed therapist with expertise in trauma-informed care and EMDR therapy.");
            therapist2.setYearsOfExperience(8);
            therapist2.setIsAvailable(true);
            therapistRepository.save(therapist2);

            Therapist therapist3 = new Therapist();
            therapist3.setName("Dr. Emily Rodriguez");
            therapist3.setSpecialty("Relationship Counseling");
            therapist3.setBio("Couples and family therapist helping individuals and families build stronger relationships.");
            therapist3.setYearsOfExperience(12);
            therapist3.setIsAvailable(true);
            therapistRepository.save(therapist3);
        }

        // Create sample meditations
        if (meditationRepository.count() == 0) {
            Meditation meditation1 = new Meditation();
            meditation1.setTitle("Morning Mindfulness");
            meditation1.setDescription("Start your day with a peaceful 10-minute mindfulness meditation");
            meditation1.setUrl("https://example.com/morning-mindfulness.mp3");
            meditation1.setDurationMinutes(10);
            meditationRepository.save(meditation1);

            Meditation meditation2 = new Meditation();
            meditation2.setTitle("Stress Relief Breathing");
            meditation2.setDescription("Simple breathing exercises to reduce stress and anxiety");
            meditation2.setUrl("https://example.com/stress-relief.mp3");
            meditation2.setDurationMinutes(15);
            meditationRepository.save(meditation2);

            Meditation meditation3 = new Meditation();
            meditation3.setTitle("Evening Relaxation");
            meditation3.setDescription("Wind down with this calming evening meditation for better sleep");
            meditation3.setUrl("https://example.com/evening-relaxation.mp3");
            meditation3.setDurationMinutes(20);
            meditationRepository.save(meditation3);
        }
    }
}