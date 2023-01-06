package Iteration_1.src;

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


    @Override
    public String toString() {
        return "Iteration_1.src.Semester{" +
                "semesterName='" + semesterName + '\'' +
                ", openedCourse=" + openedCourse +
                '}';
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

