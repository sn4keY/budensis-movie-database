package com.norbertneudert.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actor {
    private String name;
    private LocalDate born;
    private Sex sex;
    private String biography;
    private List<Media> filmography;

    public Actor() {
        this.setFilmography(new ArrayList<Media>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Media> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<Media> filmography) {
        this.filmography = filmography;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("name=").append(getName()).append(", ").append("born=").append(getBorn()).append("\n").toString();
    }
}
