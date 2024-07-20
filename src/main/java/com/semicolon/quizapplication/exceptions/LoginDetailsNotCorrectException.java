package com.semicolon.quizapplication.exceptions;

public class LoginDetailsNotCorrectException  extends RuntimeException{
    public LoginDetailsNotCorrectException(String message) {
        super(message);
    }
}
