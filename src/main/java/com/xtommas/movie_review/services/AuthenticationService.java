package com.xtommas.movie_review.services;

import com.xtommas.movie_review.entities.Role;
import com.xtommas.movie_review.entities.User;
import com.xtommas.movie_review.repositories.RoleRepository;
import com.xtommas.movie_review.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String name, String email, String username, String password, String picture) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userrole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userrole);

        return userRepository.save(new User(0L, name, email, username, encodedPassword, picture, authorities));
    }
}
