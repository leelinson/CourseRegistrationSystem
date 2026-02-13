package crsHW1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a university course (Req 01).
 * Stores: name, id, max/current students, list of registered student names,
 * instructor, section number, location. Used as ADT in ArrayLists.
 */
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	private String courseName;
	private String courseId;
	private int maxStudents;
	private int currentStudents;
	private ArrayList<String> studentList;
	private String courseInstructor;
	private int courseSection;
	private String courseLocation;

	public Course(String name, String id, int max, String instructor, int section, String location) {
       this.courseName = name;
       this.courseId = id;
       this.maxStudents = max;
       this.courseInstructor = instructor;
       this.courseSection = section;
       this.courseLocation = location;
       this.currentStudents = 0;
       this.studentList = new ArrayList<>();
   }


   public boolean isFull() {
       return currentStudents >= maxStudents;
   }


   public void addStudent(String studentName) {
       if (!isFull()) {
           studentList.add(studentName);
           currentStudents++;
       }
   }


   public void removeStudent(String studentName) {
       if (studentList.remove(studentName)) {
           currentStudents--;
       }
   }


   public String getCourseId() {
       return courseId;
   }


   public String getCourseName() {
       return courseName;
   }


   public int getCurrentStudents() {
       return currentStudents;
   }
  
   public int getMaxStudents() {
       return maxStudents;
   }


   public void setMaxStudents(int maxStudents) {
       this.maxStudents = maxStudents;
   }


   public String getCourseInstructor() {
       return courseInstructor;
   }


   public void setCourseInstructor(String courseInstructor) {
       this.courseInstructor = courseInstructor;
   }
  
   public int getCourseSection() {
       return courseSection;
   }
  
   public void setCourseSection(int courseSection) {
       this.courseSection = courseSection;
   }


   public String getCourseLocation() {
       return courseLocation;
   }


   public void setCourseLocation(String courseLocation) {
       this.courseLocation = courseLocation;
   }
  
   public ArrayList<String> getStudentList() {
       return studentList;
   }


	@Override
	public String toString() {
		return courseName + " | ID: " + courseId
				+ " | Registered: " + currentStudents + "/" + maxStudents
				+ " | " + courseInstructor + " | Sec " + courseSection + " | " + courseLocation;
	}
}
