package com.norbertneudert.bmdb.builders;

import com.norbertneudert.bmdb.domain.User;

public class UserBuilder {
    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder setName(String name) {
        this.user.setName(name);
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.user.setName(email);
        return this;
    }
    public UserBuilder setPassword(String password) {
        this.user.setName(password);
        return this;
    }

    public User build() {
        return this.user;
    }
}
