package Iteration_2.src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RegistrationSystem {
    public void checkCourseIsTakenBefore(EnrollmentRequest enrollmentRequest) {
        Student student = enrollmentRequest.getStudent();
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        ArrayList<CompulsoryCourse> takenCourses = new ArrayList<CompulsoryCourse>();
        for (CompulsoryCourse course : courses) {
            if (student.getTranscriptBefore().getTakenCourses().stream().map(CompulsoryCourse::getCourseCode).toList().contains(course.getCourseCode())) {
                System.out.println("Course " + course.getCourseCode() + " can not be taken because it has already been taken.");
                //Log
            } else {
                System.out.println("Course " + course.getCourseCode() + " passed 'is taken before' test ");
                takenCourses.add(course);
                //Log

            }


        }
        enrollmentRequest.setCourses(takenCourses);

    }

    public void checkPrerequisites(EnrollmentRequest enrollmentRequest) {
        ArrayList<CompulsoryCourse> compulsaryCourses = enrollmentRequest.getCourses();
        Student student = enrollmentRequest.getStudent();
        ArrayList<CompulsoryCourse> takenCourses = new ArrayList<CompulsoryCourse>();
        for (CompulsoryCourse course : compulsaryCourses) {
            if (course.getPrerequisites() != null) {
                if (!student.getTranscriptBefore().getTakenCourses().stream().map(CompulsoryCourse::getCourseCode).toList().containsAll(course.getPrerequisites())) {
                    System.out.println("Course " + course.getCourseCode() + " can not taken because prerequisites are not satisfied.");
                } else {
                    System.out.println("Course " + course.getCourseCode() + " passed 'prerequisites' test ");
                    takenCourses.add(course);
                }


                //Log
            } else {
                System.out.println("Course " + course.getCourseCode() + "  passed 'prerequisites' test ");
                takenCourses.add(course);
            }


        }
        enrollmentRequest.setCourses(takenCourses);

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
