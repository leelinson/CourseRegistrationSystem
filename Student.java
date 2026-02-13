package crsHW1;

import java.util.ArrayList;


public class Student extends User implements StudentInterface {


   private ArrayList<Course> courses;
   private ArrayList<Course> registeredCourses;


   public Student(String username, String password, String firstName, String lastName, ArrayList<Course> courses) {
       super(username, password, firstName, lastName);
       this.courses = courses;
       this.registeredCourses = new ArrayList<>();
   }

// this is where to copy paste
   public void displayMenu() {
       System.out.println("Student Menu");
           System.out.println("1. View All Courses");
           System.out.println("2. View all courses that are not full");
           System.out.println("3. Register on a course");
           System.out.println("4. Withdraw from a course");
           System.out.println("5. View all courses registered");
           System.out.println("6. Exit");
       
   }


   public void viewAllCourses() {
       for (Course course : courses) {
           System.out.println(course);
       }
   }


   public void viewOpenCourses() {
       for (Course course : courses) {
           if (!course.isFull()) {
               System.out.println(course);
           }
       }
   }


   public void registerCourse(String name, int section, String firstName, String lastName) {
       for (Course course : courses) {
           if (course.getCourseName().equals(name) && course.getCourseSection() == section) {
               if (!course.isFull()) {
                   course.addStudent(firstName + " " + lastName);
                   registeredCourses.add(course);
               }
           }
       }
   }


   public void withdrawCourse(String name, int section, String firstName, String lastName) {
	    for (int i = 0; i < registeredCourses.size(); i++) {
	        Course course = registeredCourses.get(i);
	        if (course.getCourseName().equals(name) &&
	            course.getCourseSection() == section) {

	            course.removeStudent(firstName + " " + lastName);
	            registeredCourses.remove(i);
	            break;
	        }
	    }
	}



   public void viewRegisteredCourses() {
       for (Course course : registeredCourses) {
           System.out.println(course);
       }
   }
}
