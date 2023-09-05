package com.xtommas.movie_review.controllers;

import com.xtommas.movie_review.DTOs.LoginDTO;
import com.xtommas.movie_review.DTOs.LoginResponseDTO;
import com.xtommas.movie_review.DTOs.RegistrationDTO;
import com.xtommas.movie_review.entities.User;
import com.xtommas.movie_review.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getName(), body.getEmail(), body.getUsername(), body.getPassword(), body.getPicture());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());

    }


}
