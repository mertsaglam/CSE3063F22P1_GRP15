import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentRequest {

    private ArrayList<CompulsaryCourse> compulsaryCourses;
    private ArrayList<ElectiveCourse> electiveCourses;
    private Student student;
    private HashMap<String, Schedule> schedule;
    private HashMap<String, String> result;
    private int creditLimit;

    public EnrollmentRequest(ArrayList<CompulsaryCourse> compulsaryCourses) {
        this.compulsaryCourses = compulsaryCourses;
    }


    public EnrollmentRequest(ArrayList<CompulsaryCourse> compulsaryCourses, ArrayList<ElectiveCourse> electiveCourses, Student student, HashMap<String, Schedule> schedule) {
        this.compulsaryCourses = compulsaryCourses;
        this.electiveCourses = electiveCourses;
        this.student = student;
        this.schedule = schedule;
    }

    public HashMap<String, String> getResult() {
        return result;
    }

    public void setResult(HashMap<String, String> result) {
        this.result = result;
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
}
