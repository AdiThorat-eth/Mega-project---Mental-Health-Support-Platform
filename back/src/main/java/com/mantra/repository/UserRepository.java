<<<<<<< HEAD
package com.mantra.repository;

import com.mantra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
=======
package com.mantra.repository;

import com.mantra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
>>>>>>> 3a227d6712470d5e48639472553561fa274e034f
