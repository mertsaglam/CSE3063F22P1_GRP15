package Iteration_2.src;




import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    // courseGrades is haspMap of course object and grades in integer
    private HashMap<String, Integer> courseGrades;
    // Student object
    //private Student student;
    // Gpa is a float
    private float gpa;
    // takenCredit is an integer
    private int takenCredit;
    // takenCourses is an arraylist of course object
    private ArrayList<CompulsoryCourse> takenCourses;
    // not taken courses is an arraylist of course object
    private ArrayList<CompulsoryCourse> notTakenCourses;

    // constructor for Transcript takes courseGrade,Student object, gpa,
    // takenCredit, takenCourses, notTakenCourses


    /*public Transcript(HashMap<String, Float> courseGrades, Student student, float gpa, int takenCredit, ArrayList<CompulsoryCourse> takenCourses, ArrayList<CompulsoryCourse> notTakenCourses) {
        this.courseGrades = courseGrades;
        //this.student = student;
        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
    }*/
    public Transcript(HashMap<String, Integer> courseGrades, float gpa, int takenCredit, ArrayList<CompulsoryCourse> takenCourses, ArrayList<CompulsoryCourse> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
    }

    // constructor for Transcript takes nothing as a parameter
    public Transcript() {
        this.courseGrades = new HashMap<>();
        //this.student = new Student();
        this.gpa = 0;
        this.takenCredit = 0;
        this.takenCourses = new ArrayList<>();
        this.notTakenCourses = new ArrayList<>();
    }

    // set method for Transcript takes courseGrade,Student object, gpa, takenCredit,
    // takenCourses, notTakenCourses
    public void setTranscript(HashMap<String, Integer> courseGrades, float gpa, int takenCredit,
                              ArrayList<CompulsoryCourse> takenCourses, ArrayList<CompulsoryCourse> notTakenCourses) {
        this.courseGrades = courseGrades;

        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;

    }
    public void addTakenCourse(CompulsoryCourse course){
        this.takenCourses.add(course);
    }
    public void removeCourse(CompulsoryCourse course){
        this.notTakenCourses.remove(course);
    }

    public HashMap<String, Integer> getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(HashMap<String, Integer> courseGrades) {
        this.courseGrades = courseGrades;
    }

    /*public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/

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

    public ArrayList<CompulsoryCourse> getTakenCourses() {
        return takenCourses;
    }

    public void setTakenCourses(ArrayList<CompulsoryCourse> takenCourses) {
        this.takenCourses = takenCourses;
    }

    public ArrayList<CompulsoryCourse> getNotTakenCourses() {
        return notTakenCourses;
    }

    public void setNotTakenCourses(ArrayList<CompulsoryCourse> notTakenCourses) {
        this.notTakenCourses = notTakenCourses;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "courseGrades=" + courseGrades +
                //", student=" + student +
                ", gpa=" + gpa +
                ", takenCredit=" + takenCredit +
                ", takenCourses=" + takenCourses +
                ", notTakenCourses=" + notTakenCourses +
                '}';
    }
}
