package Iteration_2.src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Transcript {
    // courseGrades is haspMap of course object and grades in integer
    private HashMap<String, String> courseGrades;
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
    public Transcript(HashMap<String, String> courseGrades, float gpa, int takenCredit, ArrayList<CompulsoryCourse> takenCourses, ArrayList<CompulsoryCourse> notTakenCourses) {
        this.courseGrades = courseGrades;
        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    // constructor for Transcript takes nothing as a parameter
    public Transcript() {
        this.courseGrades = new HashMap<>();
        //this.student = new Student();
        this.gpa = 0;
        this.takenCredit = 0;
        this.takenCourses = new ArrayList<>();
        this.notTakenCourses = new ArrayList<>();
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    // set method for Transcript takes courseGrade,Student object, gpa, takenCredit,
    // takenCourses, notTakenCourses
    public void setTranscript(HashMap<String, String> courseGrades, float gpa, int takenCredit,
                              ArrayList<CompulsoryCourse> takenCourses, ArrayList<CompulsoryCourse> notTakenCourses) {
        this.courseGrades = courseGrades;

        this.gpa = gpa;
        this.takenCredit = takenCredit;
        this.takenCourses = takenCourses;
        this.notTakenCourses = notTakenCourses;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();

    }

    public void addTakenCourse(ArrayList<CompulsoryCourse> courses) {
        this.takenCourses.addAll(courses);
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
    public void addTakenCourseOne(CompulsoryCourse course) {
        this.takenCourses.add(course);
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
    public void removeCourse(ArrayList<CompulsoryCourse> courses) {
        this.notTakenCourses.remove(courses);
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
    public  void  addCourseGrade(HashMap<String,String> courseGrades){
        this.courseGrades.putAll(courseGrades);
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }


    public HashMap<String, String> getCourseGrades() {
        return courseGrades;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setCourseGrades(HashMap<String, String> courseGrades) {
        this.courseGrades = courseGrades;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    /*public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/

    public float getGpa() {
        return gpa;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public int getTakenCredit() {
        return takenCredit;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setTakenCredit(int takenCredit) {
        this.takenCredit = takenCredit;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public ArrayList<CompulsoryCourse> getTakenCourses() {
        return takenCourses;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setTakenCourses(ArrayList<CompulsoryCourse> takenCourses) {
        this.takenCourses = takenCourses;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public ArrayList<CompulsoryCourse> getNotTakenCourses() {
        return notTakenCourses;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setNotTakenCourses(ArrayList<CompulsoryCourse> notTakenCourses) {
        this.notTakenCourses = notTakenCourses;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public float calculateGpa() {
        float gpa = 0f;
        int totalCredit = 0;
        for (int j = 0; j < this.getTakenCourses().size(); j++) {
            String letterGrade = this.getCourseGrades().get(this.getTakenCourses().get(j).getCourseCode());
            if (letterGrade == "AA")
                gpa += this.getTakenCourses().get(j).getCredit() * 4;
            else if (letterGrade == "BA")
                gpa += this.getTakenCourses().get(j).getCredit() * 3.5;
            else if (letterGrade == "BB")
                gpa += this.getTakenCourses().get(j).getCredit() * 3;
            else if (letterGrade == "CB")
                gpa += this.getTakenCourses().get(j).getCredit() * 2.5;
            else if (letterGrade == "CC")
                gpa += this.getTakenCourses().get(j).getCredit() * 2;
            else if (letterGrade == "DC")
                gpa += this.getTakenCourses().get(j).getCredit() * 1.5;
            totalCredit += this.getTakenCourses().get(j).getCredit();
        }

        return Math.round((gpa / totalCredit) * 100.0) / 100.0f;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public HashMap<String, String> randomCourseGrade(ArrayList<CompulsoryCourse> courses) {
        String[] letterGrades = {"AA", "BA", "BB", "CB", "CC", "DC"};
        HashMap<String, String> hashmap = new HashMap<String, String>();

        for (int j = 0; j < courses.size(); j++)
            hashmap.put(courses.get(j).getCourseCode(), letterGrades[new Random().nextInt(letterGrades.length - 1)]);


        return hashmap;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
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
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
}
