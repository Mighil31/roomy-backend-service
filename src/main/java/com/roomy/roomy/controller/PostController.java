package com.roomy.roomy.controller;

import com.roomy.roomy.exception.PostNotFoundException;
import com.roomy.roomy.exception.UserNotFoundException;
import com.roomy.roomy.model.Post;
import com.roomy.roomy.model.PostRequest;
import com.roomy.roomy.model.User;
import com.roomy.roomy.repository.PostRepository;
import com.roomy.roomy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/post")
    Post newPost(@RequestBody PostRequest postRequest){

        if (postRequest.getUserId() == null) {
            throw new UserNotFoundException(null);
        }
        User user = userRepository.findById(postRequest.getUserId()).orElseThrow(() -> new UserNotFoundException(postRequest.getUserId()));
        Post post = new Post(postRequest);
        post.setUser(user);
        System.out.println("\n\n");
        System.out.println(post);
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    List<Post> getAllPosts(){
        return postRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/post/{id}")
    Post getPostById(@PathVariable UUID id){
        return postRepository.findById(id)
                .orElseThrow(()->new PostNotFoundException(id));
    }

    @GetMapping("/{userId}/posts")
    List<Post> getUserPost(@PathVariable UUID userId){
        return postRepository.findByUserUserIdOrderByDateDesc(userId);
    }

}
