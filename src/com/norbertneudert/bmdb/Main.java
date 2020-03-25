package com.norbertneudert.bmdb;

import com.norbertneudert.bmdb.app.App;
import com.norbertneudert.bmdb.service.Service;
public class Main {

    public static void main(String[] args) {
        App app = new App(new Service(), new View());

        app.play();
    }
}
