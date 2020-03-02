package com.norbertneudert.bmdb;

import com.norbertneudert.bmdb.domain.Media;
import com.norbertneudert.bmdb.domain.Review;

import java.util.List;

public class App {
    private Review review;
    //private IO io; TODO: ask what is this
    private List<Media> medias;
    private Media selectedMedia;

    public App (Service service, View view) {
        this.medias = service.findAllMedia();
    }

    public void play() {
        // TODO: implement function
    }

    private void createUser() {
        // TODO: implement function
    }

    private void doReview() {
        // TODO: implement function
    }

    private void printReviewAverage() {
        // TODO: implement function
    }
}
