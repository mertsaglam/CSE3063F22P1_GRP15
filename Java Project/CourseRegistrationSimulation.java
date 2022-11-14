import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class CourseRegistrationSimulation {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private  ArrayList<Lecturer> lecturers;
    private ArrayList<Advisor> advisors;
    private  Semester semester;
    private int creditLimit;

    public CourseRegistrationSimulation(ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Lecturer> lecturers, ArrayList<Advisor> advisors, Semester semester, int creditLimit) {
        this.students = students;
        this.courses = courses;
        this.lecturers = lecturers;
        this.advisors = advisors;
        this.semester = semester;
        this.creditLimit = creditLimit;
    }

    public CourseRegistrationSimulation() {
    }
    public void starSimulation(){}
    public void readParameters(){
        FileManager fileManager = new FileManager();

    }
    public void createStudents(){
        FileManager fileManager = new FileManager();
        this.students = fileManager.readStudent("/Users/omerfarukbulut/Downloads/student1.json");
        System.out.println((Arrays.toString(this.students.toArray())));

    }
    public void printArraylist(ArrayList<Student> arr){
        for (int i=0; i<arr.size(); i++) {
            // Assuming arr is an ArrayList object
            Object current = arr.get(i).toString();
            System.out.println(current);
            // Do something with the current element here
        }

    }
}
