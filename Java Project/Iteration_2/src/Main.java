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
       // CourseRegistrationSimulation courseRegistrationSimulation = new CourseRegistrationSimulation();
        //courseRegistrationSimulation.starSimulation();
        ArrayList<String> test = new ArrayList<>();
        test.add("8");
        test.add("9");
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("10");
        test1.add("11");
        HashMap<String,ArrayList<String>>  courseDayHour = new HashMap<>();
        courseDayHour.put("Thursday",test);
        courseDayHour.put("Thursday",test);
        courseDayHour.put("Wed",test);

        HashMap<String,ArrayList<String>>  courseDayHour1= new HashMap<>();
        courseDayHour1.put("Wed",test);
        Schedule schedule1 = new Schedule(courseDayHour);
        Schedule schedule = new Schedule(courseDayHour1);
        System.out.println(schedule);
    }

}