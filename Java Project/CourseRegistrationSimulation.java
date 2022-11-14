import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.concurrent.ThreadLocalRandom;

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
        // not finalized
    }
    public void createStudents(){
        FileManager fileManager = new FileManager();
        this.students = fileManager.readStudent("/Users/omerfarukbulut/Downloads/student1.json");
        System.out.println((Arrays.toString(this.students.toArray())));

    }
    public void createCourses(){
        FileManager fileManager = new FileManager();
        this.courses = fileManager.readCourse("/Users/omerfarukbulut/Downloads/student1.json");
    }
    public void createSemester(){
        FileManager fileManager = new FileManager();
        // not finalized

    }
    public void createLecturer(){
        FileManager fileManager = new FileManager();
        try {
            this.lecturers = fileManager.readLecturer("/Users/omerfarukbulut/Downloads/student1.json");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    public void createAdvisor(){
        FileManager fileManager = new FileManager();
        this.advisors = fileManager.readAdvisor("/Users/omerfarukbulut/Downloads/student1.json");
    }

    public void matchStudentAdvisor(){
        for (Student student: this.students){
            student.setAdvisor(this.advisors.get(ThreadLocalRandom.current().nextInt(0,this.advisors.size()+1)));
        }
    }

    public void createEnrollementRequest(){

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
