package com.roomy.roomy.controller;

import com.roomy.roomy.exception.PostNotFoundException;
import com.roomy.roomy.model.Post;
import com.roomy.roomy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post")
    Post newPost(@RequestBody Post newPost){
        return postRepository.save(newPost);
    }

    @GetMapping("/posts")
    List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/post/{id}")
    Post getPostById(@PathVariable UUID id){
        return postRepository.findById(id)
                .orElseThrow(()->new PostNotFoundException(id));
    }

    @GetMapping("/{userId}/posts")
    List<Post> getUserPost(@PathVariable Long userId){
        return postRepository.findByUserId(userId); //add exception
    }


}
