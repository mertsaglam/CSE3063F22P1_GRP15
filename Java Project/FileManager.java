import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileManager {

	private JSONParser parser;

	public FileManager() {
		 parser = new JSONParser();
	}

	/*public ArrayList<Student> readStudent(String path) {

		ArrayList<Student> students = new ArrayList<Student>();

		try {
			Object obj = parser.parse(new FileReader(path));

			 JSONObject jsonObject = (JSONObject) obj;

			String studentID = (String) jsonObject.get("studentID");

			String studentName = (String) jsonObject.get("studentName");

			String studentSurname = (String) jsonObject.get("Studentsurname");
			JSONObject rawJSON = (JSONObject) jsonObject.get("transcript");
			Transcript transcript = (Transcript) initializeTranscript(rawJSON);

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
	}*/
	public HashMap jsonToMap(String json) {
		HashMap map = new Gson().fromJson(json, HashMap.class);
		return map;
	}
	public Student jsonToClassStudent(String json) {
		return new Gson().fromJson(json, Student.class);
	}
	public Course jsonToClassCourse(String json) {
		return new Gson().fromJson(json, Course.class);
	}
	public Transcript jsonToClassTranscript(String json) {
		return new Gson().fromJson(json, Transcript.class);
	}
	public Semester jsonToClassSemester(String json) {
		return new Gson().fromJson(json, Semester.class);
	}
	public Schedule jsonToClassSchedule(String json) {
		return new Gson().fromJson(json, Schedule.class);
	}
	public Lecturer jsonToClassLecturer(String json) {
		return new Gson().fromJson(json, Lecturer.class);
	}
	public Advisor jsonToClassAdvisor(String json) {
		return new Gson().fromJson(json, Advisor.class);
	}

	public ArrayList<Student> readStudent(JSONObject jsonObject){
		Gson gson = new Gson();
		String studentName = jsonObject.get("name").toString();
		String studentSurname = jsonObject.get("surname").toString();
		Transcript transcript = jsonToClassTranscript(jsonObject.get("transcript").toString());
		Semester semester = jsonToClassSemester(jsonObject.get("semester").toString());
		Schedule schedule = jsonToClassSchedule(jsonObject.get("schedule").toString());
		Advisor advisor = jsonToClassAdvisor(jsonObject.get("advisor").toString());
		String enrolledYear = jsonObject.get("enrolledyear").toString();

		return new Transcript(courseGrade,student,GPA,takenCredit,takenCourses,notTakenCourses);

	}

	public Transcript initializeTranscript(JSONObject jsonObject){
		Gson gson = new Gson();
		HashMap courseGrade = jsonToMap(jsonObject.get("courseGrade").toString());
		Student student = jsonToClassStudent(jsonObject.get("student").toString());
		Float GPA = Float.parseFloat(jsonObject.get("GPA").toString());
		Integer takenCredit = Integer.parseInt(jsonObject.get("takenCredit").toString());
		Type courseListType = new TypeToken<ArrayList<Course>>(){}.getType();
		ArrayList<Course> takenCourses = gson.fromJson(jsonObject.get("takenCourses").toString(),courseListType);
		ArrayList<Course> notTakenCourses = gson.fromJson(jsonObject.get("notTakenCourses").toString(),courseListType);

		return new Transcript(courseGrade,student,GPA,takenCredit,takenCourses,notTakenCourses);


	}

	public ArrayList<Course> readCourse(String path) {

		ArrayList<Course> courses = new ArrayList<Course>();

		Gson gson = new Gson();
		String courseCode = jsonObject.get("coursecode").toString();
		String courseName = jsonObject.get("coursename").toString();
		Integer credit = jsonToClassTranscript(jsonObject.get("credit").toString());
		Type courseListType1 = new TypeToken<ArrayList<Course>>(){}.getType();
		ArrayList<Course> prerequisites = gson.fromJson(jsonObject.get("prerequisites").toString(),courseListType1);
		Semester semester = jsonToClassSemester(jsonObject.get("semester").toString());
		Lecturer lecturer = jsonToClassLecturer(jsonObject.get("lecturer").toString());
		Type courseListType2 = new TypeToken<ArrayList<Student>>(){}.getType();
		ArrayList<Course> courseStudents = gson.fromJson(jsonObject.get("courseStudents").toString(),courseListType2);

		return courses.add(new Course(courseCode, courseName, credit, prerequisites, semester, lecturer, courseStudents));
	}

	public ArrayList<Lecturer> readLecturer(String path) throws Exception {

		ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();

		String lecturerName = jsonObject.get("name").toString();
		String lecturerSurname = jsonObject.get("surname").toString();
		Schedule schedule = jsonToClassSchedule(jsonObject.get("schedule").toString());
		Type courseListType = new TypeToken<ArrayList<Course>>(){}.getType();
		ArrayList<Course> givenCourses = gson.fromJson(jsonObject.get("givenCourses").toString(),courseListType);

		return lecturers.add(new Lecturer(lecturerName, lecturerSurname, schedule, givenCourses))
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
