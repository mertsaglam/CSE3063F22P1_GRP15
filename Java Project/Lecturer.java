import java.util.ArrayList;

public class Lecturer {
    //Name property is a string
    private String lecturerName;
    //Lecturer surname is a string
    private String lecturerSurname;
    //Schedule is an object of the Schedule class
    private Schedule schedule;
    //Given courses is an arraylist of Course objects
    private ArrayList<Course> givenCourses;
    //Lecturer constructor takes in a name, surname and schedule and given courses arraylist
    public Lecturer(String lecturerName, String lecturerSurname, Schedule schedule, ArrayList<Course> givenCourses) {
        this.lecturerName = lecturerName;
        this.lecturerSurname = lecturerSurname;
        this.schedule = schedule;
        this.givenCourses = givenCourses;
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



        
    


}
