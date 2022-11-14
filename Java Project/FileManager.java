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

	public ArrayList<Student> readStudent(String path) {

		ArrayList<Student> students = new ArrayList<Student>();

		try {
			Object obj = parser.parse(new FileReader(path));

			 JSONObject jsonObject = (JSONObject) obj;

			String studentName = (String) jsonObject.get("studentName");
			String studentSurname = (String) jsonObject.get("Studentsurname");
			JSONObject rawJSON = (JSONObject) jsonObject.get("transcript");
			Transcript transcript = (Transcript) initializeTranscript(rawJSON);
			rawJSON = (JSONObject) jsonObject.get("semester");
			Semester semester = (Semester) initializeSemester(rawJSON);
			rawJSON = (JSONObject) jsonObject.get("schedule");
			Schedule schedule = (Schedule) initializeSchedule(rawJSON);
			rawJSON = (JSONObject) jsonObject.get("advisor");
			Advisor advisor = (Advisor) initializeAdvisor(rawJSON);

			//Advisor advisor = (Advisor) jsonObject.get("advisor");

			//Semester semester = (Semester) jsonObject.get("semester");

			//Schedule schedule = (Schedule) jsonObject.get("schedule");

			String enrolledYear = (String) jsonObject.get("enrolledYear");

			students.add(new Student(studentName, studentSurname, transcript, semester, schedule, advisor, enrolledYear));

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

			String courseCode = (String) jsonObject.get("courseCode");
			String courseName = (String) jsonObject.get("name");
			Integer credit = (Integer) jsonObject.get("credit");
			ArrayList<Course> prerequisites = (ArrayList<Course>) jsonObject.get("prerequisites");
			JSONObject rawJSON = (JSONObject) jsonObject.get("semester");
			Semester semester = (Semester) initializeSemester(rawJSON);
			rawJSON = (JSONObject) jsonObject.get("lecturer");
			Lecturer lecturer = (Lecturer) initializeLecturer(rawJSON);
			ArrayList<Student> courseStudents = (ArrayList<Student>) jsonObject.get("courseStudents");
			

			//Advisor advisor = (Advisor) jsonObject.get("advisor");

			//Semester semester = (Semester) jsonObject.get("semester");

			//Schedule schedule = (Schedule) jsonObject.get("schedule");

			courses.add(new Course(courseCode, courseName, credit, prerequisites, lecturer, semester, courseStudents));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return courses;
	}
	
	public ArrayList<Lecturer> readLecturer(String path) {

		ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();

		try {
			Object obj = parser.parse(new FileReader(path));

			 JSONObject jsonObject = (JSONObject) obj;

			String lecturerName = (String) jsonObject.get("name");
			String lecturerSurname = (String) jsonObject.get("surname");
			JSONObject rawJSON = (JSONObject) jsonObject.get("schedule");
			Schedule schedule = (Schedule) initializeSchedule(rawJSON);
			ArrayList<Course> givenCourses = (ArrayList<Course>) jsonObject.get("givenCourses");
			

			//Advisor advisor = (Advisor) jsonObject.get("advisor");

			//Semester semester = (Semester) jsonObject.get("semester");

			//Schedule schedule = (Schedule) jsonObject.get("schedule");

			lecturers.add(new Lecturer(lecturerName, lecturerSurname, schedule, givenCourses));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return lecturers;
	}
	
	public ArrayList<Advisor> readAdvisor(String path) {

		ArrayList<Advisor> advisors = new ArrayList<Advisor>();

		try {
			Object obj = parser.parse(new FileReader(path));

			 JSONObject jsonObject = (JSONObject) obj;

			ArrayList<Student> advisedStudents = (ArrayList<Student>) jsonObject.get("advisedStudents");
			String advisorName = (String) jsonObject.get("courseCode");
			String advisorSurname = (String) jsonObject.get("name");
			

			//Advisor advisor = (Advisor) jsonObject.get("advisor");

			//Semester semester = (Semester) jsonObject.get("semester");

			//Schedule schedule = (Schedule) jsonObject.get("schedule");

			advisors.add(new Advisor(advisedStudents, advisorName, advisorSurname));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return advisors;
	}
	
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

	public Student initializeStudent(JSONObject jsonObject){
		
		Gson gson = new Gson();
		String studentName = jsonObject.get("name").toString();
		String studentSurname = jsonObject.get("surname").toString();
		Transcript transcript = jsonToClassTranscript(jsonObject.get("transcript").toString());
		Semester semester = jsonToClassSemester(jsonObject.get("semester").toString());
		Schedule schedule = jsonToClassSchedule(jsonObject.get("schedule").toString());
		Advisor advisor = jsonToClassAdvisor(jsonObject.get("advisor").toString());
		String enrolledYear = jsonObject.get("enrolledyear").toString();

		return new Student(studentName,studentSurname,transcript,semester,schedule,advisor, enrolledYear));

	}
	
	public Semester initializeSemester(JSONObject jsonObject){
		
		Gson gson = new Gson();
		String semesterName = jsonObject.get("name").toString();
		Type courseListType = new TypeToken<ArrayList<Course>>(){}.getType();
		ArrayList<Course> openedCourse = gson.fromJson(jsonObject.get("openedCourse").toString(),courseListType);

		return new Semester(semesterName, openedCourse));

	}
	
	public Schedule initializeSchedule(JSONObject jsonObject){
		
		Gson gson = new Gson();
		HashMap courseDayHour = jsonToMap(jsonObject.get("courseDayHour").toString());

		return new Schedule(courseDayHour));

	}
	
	public Lecturer initializeLecturer(JSONObject jsonObject){
		
		Gson gson = new Gson();
		Type courseListType = new TypeToken<ArrayList<Student>>(){}.getType();
		String lecturerName = jsonObject.get("name").toString();
		String lecturerSurname = jsonObject.get("surname").toString();
		Schedule schedule = jsonToClassSchedule(jsonObject.get("schedule").toString());
		ArrayList<Student> givenCourses = gson.fromJson(jsonObject.get("givenCourses").toString(),courseListType);

		return new Lecturer(lecturerName, lecturerSurname, schedule, givenCourses));

	}
	
	public Advisor initializeAdvisor(JSONObject jsonObject){
		
		Gson gson = new Gson();
		Type courseListType = new TypeToken<ArrayList<Student>>(){}.getType();
		ArrayList<Student> advisedStudents = gson.fromJson(jsonObject.get("advisedStudents").toString(),courseListType);
		String advisorName = jsonObject.get("name").toString();
		String advisorSurname = jsonObject.get("surname").toString();

		return new Advisor(advisedStudents, advisorName, advisorSurname));

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

	public void writeToFile(String path, String message) {

	}
}
