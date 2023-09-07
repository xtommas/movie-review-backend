package com.xtommas.movie_review.controllers;

import com.xtommas.movie_review.Exceptions.MovieNotFoundException;
import com.xtommas.movie_review.entities.Movie;
import com.xtommas.movie_review.repositories.MovieRepository;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

   @GetMapping("api/v1/movies/{id}")
   Movie getMovie(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
   }

   @PostMapping("api/v1/movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
   }

    @DeleteMapping("api/v1/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PatchMapping("api/v1/movies/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
       Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
       fields.forEach((k,v) -> {
           Field field = ReflectionUtils.findField(Movie.class, k.toString());
           field.setAccessible(true);
           ReflectionUtils.setField(field, movie, v);
       });
       return repository.save(movie);
    }
}
