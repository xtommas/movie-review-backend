package com.xtommas.movie_review.repositories;

import com.xtommas.movie_review.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
