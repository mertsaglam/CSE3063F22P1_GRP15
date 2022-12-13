package Iteration_2.src;



import java.util.ArrayList;

public class Advisor {
    //The students that are advised by the advisor
    private  String advisorName;
    //The advisor's surname
    private  String advisorSurname;

    //Constructor for advisor takes in an arraylist of students, name and surname
    public Advisor( String advisorName, String advisorSurname) {
        this.advisorName = advisorName;
        this.advisorSurname = advisorSurname;
    }

    //Constructor for advisor with no parameters
    public Advisor() {
    }
}

