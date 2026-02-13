package crsHW1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Student user (Req 02, Req 07, Req 11). Inherits from User; implements StudentInterface.
 * Uses basic OOP: receives course list as parameter to methods that need it.
 */
public class Student extends User implements StudentInterface, Serializable {
	private static final long serialVersionUID = 1L;

	public Student(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}

	@Override
	public void displayMenu() {
		System.out.println("Student Menu");
		System.out.println("1. View All Courses");
		System.out.println("2. View all courses that are not full");
		System.out.println("3. Register on a course");
		System.out.println("4. Withdraw from a course");
		System.out.println("5. View all courses registered");
		System.out.println("6. Exit");
	}

	@Override
	public void viewAllCourses(ArrayList<Course> courses) {
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	@Override
	public void viewOpenCourses(ArrayList<Course> courses) {
		for (Course course : courses) {
			if (!course.isFull()) {
				System.out.println(course);
			}
		}
	}

	@Override
	public void registerCourse(ArrayList<Course> courses, String name, int section, String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		for (Course course : courses) {
			if (course.getCourseName().equals(name) && course.getCourseSection() == section) {
				if (!course.isFull()) {
					course.addStudent(fullName);
				}
				return;
			}
		}
	}

	@Override
	public void withdrawCourse(ArrayList<Course> courses, String name, int section, String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		for (Course course : courses) {
			if (course.getCourseName().equals(name) && course.getCourseSection() == section) {
				course.removeStudent(fullName);
				return;
			}
		}
	}

	@Override
	public void viewRegisteredCourses(ArrayList<Course> courses) {
		String fullName = getFullName();
		for (Course course : courses) {
			if (course.getStudentList() != null && course.getStudentList().contains(fullName)) {
				System.out.println(course);
			}
		}
	}
}
