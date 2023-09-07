package com.xtommas.movie_review.repositories;

import com.xtommas.movie_review.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
