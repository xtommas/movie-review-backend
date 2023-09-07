package com.xtommas.movie_review.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
    @Column(name="movie_id")
    private Long id;
    private String title;
    @Column(length = 512)
    private String overview;
    private Integer runtime;
    private ArrayList<String> genres;
    private String language;
    private String trailer;
    private ArrayList<String> actors;
    private Date releaseDate;
    private String director;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    public Movie() {
    }

    public Movie(Long id, String title, String overview, Integer runtime, ArrayList<String> genres, String language, String trailer, ArrayList<String> actors, Date releaseDate, String director, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.runtime = runtime;
        this.genres = genres;
        this.language = language;
        this.trailer = trailer;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.director = director;
        this.reviews = reviews;
    }

    public Movie(Long id, String title, String overview, Integer runtime, ArrayList<String> genres, String language, String trailer, ArrayList<String> actors, Date releaseDate, String director) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.runtime = runtime;
        this.genres = genres;
        this.language = language;
        this.trailer = trailer;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.director = director;
        this.reviews = new ArrayList<Review>();
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
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
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

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", runtime=" + runtime +
                ", genres=" + genres +
                ", language='" + language + '\'' +
                ", trailer='" + trailer + '\'' +
                ", actors=" + actors +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
