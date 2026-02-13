package crsHW1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles file I/O: CSV for initial courses (Req 08), serialization for courses and students (Req 12).
 */
public class FileManager {

	private static final String COURSES_SER = "courses.ser";
	private static final String STUDENTS_SER = "students.ser";
	private static final String CSV_FILENAME = "MyUniversityCourses.csv";

	/** Save courses to binary file (serialization). */
	public static void saveCourses(ArrayList<Course> courses) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(COURSES_SER))) {
			out.writeObject(courses);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Save students to binary file (serialization). */
	public static void saveStudents(ArrayList<Student> students) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(STUDENTS_SER))) {
			out.writeObject(students);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Load courses from CSV: name, id, max, (cols 3,4), instructor, section, location (Req 08). */
	public static ArrayList<Course> loadCoursesFromCSV(String filename) {
		ArrayList<Course> courses = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine(); // header
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length < 8) continue;
				String name = parts[0].trim();
				String id = parts[1].trim();
				int max = Integer.parseInt(parts[2].trim());
				String instructor = parts[5].trim();
				int section = Integer.parseInt(parts[6].trim());
				String location = parts[7].trim();
				courses.add(new Course(name, id, max, instructor, section, location));
			}
		} catch (Exception e) {
			System.out.println("Could not load CSV: " + e.getMessage());
		}
		return courses;
	}

	/** Load courses: from .ser if present, else from CSV. */
	public static ArrayList<Course> loadCourses() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(COURSES_SER))) {
			@SuppressWarnings("unchecked")
			ArrayList<Course> courses = (ArrayList<Course>) in.readObject();
			if (courses == null || courses.isEmpty()) {
				return loadCoursesFromCSV(CSV_FILENAME);
			}
			return courses;
		} catch (Exception e) {
			return loadCoursesFromCSV(CSV_FILENAME);
		}
	}

	/** Load students from serialized file; returns empty list if file missing. */
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> loadStudents() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(STUDENTS_SER))) {
			Object obj = in.readObject();
			return obj != null ? (ArrayList<Student>) obj : new ArrayList<>();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	/** Write list of full courses to a text file (Req 03 Reports option 3). */
	public static void writeFullCoursesToFile(List<Course> fullCourses, String filename) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
			for (Course c : fullCourses) {
				pw.println(c.getCourseName() + "," + c.getCourseId() + ","
						+ c.getCurrentStudents() + "/" + c.getMaxStudents());
			}
		} catch (IOException e) {
			System.out.println("Could not write file: " + e.getMessage());
		}
	}
}
