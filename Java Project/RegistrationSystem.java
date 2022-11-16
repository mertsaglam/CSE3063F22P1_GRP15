import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
    public void getTotalCredit(EnrollmentRequest enrollmentRequest){
        Student student = enrollmentRequest.getStudent();
        int totalCreditTaken = 0;
        ArrayList<CompulsaryCourse> compulsaryCourse = enrollmentRequest.getCompulsaryCourses();
        ArrayList<ElectiveCourse> electiveCourse = enrollmentRequest.getElectiveCourses();

        for(CompulsaryCourse course: compulsaryCourse){
            totalCreditTaken += course.credit;
        }
        for(ElectiveCourse course: electiveCourse){
            totalCreditTaken += course.credit;
        }
        if(totalCreditTaken>enrollmentRequest.getCreditLimit()){
            HashMap<String, String> result = new HashMap<String, String>();
            Random random = new Random();
            result.put(compulsaryCourse.get(random.nextInt(compulsaryCourse.toArray().length)).getCourseCode(), "creditLimitExceed");
            enrollmentRequest.appendResult(result);
        }
    }
    public void checkTimeConflict(EnrollmentRequest enrollmentRequest){

    }

}
