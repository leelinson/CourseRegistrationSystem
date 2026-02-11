package crs;

import java.util.ArrayList;
import java.util.Scanner;

public class CRSApp {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    private final Scanner sc = new Scanner(System.in);
    private final DataStore dataStore = new DataStore();

    public static void main(String[] args) {
        new CRSApp().run();
    }

    public void run() {
        // 1) load data
        courses = dataStore.loadCourses();
        students = dataStore.loadStudents();

        // 2) login / choose role
        while (true) {
            System.out.println("\n=== Course Registration System ===");
            System.out.println("1) Admin");
            System.out.println("2) Student");
            System.out.println("3) Exit");
            System.out.print("Choose: ");

            int choice = readInt();
            if (choice == 1) {
                adminFlow();
            } else if (choice == 2) {
                studentFlow();
            } else if (choice == 3) {
                exitAndSave();
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void adminFlow() {
        // TODO: login check later (Admin/Admin001)
        System.out.println("\n[Admin] (login skipped for now)");
        // TODO: show admin menu loop
    }

    private void studentFlow() {
        // TODO: login check later
        System.out.println("\n[Student] (login skipped for now)");
        // TODO: show student menu loop
    }

    private void exitAndSave() {
        dataStore.saveCourses(courses);
        dataStore.saveStudents(students);
        sc.close();
    }

    private int readInt() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a number: ");
            }
        }
    }
}
