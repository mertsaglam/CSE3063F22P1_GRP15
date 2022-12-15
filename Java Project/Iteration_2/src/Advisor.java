package Iteration_2.src;



import java.util.ArrayList;

public class Advisor extends Lecturer {
    //The students that are advised by the advisor

    //The advisor's surname

    //Constructor for advisor takes in an arraylist of students, name and surname

    public Advisor(String lecturerName, String lecturerSurname, Schedule schedule) {
        super(lecturerName, lecturerSurname, schedule);
    }

    public Advisor() {
    }
    //Constructor for advisor with no parameters
}