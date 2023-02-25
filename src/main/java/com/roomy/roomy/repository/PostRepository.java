package com.roomy.roomy.repository;

import com.roomy.roomy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
//    @Query("SELECT * FROM post")

    List<Post> findByUserUserIdOrderByDateAsc(UUID userId);
    List<Post> findByUserUserIdOrderByDateDesc(UUID userId);

    List<Post> findAllByOrderByDateDesc();
}
