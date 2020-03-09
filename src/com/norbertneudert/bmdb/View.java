package com.norbertneudert.bmdb;

import com.norbertneudert.bmdb.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    public User readUserData() {
        return new User(); // TODO: write function body that identifies the user.
    }

    public void printWelcomeMessage(User user) {
        // TODO: write function body that prints out a welcome message based on the user.
    }

    public void printMedias() {
        // TODO: write function body that prints out all the medias.
    }

    public void printReviews(User user) {
        // TODO: write function body that prints out the current user's reviews.
    }

    public String askReview() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to write another review? (yes/no)");
        return bufferedReader.readLine();
    }
}
