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
        /* for(CompulsoryCourse course: courses){
            String randomSemester = new Random().nextBoolean() ? "fall" : "spring";
            course.setOpenedTerm(randomSemester);
        }
        JsonArray jsonArray = new Gson().toJsonTree(courses).getAsJsonArray();

        File file = new File("course.json");
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(jsonArray.toString());
        fileWriter.close();*/
        CourseRegistrationSimulation courseRegistrationSimulation = new CourseRegistrationSimulation();
        courseRegistrationSimulation.starSimulation();


    }

}
