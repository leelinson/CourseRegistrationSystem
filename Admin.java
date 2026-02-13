package crsHW1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;



public class Admin extends User implements AdminInterface {


   private ArrayList<Course> courses;


   public Admin(String username, String password, String firstName, String lastName, ArrayList<Course> courses) {
       super(username, password, firstName, lastName);
       this.courses = courses;
   }


   public void displayMenu() {
       System.out.println("Admin Menu");
       System.out.println("1. Create Course");
       System.out.println("2. Delete Course");
       System.out.println("3. Edit Course");
       System.out.println("4. Display Course Information");
       System.out.println("5. Register A Student");
       System.out.println("6. View All Courses");
       System.out.println("7. View Full Courses");
       System.out.println("8. Save to File Full Courses");
       System.out.println("9. Student's Courses");
       System.out.println("10. Display Courses (Current Student Enrollment)");
       System.out.println("11. Exit");
   }


   public void createCourse(Course course) {
       courses.add(course);
   }


   public void deleteCourse(String courseID) {
	   for (Course course : courses) {
	       if (course.getCourseId().equals(courseID)) {
	           courses.remove(course);
	           break;
	       }
	   }
	}


   public void editCourse(String courseID) {
       for (Course course : courses) {
           if (course.getCourseId().equals(courseID)) {
               System.out.println("Editing course: " + course.getCourseName());
           }
       }
   }


   public void displayCourseInfo(String courseID) {
       for (Course course : courses) {
           if (course.getCourseId().equals(courseID)) {
               System.out.println(course);
           }
       }
   }


   public void viewAllCourses() {
       for (Course c : courses) {
           System.out.println(c);
       }
   }


   public void viewFullCourses() {
       for (Course course : courses) {
           if (course.isFull()) {
               System.out.println(course);
           }
       }
   }


   public void sortCourses() {
       Collections.sort(courses, Comparator.comparingInt(Course::getCurrentStudents));
       viewAllCourses();
   }
}
