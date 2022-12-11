package Iteration_2.src;

import Iteration_1.src.Course;

import java.util.ArrayList;

public class Semester {
    private String semesterName;
    private ArrayList<Iteration_1.src.Course> openedCourse;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }


    @Override
    public String toString() {
        return "Semester{" +
                "semesterName='" + semesterName + '\'' +
                ", openedCourse=" + openedCourse +
                '}';
    }

    public ArrayList<Iteration_1.src.Course> getOpenedCourse() {
        return openedCourse;
    }

    public void setOpenedCourse(ArrayList<Iteration_1.src.Course> openedCourse) {
        this.openedCourse = openedCourse;
    }

    public Semester() {
    }

    public Semester(String semesterName, ArrayList<Course> openedCourse) {
        this.semesterName = semesterName;
        this.openedCourse = openedCourse;
    }
}

