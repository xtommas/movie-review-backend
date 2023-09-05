package com.xtommas.movie_review.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_id_sequence",
            sequenceName = "movie_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_id_sequence"
    )
    private Long id;
    private String title;
    @Column(length = 512)
    private String overview;
    private Integer runtime;
    private ArrayList<String> genres;
    private String language;
    private String poster;
    private String trailer;
    private float starRating;
    private ArrayList<String> actors;
    private Date releaseDate;
    private String director;

    public Movie() {
    }

    public Movie(Long id, String title, String overview, Integer runtime, ArrayList<String> genres, String language, String poster, String trailer, float starRating, ArrayList<String> actors, Date releaseDate, String director) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.runtime = runtime;
        this.genres = genres;
        this.language = language;
        this.poster = poster;
        this.trailer = trailer;
        this.starRating = starRating;
        this.actors = actors;
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

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
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
        return actors;
    }

    public void setCast(ArrayList<String> actors) {
        this.actors = actors;
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
        return Float.compare(starRating, movie.starRating) == 0 && Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(overview, movie.overview) && Objects.equals(genres, movie.genres) && Objects.equals(language, movie.language) && Objects.equals(poster, movie.poster) && Objects.equals(trailer, movie.trailer) && Objects.equals(actors, movie.actors) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, overview, genres, language, poster, trailer, starRating, actors, releaseDate, director);
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
                ", actors=" + actors +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                '}';
    }
}
