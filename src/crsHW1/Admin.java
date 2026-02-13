package crsHW1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Admin user (Req 02, Req 07, Req 09). Inherits from User; implements AdminInterface.
 * Manages courses and student roster; performs reports.
 */
public class Admin extends User implements AdminInterface, Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Course> courses;
	private ArrayList<Student> students;

	public Admin(String username, String password, String firstName, String lastName,
			ArrayList<Course> courses, ArrayList<Student> students) {
		super(username, password, firstName, lastName);
		this.courses = courses;
		this.students = students != null ? students : new ArrayList<>();
	}

	@Override
	public void displayMenu() {
		System.out.println("\n--- Admin Menu ---");
		System.out.println("Courses Management:");
		System.out.println("  1. Create a new course");
		System.out.println("  2. Delete a course");
		System.out.println("  3. Edit a course");
		System.out.println("  4. Display information for a given course (by course ID)");
		System.out.println("  5. Register a student (add student to system)");
		System.out.println("  6. Exit (Courses Management)");
		System.out.println("Reports:");
		System.out.println("  7. View all courses");
		System.out.println("  8. View all courses that are FULL");
		System.out.println("  9. Write to a file the list of courses that are Full");
		System.out.println(" 10. View the names of students registered in a specific course");
		System.out.println(" 11. View the list of courses for a given student (first & last name)");
		System.out.println(" 12. Sort courses by current number of students registered");
		System.out.println(" 13. Exit (Admin)");
	}

	@Override
	public void createCourse(Course course) {
		courses.add(course);
	}

	@Override
	public void deleteCourse(String courseId) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseId().equals(courseId)) {
				courses.remove(i);
				return;
			}
		}
	}

	@Override
	public void editCourse(String courseId) {
		// Edit is done in MainPage with scanner; this is the interface contract.
		// Admin can locate course for editing - actual edit via setters in Main.
	}

	@Override
	public void displayCourseInfo(String courseId) {
		for (Course c : courses) {
			if (c.getCourseId().equals(courseId)) {
				displayCourseInfo(c); // overloaded method
				return;
			}
		}
		System.out.println("Course not found: " + courseId);
	}

	@Override
	public void displayCourseInfo(Course c) {
		System.out.println("Course: " + c.getCourseName() + " | ID: " + c.getCourseId());
		System.out.println("  Max: " + c.getMaxStudents() + " | Current: " + c.getCurrentStudents());
		System.out.println("  Instructor: " + c.getCourseInstructor() + " | Section: " + c.getCourseSection());
		System.out.println("  Location: " + c.getCourseLocation());
		if (c.getStudentList() != null && !c.getStudentList().isEmpty()) {
			System.out.println("  Students: " + c.getStudentList());
		}
	}

	@Override
	public void registerStudent(Student student) {
		if (student != null && students != null) {
			students.add(student);
		}
	}

	@Override
	public void viewAllCourses() {
		for (Course c : courses) {
			System.out.println(c.getCourseName() + " | ID: " + c.getCourseId()
					+ " | Registered: " + c.getCurrentStudents() + "/" + c.getMaxStudents());
		}
	}

	@Override
	public void viewFullCourses() {
		for (Course c : courses) {
			if (c.isFull()) {
				System.out.println(c.getCourseName() + " | ID: " + c.getCourseId()
						+ " | " + c.getCurrentStudents() + "/" + c.getMaxStudents());
			}
		}
	}

	@Override
	public void writeFullCoursesToFile(String filename) {
		java.util.List<Course> full = new ArrayList<>();
		for (Course c : courses) {
			if (c.isFull()) full.add(c);
		}
		FileManager.writeFullCoursesToFile(full, filename);
	}

	@Override
	public void viewStudentsInCourse(String courseId) {
		for (Course c : courses) {
			if (c.getCourseId().equals(courseId)) {
				if (c.getStudentList() == null || c.getStudentList().isEmpty()) {
					System.out.println("No students registered in this course.");
				} else {
					for (String name : c.getStudentList()) System.out.println("  " + name);
				}
				return;
			}
		}
		System.out.println("Course not found: " + courseId);
	}

	@Override
	public void viewCoursesForStudent(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		boolean found = false;
		for (Course c : courses) {
			if (c.getStudentList() != null && c.getStudentList().contains(fullName)) {
				System.out.println("  " + c.getCourseName() + " (ID: " + c.getCourseId() + ", Section: " + c.getCourseSection() + ")");
				found = true;
			}
		}
		if (!found) System.out.println("No courses found for: " + fullName);
	}

	@Override
	public void sortCourses() {
		Collections.sort(courses, Comparator.comparingInt(Course::getCurrentStudents));
		viewAllCourses();
	}
}
