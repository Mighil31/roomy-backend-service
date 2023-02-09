package com.roomy.roomy.repository;

import com.roomy.roomy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByUserId(long id);
}
