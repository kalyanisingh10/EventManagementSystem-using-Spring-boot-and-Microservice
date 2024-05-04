package com.example.eventms.security.controller;

import com.example.eventms.security.entity.UserCredentials;
import com.example.eventms.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredentials userRequest){
        return  authenticationService.addUser(userRequest);

    }

    @GetMapping("/token")
    public String getToken(UserCredentials userCredentials){
        return authenticationService.generateToken(userCredentials.getUserName());
    }

    @GetMapping("/validateToken")
    public  String validateToken(String token){
        authenticationService.validateToken(token);
        return "Token is valid";
    }

}
