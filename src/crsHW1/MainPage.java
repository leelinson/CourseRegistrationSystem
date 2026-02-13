package crsHW1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point for the Course Registration System (CRS).
 * Req 10: User chooses Admin or Student, then enters username/password.
 * Loads courses and students from serialized files (or CSV for courses) at start; saves on exit (Req 12).
 */
public class MainPage {

	public static void main(String[] args) {
		// Req 08, Req 12: Load courses (from .ser or CSV) and students (from .ser)
		ArrayList<Course> courses = FileManager.loadCourses();
		ArrayList<Student> students = FileManager.loadStudents();

		Scanner kb = new Scanner(System.in);
		Admin admin = new Admin("Admin", "Admin001", "Admin", "User", courses, students);

		System.out.println("Course Registration System");
		System.out.println("Login as: 1. Admin  2. Student");
		int role = readInt(kb);
		kb.nextLine();

		if (role == 1) {
			System.out.print("Username: ");
			String username = kb.nextLine().trim();
			System.out.print("Password: ");
			String password = kb.nextLine().trim();
			if (!"Admin".equals(username) || !"Admin001".equals(password)) {
				System.out.println("Invalid login.");
				kb.close();
				return;
			}
			runAdminMenu(kb, admin, courses, students);
		} else if (role == 2) {
			System.out.print("Username: ");
			String username = kb.nextLine().trim();
			System.out.print("Password: ");
			String password = kb.nextLine().trim();
			Student student = findStudent(students, username, password);
			if (student == null) {
				System.out.println("Invalid login.");
				kb.close();
				return;
			}
			runStudentMenu(kb, student, courses);
		} else {
			System.out.println("Invalid choice.");
		}

		// Req 12: Save state on exit
		FileManager.saveCourses(courses);
		FileManager.saveStudents(students);
		kb.close();
	}

	private static Student findStudent(ArrayList<Student> students, String username, String password) {
		for (Student s : students) {
			if (s.getUsername().equals(username) && s.getPassword().equals(password))
				return s;
		}
		return null;
	}

	private static void runAdminMenu(Scanner kb, Admin admin, ArrayList<Course> courses, ArrayList<Student> students) {
		boolean running = true;
		while (running) {
			admin.displayMenu();
			System.out.print("Enter choice (1-13): ");
			int choice = readInt(kb);
			kb.nextLine();

			switch (choice) {
			case 1: // Create a new course
				createCourse(kb, admin);
				break;
			case 2: // Delete a course
				System.out.print("Enter course ID to delete: ");
				admin.deleteCourse(kb.nextLine().trim());
				break;
			case 3: // Edit a course (except ID and name)
				editCourse(kb, courses);
				break;
			case 4: // Display info by course ID
				System.out.print("Enter course ID: ");
				admin.displayCourseInfo(kb.nextLine().trim());
				break;
			case 5: // Register a student (add to system)
				registerStudent(kb, admin, courses);
				break;
			case 6:
				// Exit Courses Management (stay in admin menu)
				break;
			case 7:
				admin.viewAllCourses();
				break;
			case 8:
				admin.viewFullCourses();
				break;
			case 9:
				System.out.print("Enter filename to write full courses (e.g. full_courses.txt): ");
				admin.writeFullCoursesToFile(kb.nextLine().trim());
				break;
			case 10:
				System.out.print("Enter course ID: ");
				admin.viewStudentsInCourse(kb.nextLine().trim());
				break;
			case 11:
				System.out.print("Enter student first name: ");
				String first = kb.nextLine().trim();
				System.out.print("Enter student last name: ");
				String last = kb.nextLine().trim();
				admin.viewCoursesForStudent(first, last);
				break;
			case 12:
				admin.sortCourses();
				break;
			case 13:
				running = false;
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option.");
			}
		}
	}

	private static void createCourse(Scanner kb, Admin admin) {
		System.out.print("Course name: ");
		String name = kb.nextLine().trim();
		System.out.print("Course ID: ");
		String id = kb.nextLine().trim();
		System.out.print("Max students: ");
		int max = readInt(kb);
		kb.nextLine();
		System.out.print("Instructor: ");
		String instructor = kb.nextLine().trim();
		System.out.print("Section number: ");
		int section = readInt(kb);
		kb.nextLine();
		System.out.print("Location: ");
		String location = kb.nextLine().trim();
		Course c = new Course(name, id, max, instructor, section, location);
		admin.createCourse(c);
		System.out.println("Course created.");
	}

	private static void editCourse(Scanner kb, ArrayList<Course> courses) {
		System.out.print("Enter course ID to edit: ");
		String id = kb.nextLine().trim();
		Course c = null;
		for (Course x : courses) {
			if (x.getCourseId().equals(id)) { c = x; break; }
		}
		if (c == null) {
			System.out.println("Course not found.");
			return;
		}
		System.out.println("Edit: 1.Max students 2.Instructor 3.Section 4.Location");
		int opt = readInt(kb);
		kb.nextLine();
		if (opt == 1) {
			System.out.print("New max students: ");
			c.setMaxStudents(readInt(kb));
			kb.nextLine();
		} else if (opt == 2) {
			System.out.print("New instructor: ");
			c.setCourseInstructor(kb.nextLine().trim());
		} else if (opt == 3) {
			System.out.print("New section: ");
			c.setCourseSection(readInt(kb));
			kb.nextLine();
		} else if (opt == 4) {
			System.out.print("New location: ");
			c.setCourseLocation(kb.nextLine().trim());
		}
		System.out.println("Course updated.");
	}

	private static void registerStudent(Scanner kb, Admin admin, ArrayList<Course> courses) {
		System.out.print("Username: ");
		String username = kb.nextLine().trim();
		System.out.print("Password: ");
		String password = kb.nextLine().trim();
		System.out.print("First name: ");
		String first = kb.nextLine().trim();
		System.out.print("Last name: ");
		String last = kb.nextLine().trim();
		Student s = new Student(username, password, first, last);
		admin.registerStudent(s);
		System.out.println("Student registered.");
	}

	private static void runStudentMenu(Scanner kb, Student student, ArrayList<Course> courses) {
		boolean running = true;
		while (running) {
			student.displayMenu();
			System.out.print("Enter choice (1-6): ");
			int choice = readInt(kb);
			kb.nextLine();

			switch (choice) {
			case 1:
				student.viewAllCourses(courses);
				break;
			case 2:
				student.viewOpenCourses(courses);
				break;
			case 3:
				System.out.print("Course name: ");
				String cName = kb.nextLine().trim();
				System.out.print("Course section: ");
				int sec = readInt(kb);
				kb.nextLine();
				System.out.print("Your first name: ");
				String f = kb.nextLine().trim();
				System.out.print("Your last name: ");
				String l = kb.nextLine().trim();
				student.registerCourse(courses, cName, sec, f, l);
				break;
			case 4:
				System.out.print("Course name: ");
				String wName = kb.nextLine().trim();
				System.out.print("Course section: ");
				int wSec = readInt(kb);
				kb.nextLine();
				student.withdrawCourse(courses, wName, wSec, student.getFirstName(), student.getLastName());
				break;
			case 5:
				student.viewRegisteredCourses(courses);
				break;
			case 6:
				running = false;
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option.");
			}
		}
	}

	private static int readInt(Scanner kb) {
		while (!kb.hasNextInt()) {
			kb.next();
		}
		return kb.nextInt();
	}
}
