import java.io.*;
import java .util.*;

public class FileLoader {

    public static ArrayList<Course> loadedFromCSV(String file) {
        ArrayList<Course> courseList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while((line = br.readLine()) != null) {

                String[] info = line.split(",");

                String courseName = info[0];
                String courseId = info[1];
                int maxStudents = Integer.parseInt(info[2]);
                String courseInstructor = info[5];
                String courseSection = info[6];
                String courseLocation = info[7];

                Course course = new Course(courseName, courseId, maxStudents, courseInstructor, courseSection, courseLocation);
                courseList.add(course);
            }
        }
        catch (IOException error) {
            error.printStackTrace();
        }

        return courseList;

    }
}
