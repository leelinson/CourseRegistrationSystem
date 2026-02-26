package crs;

import java.util.ArrayList;

public class DataStore {

    public ArrayList<Course> loadCourses() {
        // TODO: deserialize first; if fail read CSV
        return new ArrayList<>();
    }

    public ArrayList<Student> loadStudents() {
        // TODO: deserialize
        return new ArrayList<>();
    }

    public void saveCourses(ArrayList<Course> courses) {
        // TODO: serialize
    }

    public void saveStudents(ArrayList<Student> students) {
        // TODO: serialize
    }
}
