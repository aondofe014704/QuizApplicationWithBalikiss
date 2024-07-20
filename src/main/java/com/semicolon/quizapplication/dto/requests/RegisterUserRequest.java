package com.semicolon.quizapplication.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String username;
    private String password;
    private String email;
}
