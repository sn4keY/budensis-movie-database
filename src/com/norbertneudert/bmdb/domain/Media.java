package com.norbertneudert.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Media {
    private BigDecimal id;
    private String title;
    private String description;
    private LocalDate premier;
    private List<Review> reviews;
    private List<Actor> cast;

    public Media() {
        this.reviews = new ArrayList<Review>();
        this.cast = new ArrayList<Actor>();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPremier() {
        return premier;
    }

    public void setPremier(LocalDate premier) {
        this.premier = premier;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getId()).append(":'").append(getTitle())
                .append("'\nDescription='").append(getDescription())
                .append("'\nPremier=").append(getPremier())
                .append("\nCast=").append(getCast().toString())
                .append("\nReviews=").append(getReviews().toString()).toString();
    }
}
