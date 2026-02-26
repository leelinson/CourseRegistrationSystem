package crs;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;

    public User() {}

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // TODO: getters/setters
}
