package com.roomy.roomy.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID id){
        super("Could not find the user with id "+id);
    }
    public UserNotFoundException(String email){
        super("Could not find the user with email "+email);
    }
}
