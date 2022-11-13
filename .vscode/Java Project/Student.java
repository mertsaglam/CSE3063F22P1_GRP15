public class Student {

    private String studentID;
    private String studentName;
    private Transcript transcript;
    private Semester semester;
    private Schedule schedule;
    private Advisor advisor;

    public Student() {
        studentID = "";
        studentName = "";
        transcript = new Transcript();
        semester = new Semester();
        schedule = new Schedule();
        advisor = new Advisor();
    }

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        transcript = new Transcript();
        semester = new Semester();
        schedule = new Schedule();
        advisor = new Advisor();
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void createStudentID(Schedule schedule) {

    }
}
