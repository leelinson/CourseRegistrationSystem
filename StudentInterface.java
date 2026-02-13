package crsHW1;

public interface StudentInterface {
	   void viewAllCourses();
	   void viewOpenCourses();
	   void registerCourse(String name, int section, String firstName, String lastName);
	   void withdrawCourse(String name, int section, String firstName, String lastName);
	   void viewRegisteredCourses();
	}
