package com.roomy.roomy.repository;

import com.roomy.roomy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
