public class Course {

    private String courseName;
    private String courseId;
    private int maxStudents;
    private int currentStudents;
    private ArrayList<Student> studentList;
    private String courseInstructor;
    private int courseSection;
    private String courseLocation;

    public Course (String a, String b, int c, int d, ArrayList<Student> e, String f, int i, String j) {

        this.courseName = a;
        this.courseId = b;
        this.maxStudents = c;
        this.currentStudents = d;
        this.studentList = e;
        this.courseInstructor = f;
        this.courseSection = i;
        this.courseLocation = j;

    }

    public Course(String courseName, String courseId, int maxStudents, String courseInstructor, String courseSection, String courseLocation) {
    }

    public boolean addStudent(String studentName) {

    }

    public boolean removeStudent(String studentName) {

    }

    public boolean isFull() {
        boolean full = false;
        if(currentStudents < maxStudents) {
            full = true;
        }
        return full;
    }


}
