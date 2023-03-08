package com.roomy.roomy.repository;

import com.roomy.roomy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    User findByUserId(UUID userId);
}