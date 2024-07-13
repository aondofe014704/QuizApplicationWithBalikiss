package com.semicolon.quizapplication.services;

import com.semicolon.quizapplication.dto.requests.LoginUserRequest;
import com.semicolon.quizapplication.dto.requests.RegisterUserRequest;
import com.semicolon.quizapplication.dto.responses.LoginUserResponse;
import com.semicolon.quizapplication.dto.responses.RegisterUserResponse;
import com.semicolon.quizapplication.exceptions.LoginDetailsNotCorrectException;
import com.semicolon.quizapplication.exceptions.UserAlreadyRegisteredException;
import com.semicolon.quizapplication.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
//    @BeforeEach
//    public void setUp(){
//        userRepository.deleteAll();
//    }
//    @Test
//    public void testToRegisterUser(){
//        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
//        registerUserRequest.setUsername("JackSongu014704");
//        registerUserRequest.setPassword("password123");
//        registerUserRequest.setEmail("Mary@gmail.com");
//        RegisterUserResponse registerUserResponse = userService.register(registerUserRequest);
//        assertEquals(1, userService.count());
//        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered");
//    }
//    @Test
//    public void testThatUserCanNotRegisterTwice(){
//        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
//        registerUserRequest.setUsername("JackSongu014704");
//        registerUserRequest.setPassword("password123");
//        registerUserRequest.setEmail("Mary@gmail.com");
//        RegisterUserResponse registerUserResponse = userService.register(registerUserRequest);
//        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered");
//        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
//        registerUserRequest1.setUsername("JackSongu014704");
//        registerUserRequest1.setPassword("password123");
//        registerUserRequest1.setEmail("Mary@gmail.com");
//        assertThrows(UserAlreadyRegisteredException.class,()-> userService.register(registerUserRequest1));
//        assertEquals(1, userService.count());
//    }
    @Test
    public void testToLoginUser(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Jack");
        registerUserRequest.setPassword("Alice");
        registerUserRequest.setEmail("Alice@gmail.com");
        RegisterUserResponse registerUserResponse = userService.register(registerUserRequest);
        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered");

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("Alice@gmail.com");
        loginUserRequest.setPassword("Alice");
        LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
        assertThat(loginUserResponse.getMessage()).isEqualTo("Successfully Logged in");
        assertEquals(2, userService.count());
    }
    @Test
    public void testThatUserCanNotLoginWithWrongCredentials(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("PerryWizzy");
        registerUserRequest.setPassword("Wizzy");
        registerUserRequest.setEmail("PerryWizzy@gmail.com");
        RegisterUserResponse registerUserResponse = userService.register(registerUserRequest);
        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered");
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("JerryJones@gmail.com");
        loginUserRequest.setPassword("Jerry");
        assertThrows(LoginDetailsNotCorrectException.class, () -> userService.login(loginUserRequest));
        assertEquals(1, userService.count());

    }


}