import java.util.ArrayList;
import java.util.HashMap;

public class EnrollmentRequest {
    
    private ArrayList<CompulsaryCourse> compulsaryCourses;
    private ArrayList<ElectiveCourse> electiveCourses;
    private Student student;
    private Schedule schedule;

    public EnrollmentRequest(ArrayList<CompulsaryCourse> compulsaryCourses) {
        this.compulsaryCourses = compulsaryCourses;
    }


    public EnrollmentRequest(ArrayList<CompulsaryCourse> compulsaryCourses, ArrayList<ElectiveCourse> electiveCourses, Student student, Schedule schedule) {
        this.compulsaryCourses = compulsaryCourses;
        this.electiveCourses = electiveCourses;
        this.student = student;
        this.schedule = schedule;
    }

    public ArrayList<CompulsaryCourse> getCompulsaryCourses() {
        return compulsaryCourses;
    }

    public void setCompulsaryCourses(ArrayList<CompulsaryCourse> compulsaryCourses) {
        this.compulsaryCourses = compulsaryCourses;
    }

    public ArrayList<ElectiveCourse> getElectiveCourses() {
        return electiveCourses;
    }

    public void setElectiveCourses(ArrayList<ElectiveCourse> electiveCourses) {
        this.electiveCourses = electiveCourses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


}