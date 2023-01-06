package Iteration_1.src;

import java.util.ArrayList;

public class Advisor {
    //The students that are advised by the advisor
    private final ArrayList<Student> advisedStudents;
    //The advisor's name
    private final String advisorName;
    //The advisor's surname
    private final String advisorSurname;

    //Constructor for advisor takes in an arraylist of students, name and surname
    public Advisor(ArrayList<Student> advisedStudents, String advisorName, String advisorSurname) {
        this.advisedStudents = advisedStudents;
        this.advisorName = advisorName;
        this.advisorSurname = advisorSurname;
    }

    //Constructor for advisor with no parameters
    public Advisor() {
        this.advisedStudents = new ArrayList<Student>();
        this.advisorName = "";
        this.advisorSurname = "";
    }
}

