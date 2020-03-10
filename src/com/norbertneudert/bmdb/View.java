package com.norbertneudert.bmdb;

import com.norbertneudert.bmdb.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    public User readUserData() {
        System.out.println("What is your name?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userName = null;
        try {
            userName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setName(userName);
        return user;
    }

    public void printWelcomeMessage(User user) {
        System.out.println("Welcome " + user.getName());
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
