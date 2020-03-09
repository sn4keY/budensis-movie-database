package com.norbertneudert.bmdb.builders;

import com.norbertneudert.bmdb.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MediaBuilder {
    private Media media;

    public MediaBuilder() {
        this.media = new Media();
    }

    public MediaBuilder setId(BigDecimal id) {
        this.media.setId(id);
        return this;
    }

    public MediaBuilder setTitle(String title) {
        this.media.setTitle(title);
        return this;
    }

    public MediaBuilder setDescription(String description) {
        this.media.setDescription(description);
        return this;
    }

    public MediaBuilder setPremier(LocalDate premier) {
        this.media.setPremier(premier);
        return this;
    }

    public MediaBuilder addReview(String text, Rating rating, User creator) {
        Review review = new Review();
        review.setText(text);
        review.setCreator(creator);
        review.setRating(rating);
        review.setReviewedMedia(this.media);
        creator.getReviews().add(review);
        this.media.getReviews().add(review);
        return this;
    }

    public MediaBuilder addActor(Actor actor) {
        actor.getFilmography().add(this.media);
        this.media.getCast().add(actor);
        return this;
    }

    public Media build() {
        return this.media;
    }
}
