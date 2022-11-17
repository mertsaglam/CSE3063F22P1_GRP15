package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentRequest {

    private ArrayList<Course> courses;
    private Student student;
    private HashMap<String, Schedule> schedule;
    private HashMap<String, String> result;
    private int creditLimit;

    public EnrollmentRequest(ArrayList<Course> courses, Student student, HashMap<String, Schedule> schedule) {
        this.courses = courses;
        this.student = student;
        this.schedule = schedule;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
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

    public void appendResult(HashMap<String, String> result) {
        this.result.putAll(result);
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getTotalCredit() {
        int credit = 0;
        for (Course course : this.courses) {
            credit += course.getCredit();
        }
        return credit;
    }

    /* public void checkDuplicate(HashMap hashMap){
         Map<ArrayList<Schedule>, ArrayList<Object>> reverseMap = new HashMap<>();


         for (Object schedules: hashMap.values()) {
             if (!reverseMap.containsKey(entry.getValue())) {
                 reverseMap.put(entry.getValue(), new ArrayList<>());
             }
             ArrayList<Object> keys = reverseMap.get(entry.getValue());
             keys.add(entry.getKey());
             reverseMap.put(entry.getValue(), keys);
         }


     }*/
    public HashMap<String, String> checkDuplicate(HashMap<String, Schedule> hashMap) {
        HashMap<String, String> duplicate = new HashMap<>();
        for (Map.Entry<String, Schedule> entry : hashMap.entrySet()) {
            for (Map.Entry<String, Schedule> entry2 : hashMap.entrySet()) {
                if (entry.getValue().equals(entry2.getValue()) && !entry.getKey().equals(entry2.getKey())) {
                    duplicate.put(entry.getKey(), entry2.getKey());
                }
            }
        }
        return duplicate;
    }
}
