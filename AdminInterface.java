package crsHW1;

public interface AdminInterface {
	   void createCourse(Course course);
	   void deleteCourse(String courseId);
	   void editCourse(String courseId);
	   void displayCourseInfo(String courseId);
	   void viewAllCourses();
	   void viewFullCourses();
	   void sortCourses();
	}
