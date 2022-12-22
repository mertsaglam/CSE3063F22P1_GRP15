package Iteration_2.src;



import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.ArrayList;

public class Lecturer {
    //Name property is a string
    private String lecturerName;
    //Lecturer surname is a string
    private String lecturerSurname;
    //Schedule is an object of the Schedule class
    private Schedule schedule;
    //Given courses is an arraylist of Course objects
    //Lecturer constructor takes in a name, surname and schedule and given courses arraylist
    public Lecturer(String lecturerName, String lecturerSurname, Schedule schedule) {
        this.lecturerName = lecturerName;
        this.lecturerSurname = lecturerSurname;
        this.schedule = schedule;
    }

    public Lecturer() {

    }

    //Getters and setters for the properties
    //Getter for given courses
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
        return "Lecturer{" +
                "lecturerName='" + lecturerName + '\'' +
                ", lecturerSurname='" + lecturerSurname + '\'' +
                ", schedule=" + schedule +
                '}';
    }
    public ArrayList<Advisor> lecturerToAdvisor(ArrayList<Lecturer> lecturers){
        ArrayList<Advisor> advisors = new ArrayList<>();
        for(Lecturer lecturer : lecturers){
            Advisor advisor =new Advisor(lecturer.getLecturerName(),lecturer.getLecturerSurname(),lecturer.getSchedule(),new ArrayList<String>());
            advisors.add(advisor);
        }
        return advisors;

    }
}
