package Iteration_2.src;

import Iteration_1.src.Advisor;
import Iteration_1.src.Course;
import Iteration_1.src.EnrollmentRequest;
import Iteration_1.src.FileManager;
import Iteration_1.src.FileManager1;
import Iteration_1.src.Lecturer;
import Iteration_1.src.RegistrationSystem;
import Iteration_1.src.Schedule;
import Iteration_1.src.Semester;
import Iteration_1.src.Student;
import Iteration_1.src.Transcript;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CourseRegistrationSimulation {
    private ArrayList<Iteration_1.src.Student> students;
    private ArrayList<Iteration_1.src.Course> courses;
    private ArrayList<Iteration_1.src.Lecturer> lecturers;
    private ArrayList<Iteration_1.src.Advisor> advisors;
    private Iteration_1.src.Semester semester;
    private int creditLimit;
    private ArrayList<Iteration_1.src.EnrollmentRequest> enrollmentRequests;
    private ArrayList<String> errors ;

    public CourseRegistrationSimulation(ArrayList<Iteration_1.src.Student> students, ArrayList<Iteration_1.src.Course> courses, ArrayList<Lecturer> lecturers, ArrayList<Advisor> advisors, Iteration_1.src.Semester semester, int creditLimit) {
        this.students = students;
        this.courses = courses;
        this.lecturers = lecturers;
        this.advisors = advisors;
        this.semester = semester;
        this.creditLimit = creditLimit;
    }

    public CourseRegistrationSimulation() {
    }

    public void starSimulation() {
        createSemester();
        createCourses();
        createStudents();
        createLecturer();
        createEnrollmentRequest();
        checkSystemRequirements();
        printOutputs();

        printOutputs();


    }

    public void readParameters() {
        Iteration_1.src.FileManager fileManager = new FileManager();

    }

    public void createCourses() {
        Iteration_1.src.FileManager1 fileManager1 = new Iteration_1.src.FileManager1();
        this.courses = fileManager1.readCourse("Jsons/course.json");

    }

    public void createStudents() {//done
        Iteration_1.src.FileManager1 fileManager1 = new Iteration_1.src.FileManager1();
        this.students = fileManager1.readStudent("Jsons/student.json");

    }

    //CREATE COMPULSARY AND CREATE ELECTIVE COURSES
    public void createSemester() {
        Iteration_1.src.FileManager1 fileManager1 = new Iteration_1.src.FileManager1();
        this.semester = fileManager1.readSemester("Jsons/semester.json");


    }

    public void createLecturer() {
        Iteration_1.src.FileManager1 fileManager1 = new FileManager1();
        this.lecturers = fileManager1.readLecturers("Jsons/lecturer.json");

    }

    /*public void createAdvisor() {  // no need for iteration 1
        Iteration_1.src.FileManager fileManager = new Iteration_1.src.FileManager();
        this.advisors = fileManager.readAdvisor("/Users/omerfarukbulut/Downloads/student1.json");
    }*/

    public void matchStudentAdvisor() {
        for (Iteration_1.src.Student student : this.students) {
            student.setAdvisor(this.advisors.get(ThreadLocalRandom.current().nextInt(0, this.advisors.size() + 1)));
        }
    }

    public void createEnrollmentRequest() {
        for (Iteration_1.src.Student student : this.students) {
            ArrayList<Iteration_1.src.Course> randomCourse = this.courses;
            HashMap<String, Iteration_1.src.Schedule> scheduleWithCourse = new HashMap<>();
            for (Iteration_1.src.Course course : randomCourse) {
                scheduleWithCourse.put(course.getCourseCode(), course.getSchedule());
            }//CAN NOT HANDLE HOW TO REACH COURSE SECTION CLASS SCHEDULE POSTPONE TO LATER

            ArrayList<Iteration_1.src.EnrollmentRequest> enrollmentRequests = new ArrayList<Iteration_1.src.EnrollmentRequest>();
            enrollmentRequests.add(new Iteration_1.src.EnrollmentRequest(randomCourse, student, scheduleWithCourse));
            this.enrollmentRequests = enrollmentRequests;

        }

    }

    public void checkSystemRequirements() {
        Iteration_1.src.RegistrationSystem registrationSystem = new RegistrationSystem();
        for (Iteration_1.src.EnrollmentRequest enrollmentRequest1 : this.enrollmentRequests) {
            registrationSystem.getTotalCredit(enrollmentRequest1);
            registrationSystem.checkCourseIsTakenBefore(enrollmentRequest1);
            registrationSystem.checkPrerequisites(enrollmentRequest1);
            checkCourseIsOpened();

        }

    }


    public Iteration_1.src.Schedule combineSchedule(ArrayList<Iteration_1.src.Schedule> schedules) {
        Iteration_1.src.Schedule combinedSchedule = new Iteration_1.src.Schedule();
        HashMap<String, ArrayList<String>> temp = new HashMap<String, ArrayList<String>>();
        for (Schedule schedule : schedules) {
            temp.putAll(schedule.getCourseDayHour());
        }
        combinedSchedule.setCourseDayHour(temp);
        return combinedSchedule;
    }

    public ArrayList<Iteration_1.src.Course> getRandomCourse(ArrayList<Iteration_1.src.Course> list) {
        Random random = new Random();
        ArrayList<Iteration_1.src.Course> newList = new ArrayList<Iteration_1.src.Course>();

        for (int i = 0; i < random.nextInt(list.size()); i++) {
            int randomIndex = random.nextInt(list.size());
            newList.add(list.get(randomIndex));

        }
        return newList;
    }


    public void setTranscriptAfter() {
        for (Iteration_1.src.EnrollmentRequest enrollmentRequest : this.enrollmentRequests) {
            ArrayList<Iteration_1.src.Course> courses = enrollmentRequest.getCourses();
            Iteration_1.src.Student student = enrollmentRequest.getStudent();
            ArrayList<String> passedCourses = new ArrayList<String>();
            Random random = new Random();
            Iteration_1.src.Transcript transcript = student.getTranscriptBefore();
            for (Iteration_1.src.Course course : courses) {
                if (!enrollmentRequest.getResult().containsKey(course.getCourseCode())) {
                    passedCourses.add(course.getCourseCode());
                }
            }
            HashMap<String, Float> courseGrades = new HashMap<String, Float>();
            for (String courseCode : passedCourses) {
                courseGrades.put(courseCode, random.nextFloat(100));
                transcript.addTakenCourse(getCoursebyCourseCode(courseCode));
                transcript.removeCourse(getCoursebyCourseCode(courseCode));
            }
            int totalCredit = enrollmentRequest.getTotalCredit() + student.getTranscriptBefore().getTakenCredit();
            Iteration_1.src.Transcript transcript1 = new Transcript(courseGrades, student, random.nextFloat(4), totalCredit, transcript.getTakenCourses(), transcript.getNotTakenCourses());
            student.setTranscriptAfter(transcript1);
        }
    }

    public Iteration_1.src.Course getCoursebyCourseCode(String courseCode) {
        for (Iteration_1.src.Course course : this.courses) {
            if (course.getCourseCode().equals(courseCode))
                return course;

        }
        return null;
    }

    public void printOutputs() {

        System.out.println(this.errors);
    }
/*
    public ArrayList<Iteration_1.src.ElectiveCourse> getRandomElectiveCourses(ArrayList<Iteration_1.src.ElectiveCourse> list) {
        Random rand = new Random(); // object of Random class.

        //temprory list to hold selected items.
        ArrayList<Iteration_1.src.ElectiveCourse> tempList = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(list.size()); i++) {
            int randomIndex = rand.nextInt(list.size());
            tempList.add(list.get(randomIndex));
        }
        return tempList;
    }*/

    public void printArraylist(ArrayList<Student> arr) {
        for (int i = 0; i < arr.size(); i++) {
            // Assuming arr is an ArrayList object
            Object current = arr.get(i).toString();
            System.out.println(current);
            // Do something with the current element here
        }

    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public void checkCourseIsOpened() {
        Semester semester = this.semester;
        for(EnrollmentRequest enrollmentRequest: this.enrollmentRequests) {
            for (Course course : enrollmentRequest.getCourses()) {
                if (!semester.getOpenedCourse().contains(course)) {

                    enrollmentRequest.setError(enrollmentRequest.getStudent().getStudentName() + course.getCourseCode() + " not opened");
                    ArrayList<String> errorsBefore = new ArrayList<String>();
                    errorsBefore.add(enrollmentRequest.getStudent().getStudentName() + course.getCourseCode() + " not opened");
                    this.errors = errorsBefore;
                }

            }
        }

    }
}
