package Iteration_2.src;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type lecturerType = new TypeToken<ArrayList<Lecturer>>() {
            }.getType();
            return gson.fromJson(reader, lecturerType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public HashMap<String, String> readParams(String path) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type classType = new TypeToken<HashMap<String,String>>(){}.getType();
            return gson.fromJson(reader, classType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(Student student, String filePath) throws IOException {
        File file = new File(filePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeSpecialFloatingPointValues().create();
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(gson.toJson(student).toString());
        fileWriter.close();
    }

    public void writeToFileWithArray(ArrayList<Student> student, String filePath) throws IOException {
        File file = new File(filePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeSpecialFloatingPointValues().create();
        FileWriter fileWriter = new FileWriter(file, false);
        gson.toJson(student,fileWriter);
        fileWriter.close();
    }

}
