import java.util.ArrayList;

public class Semester {
    private String semesterName;
    private ArrayList<Course> openedCourse;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public ArrayList<Course> getOpenedCourse() {
        return openedCourse;
    }

    public void setOpenedCourse(ArrayList<Course> openedCourse) {
        this.openedCourse = openedCourse;
    }

    public Semester() {
    }

    public Semester(String semesterName, ArrayList<Course> openedCourse) {
        this.semesterName = semesterName;
        this.openedCourse = openedCourse;
    }
}
