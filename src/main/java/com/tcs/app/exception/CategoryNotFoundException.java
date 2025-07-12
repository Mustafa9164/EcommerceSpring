package com.tcs.app.exception;

public class CategoryNotFoundException extends RuntimeException{

    CategoryNotFoundException(String message){
        super(message);
    }
}
