package com.bnt.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException (String message, Long id){
        super("User not found with id : " + id);
    }
}
