package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String s);
    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String resetToken);

}
