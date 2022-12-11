package Iteration_2.src;


public class ElectiveCourse extends CompulsoryCourse {

    private int quota;
    private Schedule schedule;
    private String electiveType;
/*
    public Iteration_1.src.ElectiveCourse(String courseCode, String courseName, int credit, ArrayList<Iteration_1.src.Course> prerequisites, Iteration_1.src.Schedule schedule, Iteration_1.src.Semester semester, Iteration_1.src.Lecturer lecturer, int quota, String electiveType) {
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
