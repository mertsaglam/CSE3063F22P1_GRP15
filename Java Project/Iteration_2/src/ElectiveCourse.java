package Iteration_2.src;


public class ElectiveCourse {

    private int quota;
    private Schedule schedule;
    private String electiveType;

    public ElectiveCourse(String courseCode, String courseName, int credit, int quota, Schedule schedule, String electiveType) {
        this.quota = quota;
        this.schedule = schedule;
        this.electiveType = electiveType;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public ElectiveCourse(int quota, Schedule schedule, String electiveType) {
        this.quota = quota;
        this.schedule = schedule;
        this.electiveType = electiveType;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public int getQuota() {
        return quota;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setQuota(int quota) {
        this.quota = quota;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Schedule getSchedule() {
        return schedule;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public String getElectiveType() {
        return electiveType;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setElectiveType(String electiveType) {
        this.electiveType = electiveType;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
}
