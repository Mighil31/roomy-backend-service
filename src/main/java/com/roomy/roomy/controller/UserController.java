package com.roomy.roomy.controller;

import com.roomy.roomy.exception.UserNotFoundException;
import com.roomy.roomy.model.User;
import com.roomy.roomy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

//    @GetMapping("/user/{id}")
//    User getUserById(@PathVariable UUID id){
//        return userRepository.findById(id)
//                .orElseThrow(()->new UserNotFoundException(id));
//    }

}
