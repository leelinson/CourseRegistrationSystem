package crs;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

    private String courseName;
    private String courseId;
    private int maxStudents;
    private int currentStudents;
    private ArrayList<String> studentNames;
    private String instructor;
    private int section;
    private String location;

    // 构造器（推荐用这个）
    public Course(String courseName, String courseId, int maxStudents,
                  String instructor, int section, String location) {

        this.courseName = courseName;
        this.courseId = courseId;
        this.maxStudents = maxStudents;
        this.currentStudents = 0;
        this.studentNames = new ArrayList<>();
        this.instructor = instructor;
        this.section = section;
        this.location = location;
    }

    // ========================
    // 核心业务方法
    // ========================

    public boolean isFull() {
        return currentStudents >= maxStudents;
    }

    public boolean addStudent(String fullName) {
        if (isFull()) return false;
        if (studentNames.contains(fullName)) return false;

        studentNames.add(fullName);
        currentStudents++;
        return true;
    }

    public boolean removeStudent(String fullName) {
        if (studentNames.remove(fullName)) {
            currentStudents--;
            return true;
        }
        return false;
    }

    // ========================
    // Getter 方法
    // ========================

    public String getCourseName() { return courseName; }
    public String getCourseId() { return courseId; }
    public int getMaxStudents() { return maxStudents; }
    public int getCurrentStudents() { return currentStudents; }
    public ArrayList<String> getStudentNames() { return studentNames; }
    public String getInstructor() { return instructor; }
    public int getSection() { return section; }
    public String getLocation() { return location; }

    // 用于打印
    public String getCourseInfo() {
        return "Course: " + courseName +
                " | ID: " + courseId +
                " | Section: " + section +
                " | Instructor: " + instructor +
                " | Students: " + currentStudents + "/" + maxStudents +
                " | Location: " + location;
    }
}
