package com.norbertneudert.bmdb.domain;

import java.util.Collections;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String passWord;
    private List<Review> reviews;

    public User() {
        this.setReviews(Collections.emptyList());
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
