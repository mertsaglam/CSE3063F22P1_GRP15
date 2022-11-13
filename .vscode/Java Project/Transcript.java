import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    // courseGrades is haspMap of course object and grades in integer
    private HashMap<Course, Float> courseGrades;
    // Student object
    private Student student;
    // Gpa is a float
    private float gpa;
    // takenCredit is an integer
    private int takenCredit;
    // takenCourses is an arraylist of course object
    private ArrayList<Course> takenCourses;
    // not taken courses is an arraylist of course object
    private ArrayList<Course> notTakenCourses;

    // constructor for Transcript takes courseGrade,Student object, gpa,
    // takenCredit, takenCourses, notTakenCourses
    public Transcript(HashMap<Course, Float> courseGrades, Student student, float gpa, int takenCredit,
            ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.student = student;
        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
    }

    // constructor for Transcript takes nothing as a parameter
    public Transcript() {
        this.courseGrades = new HashMap<>();
        this.student = new Student();
        this.gpa = 0;
        this.takenCredit = 0;
        this.takenCourses = new ArrayList<>();
        this.notTakenCourses = new ArrayList<>();
    }

    // set method for Transcript takes courseGrade,Student object, gpa, takenCredit,
    // takenCourses, notTakenCourses
    public void setTranscript(HashMap<Course, Float> courseGrades, Student student, float gpa, int takenCredit,
            ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.student = student;
        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;

    }

}
