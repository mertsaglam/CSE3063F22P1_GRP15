package Iteration_2.src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Student {

    private String studentID;
    private String studentName;
    private String studentSurname;
    private Transcript transcriptBefore;
    private Transcript transcriptAfter;
    private Schedule schedule;
    private Advisor advisor;
    private String enrolledYear;

    public Student(String studentName, String studentSurname, Transcript transcriptBefore, Transcript transcriptAfter,
                    Schedule schedule, Advisor advisor, String enrolledYear) {


        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.transcriptBefore = transcriptBefore;
        this.transcriptAfter = transcriptAfter;
        this.schedule = schedule;
        this.advisor = advisor;
        this.enrolledYear = enrolledYear;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
    public Student(String studentName, String studentSurname, Transcript transcriptBefore,
                    Schedule schedule, Advisor advisor, String enrolledYear) {


        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.transcriptBefore = transcriptBefore;
        this.schedule = schedule;
        this.advisor = advisor;
        this.enrolledYear = enrolledYear;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Student(String studentID, String studentName, String studentSurname, String enrolledYear) {

        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.enrolledYear = enrolledYear;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public String getStudentID() {
        return this.studentID;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public String getStudentSurname() {
        return this.studentSurname;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public String getStudentName() {
        return this.studentName;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Transcript getTranscriptBefore() {
        return transcriptBefore;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setTranscriptBefore(Transcript transcriptBefore) {
        this.transcriptBefore = transcriptBefore;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Transcript getTranscriptAfter() {
        return transcriptAfter;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setTranscriptAfter(Transcript transcriptAfter) {
        this.transcriptAfter = transcriptAfter;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Schedule getSchedule() {
        return this.schedule;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Advisor getAdvisor() {
        return this.advisor;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public String getEnrolledYear() {
        return this.enrolledYear;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setEnrolledYear(String enrolledYear) {
        this.enrolledYear = enrolledYear;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Student() {
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void createStudentID() {
        String department = "1501";
        this.setStudentID(department + this.enrolledYear.substring(2) + String.valueOf((int)(Math.random() * 1000)));
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
    
    public void calculateTranscriptAfter(EnrollmentRequest enrollmentRequest,double prob) {
        Student student = enrollmentRequest.getStudent();
        Transcript transcriptBefore = student.getTranscriptBefore();
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        ArrayList<CompulsoryCourse> failedCourses = new ArrayList<>();
        for(CompulsoryCourse course :courses){
            if(new Random().nextDouble() <prob){
                HashMap<String,String> failed = new HashMap<>();
                failed.put(course.getCourseCode(),"FF");
                transcriptBefore.addCourseGrade(failed);
                System.out.println("Student "+ this.studentID +" failed the course "+ course.getCourseCode());
            }
        }
        transcriptBefore.addCourseGrade(transcriptBefore.randomCourseGrade(courses));

        transcriptBefore.addTakenCourse(enrollmentRequest.getCourses());
        transcriptBefore.setGpa(transcriptBefore.calculateGpa());
        student.setTranscriptAfter(transcriptBefore);
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", transcriptBefore=" + transcriptBefore +
                ", transcriptAfter=" + transcriptAfter +
                ", schedule=" + schedule +
                ", advisor=" + advisor +
                ", enrolledYear='" + enrolledYear + '\'' +
                '}';
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

}
