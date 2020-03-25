package com.norbertneudert.bmdb.app;

import com.norbertneudert.bmdb.view.View;
import com.norbertneudert.bmdb.builders.ActorBuilder;
import com.norbertneudert.bmdb.builders.MediaBuilder;
import com.norbertneudert.bmdb.builders.UserBuilder;
import com.norbertneudert.bmdb.domain.*;
import com.norbertneudert.bmdb.service.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    private Review review;
    //private IO io;
    private List<Media> medias;
    private Media selectedMedia;
    private Service service;
    private View view;

    public App (Service service, View view) {
        this.medias = new ArrayList<Media>();
        this.createTestData();
        this.service = service;
        this.view = view;
    }

    public void play() {
        User user = this.view.readUserData();
        this.view.printWelcomeMessage(user);
        String wantToReview = "yes";
        do {
            this.view.printMedias(this.medias);
            this.doReview(user);
            wantToReview = this.view.askReview();
        } while ( wantToReview.equals("yes"));
    }

    private void createUser() {
        // TODO: implement function
    }

    private void doReview(User user) {
        BigDecimal id = this.view.askId();
        String text = this.view.askText();
        Rating rating = this.view.askRating();
        for(Media m: this.medias) {
            if(m.getId().equals(id)) {
                this.selectedMedia = m;
                break;
            }
        }
        if (this.selectedMedia != null){
            this.review = new Review();
            this.review.setReviewedMedia(this.selectedMedia);
            this.review.setRating(rating);
            this.review.setCreator(user);
            this.review.setText(text);
            this.selectedMedia.getReviews().add(this.review);
            this.printReviewAverage();
        } else {
            this.view.printMediaNotFound(id);
        }
    }

    private void printReviewAverage() {
        this.view.printReviewAverage(this.selectedMedia.getReviews());
    }

    private void createTestData() {
        List<Actor> actors = this.createActors();
        List<User> users = this.createUsers();

        Media darkKnight = new MediaBuilder()
                .setId(BigDecimal.valueOf(1))
                .setTitle("The Dark Knight")
                .setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.")
                .setPremier(LocalDate.of(2008, 8, 7))
                .addReview("Very good film.", Rating.GOOD, users.get(0))
                .addActor(actors.get(0))
                .addActor(actors.get(1))
                .build();
        this.medias.add(darkKnight);

        Media lotr = new MediaBuilder()
                .setId(BigDecimal.valueOf(2))
                .setTitle("The Lord of the Rings: The Return of the King")
                .setDescription("Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.")
                .setPremier(LocalDate.of(2004, 1, 8))
                .addReview("One of my favourite movie of all time.", Rating.GOOD, users.get(1))
                .addActor(actors.get(2))
                .addActor(actors.get(3))
                .build();
        this.medias.add(lotr);

        Media inception = new MediaBuilder()
                .setId(BigDecimal.valueOf(3))
                .setTitle("Inception")
                .setDescription("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.")
                .setPremier(LocalDate.of(2010, 7, 22))
                .addReview("Overrated", Rating.AVERAGE, users.get(2))
                .addActor(actors.get(4))
                .addActor(actors.get(5))
                .build();
        this.medias.add(inception);

        Media starWars = new MediaBuilder()
                .setId(BigDecimal.valueOf(4))
                .setTitle("Star Wars: Episode V - The Empire Strikes Back")
                .setDescription("After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.")
                .setPremier(LocalDate.of(1982, 1, 28))
                .addReview("Poor resistance.", Rating.GOOD, users.get(0))
                .addActor(actors.get(6))
                .addActor(actors.get(7))
                .build();
        this.medias.add(starWars);

        Media theMatrix = new MediaBuilder()
                .setId(BigDecimal.valueOf(5))
                .setTitle("The Matrix")
                .setDescription("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.")
                .setPremier(LocalDate.of(1999, 8, 5))
                .addReview("I didn't like it.", Rating.BAD, users.get(1))
                .addReview("Very good base for sequels.", Rating.GOOD, users.get(1))
                .addActor(actors.get(8))
                .addActor(actors.get(9))
                .build();
        this.medias.add(theMatrix);
    }

    private List<Actor> createActors() {
        List<Actor> actors = new ArrayList<Actor>();

        Actor christianBale = new ActorBuilder()
                .setName("Christian Bale")
                .setBorn(LocalDate.of(1974, 1, 30))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(christianBale);
        Actor heathLedger = new ActorBuilder()
                .setName("Heath Ledger")
                .setBorn(LocalDate.of(1979, 4, 4))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(heathLedger);

        Actor seanBean = new ActorBuilder()
                .setName("Sean Bean")
                .setBorn(LocalDate.of(1959, 4, 17))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(seanBean);
        Actor seanAustin = new ActorBuilder()
                .setName("Sean Austin")
                .setBorn(LocalDate.of(1971, 2, 25))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(seanAustin);

        Actor leonardoDiCaprio = new ActorBuilder()
                .setName("Leonardo DiCaprio")
                .setBorn(LocalDate.of(1974, 11, 11))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(leonardoDiCaprio);
        Actor ellenPage = new ActorBuilder()
                .setName("Ellen Page")
                .setBorn(LocalDate.of(1987, 2, 21))
                .setSex(Sex.FEMALE)
                .setBiography("Too long")
                .build();
        actors.add(ellenPage);

        Actor markHamill = new ActorBuilder()
                .setName("Mark Hamill")
                .setBorn(LocalDate.of(1951, 9, 25))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(markHamill);
        Actor carrieFisher = new ActorBuilder()
                .setName("Carrie Fisher")
                .setBorn(LocalDate.of(1956, 10, 21))
                .setSex(Sex.FEMALE)
                .setBiography("Too long")
                .build();
        actors.add(carrieFisher);

        Actor keanuReeves = new ActorBuilder()
                .setName("Keanu Reeves")
                .setBorn(LocalDate.of(1964, 9, 2))
                .setSex(Sex.MALE)
                .setBiography("Too long")
                .build();
        actors.add(keanuReeves);
        Actor carrieAnneMoss = new ActorBuilder()
                .setName("Carrie-Anne Moss")
                .setBorn(LocalDate.of(1967, 8, 21))
                .setSex(Sex.FEMALE)
                .setBiography("Too long")
                .build();
        actors.add(carrieAnneMoss);

        return actors;
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<User>();

        User me = new UserBuilder()
                .setName("Neudert Norbert")
                .setEmail("norbertneudert@gmail.com")
                .setPassword("password1")
                .build();
        users.add(me);

        User user1 = new UserBuilder()
                .setName("Teszt Elek")
                .setEmail("tesztelek@gmail.com")
                .setPassword("password2")
                .build();
        users.add(user1);

        User user2 = new UserBuilder()
                .setName("Para Zita")
                .setEmail("parazita@gmail.com")
                .setPassword("password3")
                .build();
        users.add(user2);

        return users;
    }
}
