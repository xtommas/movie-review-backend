package com.xtommas.movie_review.Exceptions;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(Long id) {
        super("Could not find Movie " + id);
    }
}
