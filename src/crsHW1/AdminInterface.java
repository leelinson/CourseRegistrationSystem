package crsHW1;

/**
 * Interface for Admin operations (Req 05). Method signatures used by Admin.
 */
public interface AdminInterface {
	void createCourse(Course course);
	void deleteCourse(String courseId);
	void editCourse(String courseId);
	void displayCourseInfo(String courseId);
	void displayCourseInfo(Course course); // method overloading: same name, different param
	void registerStudent(Student student);
	void viewAllCourses();
	void viewFullCourses();
	void writeFullCoursesToFile(String filename);
	void viewStudentsInCourse(String courseId);
	void viewCoursesForStudent(String firstName, String lastName);
	void sortCourses();
}
