package com.norbertneudert.bmdb;

public class Main {

    public static void main(String[] args) throws IOException {
        App app = new App(new Service(), new View());

        app.play();
    }
}
