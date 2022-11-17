package src;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager1 {


    public Semester readSemester(String path) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            return gson.fromJson(reader, Semester.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> readStudent(String path){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type studentsType = new TypeToken<ArrayList<Student>>(){}.getType();
            return gson.fromJson(reader, studentsType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Course> readCourse(String path){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type courseType = new TypeToken<ArrayList<Course>>(){}.getType();
            return gson.fromJson(reader, courseType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Lecturer> readLecturers(String path){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type lecturerType = new TypeToken<ArrayList<Lecturer>>(){}.getType();
            return gson.fromJson(reader, lecturerType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Transcript readTranscript(String path){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            return gson.fromJson(reader, Transcript.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String,String> readParams(String path){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Path.of(path));
            Type classType = HashMap.class;
            return gson.fromJson(reader, classType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}