import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class RegistrationSystem {
    public void checkCourseIsTakenBefore(EnrollmentRequest enrollmentRequest) {
        Student student = enrollmentRequest.getStudent();
        ArrayList<CompulsaryCourse> compulsaryCourse = enrollmentRequest.getCompulsaryCourses();
        ArrayList<ElectiveCourse> electiveCourse = enrollmentRequest.getElectiveCourses();
        for (CompulsaryCourse course : compulsaryCourse) {
            if (student.getTranscript().getTakenCourses().contains(course)) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put(course.getCourseCode(), "takenBefore");
                enrollmentRequest.appendResult(result);
            }

        }
        for (ElectiveCourse course : electiveCourse) {
            if (student.getTranscript().getTakenCourses().contains(course)) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put(course.getCourseCode(), "takenBefore");
                enrollmentRequest.appendResult(result);
            }

        }

    }

    public void checkPrerequisites(EnrollmentRequest enrollmentRequest) {
        ArrayList<CompulsaryCourse> compulsaryCourses = enrollmentRequest.getCompulsaryCourses();
        Student student = enrollmentRequest.getStudent();
        ArrayList<ElectiveCourse> electiveCourses = enrollmentRequest.getElectiveCourses();

        for (CompulsaryCourse course : compulsaryCourses) {
            if (!student.getTranscript().getTakenCourses().contains(course)) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put(course.getCourseCode(), "notSatisfiedPreRequisite");
                enrollmentRequest.appendResult(result);
            }

        }
        for (ElectiveCourse course : electiveCourses) {
            if (!student.getTranscript().getTakenCourses().contains(course)) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put(course.getCourseCode(), "notSatisfiedPreRequisite");
                enrollmentRequest.appendResult(result);
            }
        }
    }
}
