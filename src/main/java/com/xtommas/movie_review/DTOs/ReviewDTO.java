package com.xtommas.movie_review.DTOs;

public class ReviewDTO {

    private String text;
    private Float starRating;

    public ReviewDTO(String text, Float starRating) {
        this.text = text;
        this.starRating = starRating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Float getStarRating() {
        return starRating;
    }

    public void setStarRating(Float starRating) {
        this.starRating = starRating;
    }
}
