package com.norbertneudert.bmdb.builders;

import com.norbertneudert.bmdb.domain.Actor;
import com.norbertneudert.bmdb.domain.Sex;

import java.time.LocalDate;

public class ActorBuilder {
    private Actor actor;

    public ActorBuilder() {
        this.actor = new Actor();
    }

    public ActorBuilder setName(String name) {
        this.actor.setName(name);
        return this;
    }

    public ActorBuilder setBorn(LocalDate born) {
        this.actor.setBorn(born);
        return this;
    }

    public ActorBuilder setSex(Sex sex) {
        this.actor.setSex(sex);
        return this;
    }

    public ActorBuilder setBiography(String biography) {
        this.actor.setBiography(biography);
        return this;
    }

    public Actor build() {
        return this.actor;
    }
}
