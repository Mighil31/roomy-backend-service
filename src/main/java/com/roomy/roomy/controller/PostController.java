package com.roomy.roomy.controller;

import com.roomy.roomy.exception.PostNotFoundException;
import com.roomy.roomy.model.Post;
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
    ResponseEntity newPost(@RequestBody Post newPost){

        Long userId = newPost.getUserId();
        if(userId == null)
        {
            Map<String, String> response = new HashMap<>();
            response.put("error", "UserID not provided");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "User with ID " + userId + " not found");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        Post savedPost = postRepository.save(newPost);

        // return the saved post as a response
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
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

    //TODO: Add editPost API

}
