package crsHW1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Student user (Req 02, Req 07, Req 11). Inherits from User; implements StudentInterface.
 * Tracks which courses this student is registered in via registeredCourses.
 */
public class Student extends User implements StudentInterface, Serializable {
	private static final long serialVersionUID = 1L;

	/** Reference to the full course list (shared with Admin). */
	private transient ArrayList<Course> courses;
	/** Courses this student is registered in; rebuilt after deserialization. */
	private transient ArrayList<Course> registeredCourses;

	public Student(String username, String password, String firstName, String lastName, ArrayList<Course> courses) {
		super(username, password, firstName, lastName);
		this.courses = courses;
		this.registeredCourses = new ArrayList<>();
	}

	/** Set the course list (used after deserialization). */
	public void setCourseList(ArrayList<Course> courseList) {
		this.courses = courseList;
		if (this.registeredCourses == null) this.registeredCourses = new ArrayList<>();
	}

	/** Rebuild registeredCourses from the shared course list by matching full name. */
	public void rebuildRegisteredCourses() {
		if (registeredCourses == null) registeredCourses = new ArrayList<>();
		registeredCourses.clear();
		String fullName = getFullName();
		if (courses == null) return;
		for (Course c : courses) {
			if (c.getStudentList() != null && c.getStudentList().contains(fullName))
				registeredCourses.add(c);
		}
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
	public void viewAllCourses() {
		if (courses == null) return;
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	@Override
	public void viewOpenCourses() {
		if (courses == null) return;
		for (Course course : courses) {
			if (!course.isFull()) {
				System.out.println(course);
			}
		}
	}


	@Override
	public void registerCourse(String name, int section, String firstName, String lastName) {
		if (courses == null) return;
		String fullName = firstName + " " + lastName;
		for (Course course : courses) {
			if (course.getCourseName().equals(name) && course.getCourseSection() == section) {
				if (!course.isFull()) {
					course.addStudent(fullName);
					if (!registeredCourses.contains(course)) registeredCourses.add(course);
				}
				return;
			}
		}
	}


	@Override
	public void withdrawCourse(String name, int section, String firstName, String lastName) {
		if (registeredCourses == null) return;
		String fullName = firstName + " " + lastName;
		for (int i = 0; i < registeredCourses.size(); i++) {
			Course course = registeredCourses.get(i);
			if (course.getCourseName().equals(name) && course.getCourseSection() == section) {
				course.removeStudent(fullName);
				registeredCourses.remove(i);
				break;
			}
		}
	}

	@Override
	public void viewRegisteredCourses() {
		if (registeredCourses == null) return;
		for (Course course : registeredCourses) {
			System.out.println(course);
		}
	}
}
