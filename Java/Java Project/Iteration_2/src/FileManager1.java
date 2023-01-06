package Iteration_2.src;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager1 {



    public ArrayList<Student> readStudent(String path) {
        Logger logger = Logger.getLogger(FileManager1.class.getName());
        ArrayList<Student> students = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();
        File directoryPath = new File(path);
        File[] fileList = directoryPath.listFiles();

        for (File file :fileList) {
            try {

                Reader reader = Files.newBufferedReader(Path.of(file.getAbsolutePath()));
                Type studentsType = new TypeToken<Student>() {
                }.getType();
                students.add(gson.fromJson(reader, studentsType));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        logger.info(students.size()+ " Student objects created.");
        return students;
    }

    public ArrayList<CompulsoryCourse> readCourse(String path) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type courseType = new TypeToken<ArrayList<CompulsoryCourse>>() {
            }.getType();

            return gson.fromJson(reader, courseType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> readStudent1(String path) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type studentType = new TypeToken<ArrayList<Student>>() {
            }.getType();
            return gson.fromJson(reader, studentType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Lecturer> readLecturers(String path) {
        Logger logger = Logger.getLogger(FileManager1.class.getName());
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type lecturerType = new TypeToken<ArrayList<Lecturer>>() {
            }.getType();

            ArrayList<Lecturer> lecturers = gson.fromJson(reader, lecturerType);
            logger.info(lecturers.size()+ " lecturer is read and lecturer objects created.");
            return lecturers;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public HashMap<String, String> readParams(String path) {
        Logger logger = Logger.getLogger(FileManager1.class.getName());
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type classType = new TypeToken<HashMap<String,String>>(){}.getType();
            logger.info("Parameters are read and initialized. ");
            return gson.fromJson(reader, classType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void writeToFile(Student student, String filePath) throws IOException {
         Logger logger = Logger.getLogger(FileManager1.class.getName());
        try {
            File file = new File(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeSpecialFloatingPointValues().create();
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(gson.toJson(student).toString());
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(student.getStudentID()+".json is created. ");

    }

    public void writeToFileWithArray(ArrayList<Student> student, String filePath) throws IOException {
        try {
            File file = new File(filePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeSpecialFloatingPointValues().create();
            FileWriter fileWriter = new FileWriter(file, false);
            gson.toJson(student,fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
