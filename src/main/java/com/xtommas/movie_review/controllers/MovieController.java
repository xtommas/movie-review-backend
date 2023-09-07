package com.xtommas.movie_review.controllers;

import com.xtommas.movie_review.entities.Movie;
import com.xtommas.movie_review.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

   @GetMapping("api/v1/movies")
   List<Movie> all() {
        return repository.findAll();
   }

   @PostMapping("api/v1/movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
   }

    @DeleteMapping("api/v1/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // make PATCH
}
