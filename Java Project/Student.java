
public class Student {

    private String studentID;
    private String studentName;
    private String studentSurname;
    private Transcript transcriptBefore;
    private Transcript transcriptAfter;
    private Semester semester;
    private Schedule schedule;
    private Advisor advisor;
    private String enrolledYear;

    public Student( String studentName, String studentSurname, Transcript transcriptBefore,Transcript transcriptAfter,
                   Semester semester, Schedule schedule, Advisor advisor, String enrolledYear) {
        this.studentID = createStudentID();

        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.transcriptBefore = transcriptBefore;
        this.transcriptAfter = transcriptAfter;
        this.semester = semester;
        this.schedule = schedule;
        this.advisor = advisor;
        this.enrolledYear = enrolledYear;
    }
    public Student( String studentName, String studentSurname, Transcript transcriptBefore,
                    Semester semester, Schedule schedule, Advisor advisor, String enrolledYear) {
        this.studentID = createStudentID();

        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.transcriptBefore = transcriptBefore;
        this.semester = semester;
        this.schedule = schedule;
        this.advisor = advisor;
        this.enrolledYear = enrolledYear;
    }

    public Student(String studentID, String studentName, String studentSurname, String enrolledYear) {
        this.studentID = createStudentID();
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.enrolledYear = enrolledYear;

    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentSurname() {
        return this.studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Transcript getTranscriptBefore() {
        return transcriptBefore;
    }

    public void setTranscriptBefore(Transcript transcriptBefore) {
        this.transcriptBefore = transcriptBefore;
    }

    public Transcript getTranscriptAfter() {
        return transcriptAfter;
    }

    public void setTranscriptAfter(Transcript transcriptAfter) {
        this.transcriptAfter = transcriptAfter;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Advisor getAdvisor() {
        return this.advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public String getEnrolledYear() {
        return this.enrolledYear;
    }

    public void setEnrolledYear(String enrolledYear) {
        this.enrolledYear = enrolledYear;
    }

    public Student() {
    }

    public String createStudentID() {
        String department = "1501";
        String studentID = department + this.enrolledYear + Double.toString(Math.random() * 1000);
        return studentID;

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", transcriptBefore=" + transcriptBefore +
                ", transcriptAfter=" + transcriptAfter +
                ", semester=" + semester +
                ", schedule=" + schedule +
                ", advisor=" + advisor +
                ", enrolledYear='" + enrolledYear + '\'' +
                '}';
    }

}
