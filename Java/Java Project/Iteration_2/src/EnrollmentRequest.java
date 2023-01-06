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
    }

    public ArrayList<CompulsoryCourse> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<CompulsoryCourse> courses) {
        this.courses = courses;
    }

    public HashMap<String, String> getResult() {
        return result;
    }

    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HashMap<String, Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<String, Schedule> schedule) {
        this.schedule = schedule;
    }

    public void appendResult(HashMap<String, String> result1) {
        HashMap<String, String> temp = this.result;
        temp.putAll(result1);
        setResult(temp);
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getTotalCredit() {
        int credit = 0;
        for (CompulsoryCourse course : this.courses) {
            credit += course.getCredit();
        }
        return credit;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
    }
}
