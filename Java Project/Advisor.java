import java.util.ArrayList;

public class Advisor {
//The students that are advised by the advisor
private ArrayList<Student> advisedStudents;
//The advisor's name
private String advisorName;
//The advisor's surname
private String advisorSurname;
//Constructor for advisor takes in an arraylist of students, name and surname
    public Advisor(ArrayList<Student> advisedStudents, String advisorName, String advisorSurname) {
        this.advisedStudents = advisedStudents;
        this.advisorName = advisorName;
        this.advisorSurname = advisorSurname;
    }
<<<<<<< HEAD
    //Constructor for advisor with no parameters   
    public Advisor() {
        this.advisedStudents = new ArrayList<Student>();
        this.advisorName = "";
        this.advisorSurname = "";
=======

    public Advisor() {

>>>>>>> e80bb1efd5d131b09a5e8df92b54a32d70b69357
    }
}

