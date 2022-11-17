package Iteration_1.src;

import java.util.ArrayList;

public class Lecturer {
    //Name property is a string
    private String lecturerName;
    //Iteration_1.src.Lecturer surname is a string
    private String lecturerSurname;
    //Iteration_1.src.Schedule is an object of the Iteration_1.src.Schedule class
    private Schedule schedule;
    //Given courses is an arraylist of Iteration_1.src.Course objects
    private ArrayList<Course> givenCourses;
    //Iteration_1.src.Lecturer constructor takes in a name, surname and schedule and given courses arraylist
    public Lecturer(String lecturerName, String lecturerSurname, Schedule schedule, ArrayList<Course> givenCourses) {
        this.lecturerName = lecturerName;
        this.lecturerSurname = lecturerSurname;
        this.schedule = schedule;
        this.givenCourses = givenCourses;
    }

    public Lecturer() {

    }

    //Getters and setters for the properties
    //Getter for given courses
    public ArrayList<Course> getGivenCourses() {
        return givenCourses;
    }
    //getter for lecturer name property
    public String getLecturerName() {
        return lecturerName;
    

    }
    //getter for lecturer surname property
    public String getLecturerSurname() {
        return lecturerSurname;
    }
    //getter for schedule property
    public Schedule getSchedule() {
        return schedule;
    }


    @Override
    public String toString() {
        return "Iteration_1.src.Lecturer{" +
                "lecturerName='" + lecturerName + '\'' +
                ", lecturerSurname='" + lecturerSurname + '\'' +
                ", schedule=" + schedule +
                ", givenCourses=" + givenCourses +
                '}';
    }
}
