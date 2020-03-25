package com.norbertneudert.bmdb.view;

import com.norbertneudert.bmdb.domain.Media;
import com.norbertneudert.bmdb.domain.Rating;
import com.norbertneudert.bmdb.domain.Review;
import com.norbertneudert.bmdb.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

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

    public void printMedias(List<Media> medias) {
        medias.forEach(media -> System.out.println(media.toString()));
    }

    public void printReviews(User user) {
        // TODO: write function body that prints out the current user's reviews.
    }

    public void printReviewAverage(List<Review> reviews) {
        double average = 0.0;
        int count = 0;
        for (Review r : reviews) {
            average += r.getRating().rate;
            count++;
        }
        System.out.println("Average of reviews: " + average/count);
    }

    public void printMediaNotFound(BigDecimal id) {
        System.out.println("Media not found with the id: " + id);
    }

    public BigDecimal askId() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal id = null;
        double num = Double.MAX_VALUE;
        while(num == Double.MAX_VALUE) {
            try {
                System.out.println("Choose an id");
                String numString = bufferedReader.readLine();
                try {
                    num = Double.parseDouble(numString);
                } catch (NumberFormatException nfe) {
                    System.out.println("Only numbers accepted");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        id = new BigDecimal(num);
        return id;
    }

    public String askText() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write a review");
        String text = null;
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public Rating askRating() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String rating = null;
        try {
            do {
                System.out.println("Choose a rating: BAD, AVERAGE, GOOD");
                rating = bufferedReader.readLine();
            } while (!this.isRatingValid(rating.toUpperCase()));
            switch (rating.toLowerCase()) {
                case "bad":
                    return Rating.BAD;
                case "good":
                    return Rating.GOOD;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Rating.AVERAGE;
    }

    private boolean isRatingValid(String userInput) {
        if (userInput.equals("BAD") || userInput.equals("AVERAGE") || userInput.equals("GOOD")){
            return true;
        }
        return false;
    }

    public String askReview() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        try {
            while (!choice.equals("NO") && !choice.equals("YES")) {
                System.out.println("Do you want to write another review? (yes/no)");
                choice = bufferedReader.readLine().toUpperCase();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }
}
