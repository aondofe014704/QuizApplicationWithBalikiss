package com.semicolon.quizapplication.services;

import com.semicolon.quizapplication.dto.requests.LoginUserRequest;
import com.semicolon.quizapplication.dto.requests.RegisterUserRequest;
import com.semicolon.quizapplication.dto.responses.LoginUserResponse;
import com.semicolon.quizapplication.dto.responses.RegisterUserResponse;
import com.semicolon.quizapplication.models.User;

public interface UserService {
    RegisterUserResponse register (RegisterUserRequest registerUserRequest);

    LoginUserResponse login (LoginUserRequest loginUserRequest);

    Long count();
}
