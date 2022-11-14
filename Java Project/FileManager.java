import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileManager {

	private JSONParser parser;

	public FileManager() {
		 parser = new JSONParser();
	}

	public ArrayList<Student> readStudent(String path) {

		ArrayList<Student> students = new ArrayList<Student>();

		try {
			Object obj = parser.parse(new FileReader(path));

			 JSONObject jsonObject = (JSONObject) obj;

			String studentID = (String) jsonObject.get("studentID");

			String studentName = (String) jsonObject.get("studentName");

			String studentSurname = (String) jsonObject.get("surname");

			//Transcript transcript = (Transcript) jsonObject.get("transcript");

			//Advisor advisor = (Advisor) jsonObject.get("advisor");

			//Semester semester = (Semester) jsonObject.get("semester");

			//Schedule schedule = (Schedule) jsonObject.get("schedule");

			String enrolledYear = (String) jsonObject.get("enrolledYear");

			students.add(new Student(studentID, studentName, studentSurname,enrolledYear));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return students;
	}

	public ArrayList<Course> readCourse(String path) {

		ArrayList<Course> courses = new ArrayList<Course>();

		try {
			Object obj = parser.parse(new FileReader(path));

			JSONObject jsonObject = (JSONObject) obj;

			String courseCode = (String) jsonObject.get("code");

			String courseName = (String) jsonObject.get("name");

			Integer credit = (Integer) jsonObject.get("credit");

			courses.add(new CompulsaryCourse());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return courses;
	}

	public ArrayList<Lecturer> readLecturer(String path) throws Exception {

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
		}

		return lecturers;
	}

	public ArrayList<Advisor> readAdvisor(String path) {

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
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return advisors;
	}

	public void writeToFile(String path, String message) {

	}
}
