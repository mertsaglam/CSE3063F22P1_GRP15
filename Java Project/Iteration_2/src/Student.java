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
    }
    public Student(String studentName, String studentSurname, Transcript transcriptBefore,
                    Schedule schedule, Advisor advisor, String enrolledYear) {


        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.transcriptBefore = transcriptBefore;
        this.schedule = schedule;
        this.advisor = advisor;
        this.enrolledYear = enrolledYear;
    }

    public Student(String studentID, String studentName, String studentSurname, String enrolledYear) {

        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.enrolledYear = enrolledYear;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentSurname() {
        return this.studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Transcript getTranscriptBefore() {
        return transcriptBefore;
    }

    public void setTranscriptBefore(Transcript transcriptBefore) {
        this.transcriptBefore = transcriptBefore;
    }

    public Transcript getTranscriptAfter() {
        return transcriptAfter;
    }

    public void setTranscriptAfter(Transcript transcriptAfter) {
        this.transcriptAfter = transcriptAfter;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Advisor getAdvisor() {
        return this.advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public String getEnrolledYear() {
        return this.enrolledYear;
    }

    public void setEnrolledYear(String enrolledYear) {
        this.enrolledYear = enrolledYear;
    }

    public Student() {
    }

    public void createStudentID() {
        String department = "1501";
        this.setStudentID(department + this.enrolledYear.substring(2) + String.valueOf((int)(Math.random() * 1000)));

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
    }

}
