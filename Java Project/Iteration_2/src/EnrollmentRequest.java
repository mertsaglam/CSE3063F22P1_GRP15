package Iteration_2.src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentRequest {

    private ArrayList<CompulsoryCourse> courses;
    private Student student;
    private HashMap<String, Schedule> schedule;
    private HashMap<String, String> result;
    private int creditLimit;
    private String error;

    public EnrollmentRequest(ArrayList<CompulsoryCourse> courses, Student student) {
        this.courses = courses;
        this.student = student;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public ArrayList<CompulsoryCourse> getCourses() {
        return courses;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setCourses(ArrayList<CompulsoryCourse> courses) {
        this.courses = courses;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public HashMap<String, String> getResult() {
        return result;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setResult(HashMap<String, String> result) {
        this.result = result;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public Student getStudent() {
        return student;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setStudent(Student student) {
        this.student = student;        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public HashMap<String, Schedule> getSchedule() {
        return schedule;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setSchedule(HashMap<String, Schedule> schedule) {
        this.schedule = schedule;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void appendResult(HashMap<String, String> result1) {
        HashMap<String, String> temp = this.result;
        temp.putAll(result1);
        setResult(temp);
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public int getCreditLimit() {
        return creditLimit;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public int getTotalCredit() {
        int credit = 0;
        for (CompulsoryCourse course : this.courses) {
            credit += course.getCredit();
        }
        return credit;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public String getError() {
        return error;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public void setError(String error) {
        this.error = error;
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }


    @Override
    public String toString() {
        return "EnrollmentRequest{" +
                "courses=" + courses +
                ", student=" + student +
                ", schedule=" + schedule +
                ", result=" + result +
                ", creditLimit=" + creditLimit +
                ", error='" + error + '\'' +
                '}';
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
}
