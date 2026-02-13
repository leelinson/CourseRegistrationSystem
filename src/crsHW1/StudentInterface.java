package crsHW1;

import java.util.ArrayList;

/**
 * Interface for Student operations (Req 06). Method signatures used by Student.
 */
public interface StudentInterface {
	void viewAllCourses(ArrayList<Course> courses);
	void viewOpenCourses(ArrayList<Course> courses);
	void registerCourse(ArrayList<Course> courses, String name, int section, String firstName, String lastName);
	void withdrawCourse(ArrayList<Course> courses, String name, int section, String firstName, String lastName);
	void viewRegisteredCourses(ArrayList<Course> courses);
}
