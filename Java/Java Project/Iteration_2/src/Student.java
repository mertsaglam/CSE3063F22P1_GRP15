package Iteration_2.src;


import org.apache.log4j.Logger;

import java.util.ArrayList;

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
        this.setStudentID(department + this.enrolledYear.substring(2) + String.valueOf((int)(Math.random() * 899)+100));

    }
    public void calculateTranscriptAfter(EnrollmentRequest enrollmentRequest,double prob) {
        Student student = enrollmentRequest.getStudent();
        Transcript transcriptBefore = student.getTranscriptBefore();
        Logger logger= Logger.getLogger(Student.class.getName());

        Transcript temp = new Transcript();

        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        int takenCredit = 0;
        for(int credit : courses.stream().map(CompulsoryCourse::getCredit).toList())
            takenCredit += credit;
        logger.info("End of the term: Student "+ student.getStudentID()+" passed the courses: "+ courses.stream().map(CompulsoryCourse::getCourseCode).toList());
        temp.setTakenCredit(transcriptBefore.getTakenCredit()+takenCredit);
        temp.addCourseGrade(temp.randomCourseGrade(courses,prob));
        temp.addCourseGrade(transcriptBefore.getCourseGrades());
        temp.addTakenCourse(courses);
        temp.addTakenCourse(transcriptBefore.getTakenCourses());
        temp.setGpa(temp.calculateGpa());
        student.setTranscriptAfter(temp);
        logger.info("New GPA is calculated and transcript is updated. ");



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
