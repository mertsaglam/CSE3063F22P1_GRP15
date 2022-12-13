package Iteration_2.src;


public class ElectiveCourse extends Course {

    private int quota;
    private Schedule schedule;
    private String electiveType;

    public ElectiveCourse(String courseCode, String courseName, int credit, int quota, Schedule schedule, String electiveType) {
        super(courseCode, courseName, credit);
        this.quota = quota;
        this.schedule = schedule;
        this.electiveType = electiveType;
    }

    public ElectiveCourse(int quota, Schedule schedule, String electiveType) {
        this.quota = quota;
        this.schedule = schedule;
        this.electiveType = electiveType;
    }

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
