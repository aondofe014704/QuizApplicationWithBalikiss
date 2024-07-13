package com.semicolon.quizapplication.services;

import com.semicolon.quizapplication.dto.requests.LoginUserRequest;
import com.semicolon.quizapplication.dto.requests.RegisterUserRequest;
import com.semicolon.quizapplication.dto.responses.LoginUserResponse;
import com.semicolon.quizapplication.dto.responses.RegisterUserResponse;
import com.semicolon.quizapplication.exceptions.LoginDetailsNotCorrectException;
import com.semicolon.quizapplication.exceptions.UserAlreadyExistException;
import com.semicolon.quizapplication.exceptions.UserAlreadyRegisteredException;
import com.semicolon.quizapplication.models.User;
import com.semicolon.quizapplication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        verify(registerUserRequest.getEmail());
        User user = modelMapper.map(registerUserRequest, User.class);
        user = userRepository.save(user);
        var registerUserResponse = modelMapper.map(user, RegisterUserResponse.class);
        registerUserResponse.setMessage("Successfully registered");
        return registerUserResponse;
    }

    public void verify(String email){
        User user = userRepository.findByEmail(email);
        if (user != null){
            throw new UserAlreadyRegisteredException("User already registered");
        }
    }


    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByEmail(loginUserRequest.getEmail());
        if(user == null || !user.getEmail().equals(loginUserRequest.getEmail())) throw new LoginDetailsNotCorrectException("Login details not correct");
        userRepository.save(user);
        var loginUserResponse = modelMapper.map(user, LoginUserResponse.class);
        loginUserResponse.setMessage("Successfully Logged in");
        return loginUserResponse;
    }

    @Override
    public Long count() {
        return userRepository.count();
    }
}
