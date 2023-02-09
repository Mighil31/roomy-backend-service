package com.roomy.roomy.exception;

import java.util.UUID;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(UUID id){
        super("Could not find the post with id "+id);
    }

}
