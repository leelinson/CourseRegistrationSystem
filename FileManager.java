package crsHW1;


import java.io.*;
import java.util.ArrayList;


public class FileManager {


   public static void saveCourses(ArrayList<Course> courses) {
       try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("courses.ser"))) {
           output.writeObject(courses);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   private static ArrayList<Course> loadCoursesFromCSV(String filename) {
	    ArrayList<Course> courses = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        String line = br.readLine(); 

	        while ((line = br.readLine()) != null) {
	            
	            String[] parts = line.split(",");

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


   public static ArrayList<Course> loadCourses() {

	    try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("courses.ser"))) {
	        ArrayList<Course> courses = (ArrayList<Course>) input.readObject();

	        if (courses == null || courses.isEmpty()) {
	            System.out.println("courses.ser is empty. Loading from CSV...");
	            return loadCoursesFromCSV("MyUniversityCourses.csv");
	        }

	        return courses;

	    } catch (Exception e) {
	        System.out.println("courses.ser not found. Loading from CSV...");
	        return loadCoursesFromCSV("MyUniversityCourses.csv");
	    }
	}


}
