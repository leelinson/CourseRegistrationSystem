package crsHW1;

/**
 * Interface for Student operations (Req 06). Method signatures used by Student.
 */
public interface StudentInterface {
	   void viewAllCourses();
	   void viewOpenCourses();
	   void registerCourse(String name, int section, String firstName, String lastName);
	   void withdrawCourse(String name, int section, String firstName, String lastName);
	   void viewRegisteredCourses();
	}
