package crsHW1;

import java.util.ArrayList;
import java.util.Scanner;


public class MainPage {


   public static void main(String[] args) {
	   System.out.println("Working dir = " + System.getProperty("user.dir"));



       ArrayList<Course> courses = FileManager.loadCourses();
       System.out.println("Loaded courses = " + courses.size());

       Scanner kb = new Scanner(System.in);


       Admin admin1 = new Admin("Admin", "Admin001", "Justin", "Elkareh", courses);


       Student student1 = new Student("leelinson", "bariisthebest", "Linson", "Lee", courses);


       System.out.println("Login as: 1. Admin  2. Student");
       int input1 = kb.nextInt();


       if (input1 == 1) {
           System.out.print("Username: ");
           String username = kb.next();
           System.out.print("Password: ");
           String password = kb.next();


           if (username.equals("Admin") && password.equals("Admin001")) {
        	   boolean running = true;

               while (running) {

            	   admin1.displayMenu();
            	   System.out.println("Enter Choice: ");
            	   int choice = kb.nextInt();
               

               if(choice == 1) {
                   System.out.print("Enter Course Name: ");
                   String name = kb.next();


                   System.out.print("Enter Course Id: ");
                   String id = kb.next();


                   System.out.print("Enter Max Students: ");
                   int max = kb.nextInt();


                   System.out.print("Enter Instructor: ");
                   String instructor = kb.next();


                   System.out.print("Enter Section: ");
                   int section = kb.nextInt();


                   System.out.print("Enter Location: ");
                   String location = kb.next();


                   Course course = new Course(name, id, max, instructor, section, location);


                   admin1.createCourse(course);


         
               }
               if(choice == 2) {
                   System.out.print("Enter Course Id: ");
                   String courseId = kb.next();
                   admin1.deleteCourse(courseId);
                 
               }
               if(choice == 3) {
            	    System.out.print("Enter Course Id: ");
            	    String id = kb.next();

            	    Course selectedCourse = null;

            	    for (Course c : courses) {
            	        if (c.getCourseId().equals(id)) {
            	            selectedCourse = c;
            	            break;
            	        }
            	    }

            	    if (selectedCourse != null) {

            	        System.out.print("Choose: 1. Max Students 2. Instructor 3. Section 4. Location: ");
            	        int choice3 = kb.nextInt();

            	        if(choice3 == 1) {
            	            System.out.print("Enter New Max Students: ");
            	            int max = kb.nextInt();
            	            selectedCourse.setMaxStudents(max);
            	        }
            	        else if(choice3 == 2) {
            	            System.out.print("Enter New Instructor: ");
            	            String instructor = kb.next();
            	            selectedCourse.setCourseInstructor(instructor);
            	        }
            	        else if(choice3 == 3) {
            	            System.out.print("Enter New Section: ");
            	            int section = kb.nextInt();
            	            selectedCourse.setCourseSection(section);
            	        }
            	        else if(choice3 == 4) {
            	            System.out.print("Enter New Location: ");
            	            String location = kb.next();
            	            selectedCourse.setCourseLocation(location);
            	        }
            	    }
            	    else {
                        System.out.println("Course not found.");
                    } 
               }
            	   

               if(choice == 4) {
                   System.out.print("Enter Course Id: ");
                   String id1 = kb.next();
                   admin1.displayCourseInfo(id1);
               }
               if (choice == 11) {
            	   System.out.println("Bye.");
                   running = false;
                   
               
               }
               
               }
           }
               else {
                   System.out.println("Invalid Login.");
               }
               }  
   


              
              
           
       


       else if(input1 == 2) {
    
    	   int choice;

           System.out.print("Username: ");
           String username = kb.next();
           System.out.print("Password: ");
           String password = kb.next();


           if (username.equals("leelinson") && password.equals("bariisthebest")) {
        	   
        	   boolean running = true;

        	    while (running) {
               student1.displayMenu();
               System.out.println("Enter Choice: ");
               choice = kb.nextInt();
               
               if(choice == 1) {
            	   student1.viewAllCourses();
            	   
               }
               if(choice == 2) {
            	   student1.viewOpenCourses();
            	
               }
         
           
            	   
            	   if(choice == 3) {

            		    System.out.print("Enter Course Name: ");
            		    String CName = kb.next();

            		    System.out.print("Enter Course Section: ");
            		    int CSec = kb.nextInt();

            		    System.out.print("Enter First Name: ");
            		    String SNameF = kb.next();

            		    System.out.print("Enter Last Name: ");
            		    String SNameL = kb.next();

            		    student1.registerCourse(CName, CSec, SNameF, SNameL);
            		
            		
               }
          
           
               		if(choice == 4) {

               		    System.out.print("Enter Course Name: ");
               		    String CName = kb.next();

               		    System.out.print("Enter Course Section: ");
               		    int CSec = kb.nextInt();

               		    System.out.print("Enter First Name: ");
               		    String SNameF = kb.next();

               		    System.out.print("Enter Last Name: ");
               		    String SNameL = kb.next();

               		    student1.withdrawCourse(CName, CSec, SNameF, SNameL);
               		
               		}
               
               	if(choice == 5) {
                    
             	   
            

                    student1.viewRegisteredCourses();
                   
                }
               	if(choice == 6) {
               		running = false;
                }
               
               
               
               }
           
           }
       else {
           System.out.println("Invalid Login. ");
       }
           
               
       


       


       FileManager.saveCourses(courses);
       kb.close();
   }


}
}


