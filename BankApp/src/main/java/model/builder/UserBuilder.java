package model.builder;

import model.User;

import model.Role;
import java.util.List;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder setUsername(String name) {
        user.setUsername(name);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setRoles(List<Role> role) {
        user.setRole(role);
        return this;
    }

    public User build() {
        return user;
    }
}
