import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileManager {
	
	private JSONParser parser;
	
	public FileManager() {
		parser = new JSONParser();
	}
	
	public ArrayList<Student> readStudent(String path){
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			Object obj = parser.parse(new FileReader(path));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String studentID = (String) jsonObject.get("studentID");
			
			String studentName = (String) jsonObject.get("name");
			
			String studentSurname = (String) jsonObject.get("surname");
			
			Transcript transcript = (Transcript) jsonObject.get("transcript");
			
			Advisor advisor = (Advisor) jsonObject.get("advisor");
			
			String semester = (String) jsonObject.get("semester");
			
			String schedule = (String) jsonObject.get("schedule");
			
			students.add(new Student(studentID,studentName,studentSurname,transcript,semester,schedule,advisor));
			
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }	
		
		return students;
	}
	
	public ArrayList<Course> readCourse(String path){
		
		ArrayList<Course> courses = new ArrayList<Course>();
		
		try {
			Object obj = parser.parse(new FileReader(path));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String courseCode = (String) jsonObject.get("code");
			
			String courseName = (String) jsonObject.get("name");
			
			Integer credit = (Integer) jsonObject.get("credit");
			
			courses.add(new Course());
			
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		return courses;
	}

	public ArrayList<Lecturer> readLecturer(String path){
		
		ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
		
		try {
			Object obj = parser.parse(new FileReader(path));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String lecturerName = (String) jsonObject.get("name");
			
			String lecturerSurname = (String) jsonObject.get("surname");
			
			lecturers.add(new Lecturer());
			
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		return lecturers;
	}

	public ArrayList<Advisor> readAdvisor(String path){
		
		ArrayList<Advisor> advisors = new ArrayList<Advisor>();
		
		try {
			Object obj = parser.parse(new FileReader(path));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String lecturerName = (String) jsonObject.get("name");
			
			String lecturerSurname = (String) jsonObject.get("surname");
			
			advisors.add(new Advisor());
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		return advisors;
	}
	
	public void writeToFile(String path, String message) {
		
	}
}
