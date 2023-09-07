package com.xtommas.movie_review.controllers;

import com.xtommas.movie_review.DTOs.ReviewDTO;
import com.xtommas.movie_review.entities.Movie;
import com.xtommas.movie_review.entities.Review;
import com.xtommas.movie_review.entities.User;
import com.xtommas.movie_review.repositories.MovieRepository;
import com.xtommas.movie_review.repositories.ReviewRepository;
import com.xtommas.movie_review.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private ReviewRepository repository;
    private UserService userService;
    private MovieRepository movieRepository;

    public ReviewController(ReviewRepository repository, UserService userService, MovieRepository movieRepository) {
        this.repository = repository;
        this.userService = userService;
        this.movieRepository = movieRepository;
    }

    @PostMapping("api/v1/reviews/movie/{id}")
    public Review newReview(@PathVariable Long id, @RequestBody ReviewDTO review, Authentication authentication) {
        User user = (User) userService.loadUserByUsername(authentication.getName());
        Movie movie = movieRepository.getReferenceById(id);
        Review newReview = new Review(0L, user, movie, review.getText(), review.getStarRating());
        return repository.save(newReview);
    }

}
