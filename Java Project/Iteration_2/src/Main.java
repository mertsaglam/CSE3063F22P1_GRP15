package Iteration_2.src;



import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileManager1 fileManager1 = new FileManager1();
        ArrayList<Lecturer> lecturers = fileManager1.readLecturers("Java Project/Iteration_2/src/Jsons/lecturer.json");
        ArrayList<CompulsoryCourse> courses = fileManager1.readCourse("Java Project/Iteration_2/src/Jsons/compulsoryCourses.json");
        for (CompulsoryCourse course: courses)
            System.out.println(course.getCourseSection());
    }
}