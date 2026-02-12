User.java (Abstract Class)
AdminInterface.java
StudentInterface.java
Course.java
Admin.java
Student.java
CourseRegistrationSystem.java (Main)
FileManager.java (Serialization)

                                      <<interface>>
                                   AdminInterface
                          --------------------------------
                          + createCourse(Course) : void
                          + deleteCourse(String) : void
                          + editCourse(String) : void
                          + displayCourseInfo(String) : void
                          + viewAllCourses() : void
                          + viewFullCourses() : void
                          + sortCourses() : void
                          --------------------------------


                                      <<interface>>
                                   StudentInterface
                          --------------------------------
                          + viewAllCourses() : void
                          + viewOpenCourses() : void
                          + registerCourse(String,int) : void
                          + withdrawCourse(String,int) : void
                          + viewRegisteredCourses() : void
                          --------------------------------



                               <<abstract>>
                                   User
            -------------------------------------------------
            - username : String
            - password : String
            - firstName : String
            - lastName : String
            -------------------------------------------------
            + getUsername() : String
            + getPassword() : String
            + getFirstName() : String
            + getLastName() : String
            + displayMenu() : void
            -------------------------------------------------
                        ▲
                        │
        -----------------------------------
        │                                 │
      Admin                             Student
---------------------------------   ----------------------------------
- courses : ArrayList<Course>     - courses : ArrayList<Course>
                                  - registeredCourses : ArrayList<Course>
---------------------------------   ----------------------------------
+ createCourse(Course)            + viewAllCourses()
+ deleteCourse(String)            + viewOpenCourses()
+ editCourse(String)              + registerCourse(String,int)
+ displayCourseInfo(String)       + withdrawCourse(String,int)
+ viewAllCourses()                + viewRegisteredCourses()
+ viewFullCourses()               + displayMenu()
+ sortCourses()                   ----------------------------------
+ displayMenu()
---------------------------------

Admin ─────────────── implements ───────────────► AdminInterface
Student ───────────── implements ───────────────► StudentInterface



                                  Course
        -------------------------------------------------
        - courseName : String
        - courseID : String
        - maxStudents : int
        - currentStudents : int
        - studentList : ArrayList<String>
        - instructor : String
        - section : int
        - location : String
        -------------------------------------------------
        + isFull() : boolean
        + addStudent(String) : void
        + removeStudent(String) : void
        + getCourseID() : String
        + getCourseName() : String
        + getCurrentStudents() : int
        + getMaxStudents() : int
        + getSection() : int
        -------------------------------------------------


Admin ◇────────────── Course
Student ◇──────────── Course



                                FileManager
        -------------------------------------------------
        + saveCourses(ArrayList<Course>) : void
        + loadCourses() : ArrayList<Course>
        -------------------------------------------------
