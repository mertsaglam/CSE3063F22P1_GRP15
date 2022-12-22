package Iteration_2.src;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class RegistrationSystem {
    static org.apache.log4j.Logger logger = Logger.getLogger(RegistrationSystem.class.getName());

    public void checkCourseIsTakenBefore(EnrollmentRequest enrollmentRequest) {

        Student student = enrollmentRequest.getStudent();
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        ArrayList<CompulsoryCourse> takenCourses = new ArrayList<CompulsoryCourse>();
        logger.info("System Checking " + student.getStudentID() + "'s enrollment requests");

        for (CompulsoryCourse course : courses) {
            if (student.getTranscriptBefore().getTakenCourses().stream().map(CompulsoryCourse::getCourseCode).toList().contains(course.getCourseCode())) {
                System.out.println("Course " + course.getCourseCode() + " can not be taken because it has already been taken.");
                logger.warn("Course " + course.getCourseCode() + " failed 'taken before test'. ");
                //Log
            } else {
                logger.info("Course " + course.getCourseCode() + " passed 'taken before test'. ");
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
                    logger.info("Course " + course.getCourseCode() + " failed 'prerequisites ' test");
                } else {
                    logger.info("Course " + course.getCourseCode() + " passed 'prerequisites' test ");
                    takenCourses.add(course);
                }


                //Log
            } else {
                System.out.println("Course " + course.getCourseCode() + "  passed 'prerequisites' test ");
                logger.info("Course " + course.getCourseCode() + " passed 'prerequisites' test ");
                takenCourses.add(course);
            }


        }
        enrollmentRequest.setCourses(takenCourses);

    }

    public void isOpenedThisTerm(EnrollmentRequest enrollmentRequest, String term) {
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        Student student = enrollmentRequest.getStudent();
        ArrayList<CompulsoryCourse> takenCourses = new ArrayList<CompulsoryCourse>();
        for (CompulsoryCourse course : courses) {
            if (Objects.equals(course.getOpenedTerm(), term)) {
                takenCourses.add(course);
                logger.info("Course " + course.getCourseCode() + " passed 'opened this term ' test");
            } else {
                System.out.println("Course " + course.getCourseCode() + " can not been taken because it does not opened this term");
                logger.info("Course " + course.getCourseCode() + " failed 'opened this term ' test");
            }
        }
        enrollmentRequest.setCourses(takenCourses);

    }


}
