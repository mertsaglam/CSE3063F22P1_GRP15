package Iteration_2.src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RegistrationSystem {
    public void checkCourseIsTakenBefore(EnrollmentRequest enrollmentRequest) {
        Student student = enrollmentRequest.getStudent();
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        for (CompulsoryCourse course : courses) {
            if (student.getTranscriptBefore().getTakenCourses().contains(course)) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put(course.getCourseCode(), "takenBefore");
                enrollmentRequest.appendResult(result);
            }

        }

    }

    public void checkPrerequisites(EnrollmentRequest enrollmentRequest) {
        ArrayList<CompulsoryCourse> compulsaryCourses = enrollmentRequest.getCourses();
        Student student = enrollmentRequest.getStudent();

        for (CompulsoryCourse course : compulsaryCourses) {
            if (course.getPrerequisites().contains(course)) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put(course.getCourseCode(), "notSatisfiedPreRequisite");
                enrollmentRequest.appendResult(result);
            }

        }

    }



    public void getTotalCredit(EnrollmentRequest enrollmentRequest) {
        Student student = enrollmentRequest.getStudent();
        int totalCreditTaken = 0;
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();

        for (CompulsoryCourse course : courses) {
            totalCreditTaken += course.getCredit();
        }

        if (totalCreditTaken > enrollmentRequest.getCreditLimit()) {
            HashMap<String, String> result = new HashMap<String, String>();
            Random random = new Random();
            result.put(courses.get(random.nextInt(courses.toArray().length)).getCourseCode(), "creditLimitExceed");
            enrollmentRequest.appendResult(result);
        }
    }



}