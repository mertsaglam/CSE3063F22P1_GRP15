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

        CourseRegistrationSimulation courseRegistrationSimulation = new CourseRegistrationSimulation();
        courseRegistrationSimulation.starSimulation();
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();


    }

}
