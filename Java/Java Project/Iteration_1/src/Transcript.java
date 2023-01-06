package Iteration_1.src;

import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    // courseGrades is haspMap of course object and grades in integer
    private HashMap<String, Float> courseGrades;
    // Iteration_1.src.Student object
    private  Student student;
    // Gpa is a float
    private float GPA;
    // takenCredit is an integer
    private int takenCredit;
    // takenCourses is an arraylist of course object
    private ArrayList<Course> takenCourses;
    // not taken courses is an arraylist of course object
    private ArrayList<Course> notTakenCourses;

    // constructor for Iteration_1.src.Transcript takes courseGrade,Iteration_1.src.Student object, gpa,
    // takenCredit, takenCourses, notTakenCourses


    public Transcript(HashMap<String, Float> courseGrades, Student student, float gpa, int takenCredit, ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.student = student;
        this.GPA = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
    }
    public Transcript(HashMap<String, Float> courseGrades,  float gpa, int takenCredit, ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.GPA = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
    }

    // constructor for Iteration_1.src.Transcript takes nothing as a parameter
    public Transcript() {
        this.courseGrades = new HashMap<>();
        this.student = new Student();
        this.GPA = 0;
        this.takenCredit = 0;
        this.takenCourses = new ArrayList<>();
        this.notTakenCourses = new ArrayList<>();
    }

    // set method for Iteration_1.src.Transcript takes courseGrade,Iteration_1.src.Student object, gpa, takenCredit,
    // takenCourses, notTakenCourses
    public void setTranscript(HashMap<String, Float> courseGrades,  float gpa, int takenCredit,
            ArrayList<Course> takenCourses, ArrayList<Course> notTakenCourses) {
        this.courseGrades = courseGrades;

        this.GPA = gpa;
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

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
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

    @Override
    public String toString() {
        return "Iteration_1.src.Transcript{" +
                "courseGrades=" + courseGrades +
                ", student=" + student +
                ", gpa=" + GPA +
                ", takenCredit=" + takenCredit +
                ", takenCourses=" + takenCourses +
                ", notTakenCourses=" + notTakenCourses +
                '}';
    }
}
