package crs;

public class Student extends User implements StudentInterface {
    public Student(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
