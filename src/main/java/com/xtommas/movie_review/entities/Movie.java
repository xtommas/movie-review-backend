package com.xtommas.movie_review.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String overview;
    private ArrayList<String> genres;
    private String language;
    private String poster;
    private String trailer;
    private float starRating;
    private ArrayList<String> cast;
    private Date releaseDate;
    private String director;

    public Movie() {
    }

    public Movie(Long id, String title, String overview, ArrayList<String> genres, String language, String poster, String trailer, float starRating, ArrayList<String> cast, Date releaseDate, String director) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.genres = genres;
        this.language = language;
        this.poster = poster;
        this.trailer = trailer;
        this.starRating = starRating;
        this.cast = cast;
        this.releaseDate = releaseDate;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Float.compare(starRating, movie.starRating) == 0 && Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(overview, movie.overview) && Objects.equals(genres, movie.genres) && Objects.equals(language, movie.language) && Objects.equals(poster, movie.poster) && Objects.equals(trailer, movie.trailer) && Objects.equals(cast, movie.cast) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, overview, genres, language, poster, trailer, starRating, cast, releaseDate, director);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", genres=" + genres +
                ", language='" + language + '\'' +
                ", poster='" + poster + '\'' +
                ", trailer='" + trailer + '\'' +
                ", starRating=" + starRating +
                ", cast=" + cast +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                '}';
    }
}
