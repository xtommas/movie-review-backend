package com.xtommas.movie_review.DTOs;

public class RegistrationDTO {
    private String name;
    private String email;
    private String username;
    private String password;
    private String picture;

    public RegistrationDTO(String name, String email, String username, String password, String picture) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}