package src;
import java.util.ArrayList;

public class ElectiveCourse extends Course {

    private int quota;
    private Schedule schedule;
    private String electiveType;
/*
    public ElectiveCourse(String courseCode, String courseName, int credit, ArrayList<Course> prerequisites, Schedule schedule, Semester semester, Lecturer lecturer, int quota, String electiveType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        this.prerequisites = prerequisites;
        this.schedule = schedule;
        this.semester = semester;
        this.lecturer = lecturer;
        this.quota = quota;
        this.electiveType = electiveType;
    }*/

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getElectiveType() {
        return electiveType;
    }

    public void setElectiveType(String electiveType) {
        this.electiveType = electiveType;
    }
}
