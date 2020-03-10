package com.norbertneudert.bmdb.domain;

public class Review {
    private String text;
    private User creator;
    private Media reviewedMedia;
    private Rating rating;

    public Review() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Media getReviewedMedia() {
        return reviewedMedia;
    }

    public void setReviewedMedia(Media reviewedMedia) {
        this.reviewedMedia = reviewedMedia;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getCreator().getName()).append(":'").append(getText()).append("'")
                .append("\nrating=").append(getRating()).append("\n").toString();
    }
}
