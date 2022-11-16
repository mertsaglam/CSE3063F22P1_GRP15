import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    // courseGrades is haspMap of course object and grades in integer
    private HashMap<String, Float> courseGrades;
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


    public Transcript(HashMap<String, Float> courseGrades, Student student, float gpa, int takenCredit, ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
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
    public void setTranscript(HashMap<String, Float> courseGrades, Student student, float gpa, int takenCredit,
            ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.student = student;
        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;

    }
    public void addTakenCourse(Course course){
        this.takenCourses.add(course);
    }
    public void removeCourse(Course course){
        this.notTakenCourses.remove(course);
    }

    public HashMap<String, Float> getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(HashMap<String, Float> courseGrades) {
        this.courseGrades = courseGrades;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getTakenCredit() {
        return takenCredit;
    }

    public void setTakenCredit(int takenCredit) {
        this.takenCredit = takenCredit;
    }

    public ArrayList<Course> getTakenCourses() {
        return takenCourses;
    }

    public void setTakenCourses(ArrayList<Course> takenCourses) {
        this.takenCourses = takenCourses;
    }

    public ArrayList<Course> getNotTakenCourses() {
        return notTakenCourses;
    }

    public void setNotTakenCourses(ArrayList<Course> notTakenCourses) {
        this.notTakenCourses = notTakenCourses;
    }
}
