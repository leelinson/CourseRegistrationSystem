package crs;

public class Admin extends User implements AdminInterface {
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
