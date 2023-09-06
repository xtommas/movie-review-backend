package com.xtommas.movie_review.controllers;

import com.xtommas.movie_review.entities.User;
import com.xtommas.movie_review.repositories.UserRepository;
import com.xtommas.movie_review.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserDetails getCurrentUser(Authentication authentication) {
        return userService.loadUserByUsername(authentication.getName());
    }

    @PatchMapping("/me")
    public User updateUser(Authentication authentication, @RequestBody Map<Object, Object> fields) {
        User user = (User) userService.loadUserByUsername(authentication.getName());
        fields.forEach( (k,v) -> {
            Field field = ReflectionUtils.findField(User.class, k.toString());
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, v);
        });
        return userService.save(user);
    }

}
