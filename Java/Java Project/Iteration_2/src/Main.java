package Iteration_2.src;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
       FileManager1 fileManager1 = new FileManager1();
        ArrayList<CompulsoryCourse> courses = fileManager1.readCourse("Java Project/Iteration_2/src/Jsons/compulsoryCourses.json");
       // ArrayList<Student> students = fileManager1.readStudent("Java Project/Iteration_2/src/Jsons/Students");
        //System.out.println(students);
         /* for(CompulsoryCourse course: courses){
            String randomSemester = new Random().nextBoolean() ? "fall" : "spring";
            course.setOpenedTerm(randomSemester);
        }
        JsonArray jsonArray = new Gson().toJsonTree(courses).getAsJsonArray();

        File file = new File("course.json");
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(jsonArray.toString());
        fileWriter.close();*/
        System.setProperty("log4j.configurationFile","/Users/omerfarukbulut/CSE3063F22P1_GRP15/Java Project/Iteration_2/src/Resources/log4j.tld");
        CourseRegistrationSimulation courseRegistrationSimulation = new CourseRegistrationSimulation();

        courseRegistrationSimulation.starSimulation();

//       for(Student student:students){
//           student.setTranscriptAfter(new Transcript());
//           student.setAdvisor(new Advisor());
//           student.setSchedule(new Schedule());
//            fileManager1.writeToFile(student,"Java Project/Iteration_2/src/Jsons/Students/"+student.getStudentID()+".json");
//        }
//


    }

}
