package com.norbertneudert.bmdb;

import com.norbertneudert.bmdb.domain.Media;
import com.norbertneudert.bmdb.domain.Review;
import com.norbertneudert.bmdb.domain.User;

import java.util.Collections;
import java.util.List;

public class Service {
    public void saveUser(User user) {
        // TODO: implement function that saves the user.
    }

    public User findUser() {
        return new User(); // TODO: implement function that finds a user.
    }

    public List<Media> findAllMedia() {
        return Collections.emptyList(); // TODO: implement function
    }

    public void saveReview(Media media, Review review) {
        // TODO: implement function
    }

    public List<Review> findAllReview(Media media) {
        return Collections.emptyList(); // TODO: implement function
    }
}
