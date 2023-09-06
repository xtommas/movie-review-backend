package com.xtommas.movie_review.controllers;

import com.xtommas.movie_review.entities.User;
import com.xtommas.movie_review.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/me")
    public Optional<User> getCurrentUser(Authentication authentication) {
        return repository.findByUsername(authentication.getName());
    }

}
