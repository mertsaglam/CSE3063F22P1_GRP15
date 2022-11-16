import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileManager {

	private JSONParser parser;

	public FileManager() {
		 parser = new JSONParser();
	}

	public ArrayList<Student> readStudent(String path) {

		ArrayList<Student> students = new ArrayList<Student>();
		
		try {//https://stackoverflow.com/questions/10926353/how-to-read-json-file-into-java-with-simple-json-library
			JSONArray obj = (JSONArray) parser.parse(new FileReader(path));
			
			for(Object o : obj) {
				JSONObject jsonObject = (JSONObject) o;

				String studentName = (String) jsonObject.get("studentName");
				System.out.println(studentName);
				
				String studentSurname = (String) jsonObject.get("studentSurname");
				System.out.println(studentSurname);
				
				String enrolledYear = (String) jsonObject.get("enrolledYear");
				System.out.println(enrolledYear);
				
				JSONObject jsonObject1 = (JSONObject) jsonObject.get("transcriptBefore");
				
				JSONArray obj2 =  (JSONArray) jsonObject1.get("coursesGrades");
				int clock = 0;
				String course = "";
				HashMap<String, Float> grade = new HashMap<String, Float>();
				for(Object coursesGrades : obj2) {
					if(clock == 0) {
						course = (String) coursesGrades;
						clock++;
					}else {
						grade.put(course, Float.parseFloat((String) coursesGrades));
						clock--;
					}
					System.out.println(coursesGrades);
				}
				String GPA = (String) jsonObject1.get("GPA");
				Long takenCredit = (Long) jsonObject1.get("takenCredit");
				System.out.println(GPA);
				System.out.println(takenCredit);
				
				JSONArray obj3 =  (JSONArray) jsonObject1.get("takenCourses");
				for(Object takenCourses : obj3) {
					JSONObject jsonObject2 = (JSONObject) takenCourses;
					
					String courseCode = (String) jsonObject2.get("courseCode");
					System.out.println(courseCode);
					
					String courseName = (String) jsonObject2.get("courseName");
					System.out.println(courseName);
					
					Long courseCredit = (Long) jsonObject2.get("courseCredit");
					System.out.println(courseCredit);
					
					JSONArray obj4 =  (JSONArray) jsonObject2.get("prerequisites");
					for(Object prerequisites : obj4) {
						System.out.println(prerequisites);
					}
					
					System.out.println("//students\\");
					
					JSONObject jsonObject4 = (JSONObject) jsonObject2.get("lecturer");
					
					String lecturerName = (String) jsonObject4.get("lecturerName");
					System.out.println(lecturerName);
					
					String lecturerSurname = (String) jsonObject4.get("lecturerSurname");
					System.out.println(lecturerSurname);
					
					JSONObject jsonObject5 = (JSONObject) jsonObject4.get("schedule");
					JSONObject jsonObject6 = (JSONObject) jsonObject5.get("courseDayHour");
					
					HashMap<String, ArrayList<String>> courseDayHour = new HashMap<String, ArrayList<String>>();
					JSONArray obj7 =  (JSONArray) jsonObject6.get("Monday");
					if(obj7 != null) {
						ArrayList<String> hour = new ArrayList<String>();
						System.out.println("Monday");
						for(Object Monday : obj7) {
							hour.add(String.valueOf(Monday));
							System.out.println(Monday);
						}
						courseDayHour.put("Monday", hour);
					}
					
					JSONArray obj8 =  (JSONArray) jsonObject6.get("Tuesday");
					if(obj8 != null) {
						ArrayList<String> hour = new ArrayList<String>();
						System.out.println("Tuesday");
						for(Object Tuesday : obj8) {
							hour.add(String.valueOf(Tuesday));
							System.out.println(Tuesday);
						}
						courseDayHour.put("Tuesday", hour);
					}
					
					JSONArray obj9 =  (JSONArray) jsonObject6.get("Wednesday");
					if(obj9 != null) {
						ArrayList<String> hour = new ArrayList<String>();
						System.out.println("Wednesday");
						for(Object Wednesday : obj9) {
							hour.add(String.valueOf(Wednesday));
							System.out.println(Wednesday);
						}
						courseDayHour.put("Wednesday", hour);
					}
					
					JSONArray obj10 =  (JSONArray) jsonObject6.get("Thursday");
					if(obj10 != null) {
						ArrayList<String> hour = new ArrayList<String>();
						System.out.println("Thursday");
						for(Object Thursday : obj10) {
							hour.add(String.valueOf(Thursday));
							System.out.println(Thursday);
						}
						courseDayHour.put("Thursday", hour);
					}
					
					JSONArray obj11 =  (JSONArray) jsonObject6.get("Friday");
					if(obj11 != null) {
						ArrayList<String> hour = new ArrayList<String>();
						System.out.println("Friday");
						for(Object Friday : obj11) {
							hour.add(String.valueOf(Friday));
							System.out.println(Friday);
						}
						courseDayHour.put("Friday", hour);
					}
					
					//Schedule schedule = new Schedule(courseDayHour);
					
				}
				
				JSONArray obj12 =  (JSONArray) jsonObject1.get("notTakenCourses");
				for(Object notTakenCourses : obj12) {
					JSONObject jsonObject2 = (JSONObject) notTakenCourses;
					
					String courseCode = (String) jsonObject2.get("courseCode");
					System.out.println(courseCode);
					
					String courseName = (String) jsonObject2.get("courseName");
					System.out.println(courseName);
					
					Long courseCredit = (Long) jsonObject2.get("courseCredit");
					System.out.println(courseCredit);
					
					JSONArray obj4 =  (JSONArray) jsonObject2.get("prerequisites");
					for(Object prerequisites : obj4) {
						System.out.println(prerequisites);
					}
					
					JSONObject jsonObject3 = (JSONObject) jsonObject.get("semester");
					
					String semesterName = (String) jsonObject3.get("semesterName");
					System.out.println(semesterName);
					
					JSONArray obj5 =  (JSONArray) jsonObject3.get("openedCourses");
					for(Object openedCourses : obj5) {
						System.out.println("*******************");
						JSONObject jsonObject4 = (JSONObject) openedCourses;
						
						String courseCode2 = (String) jsonObject4.get("courseCode");
						System.out.println(courseCode2);
						
						String courseName2 = (String) jsonObject4.get("courseName");
						System.out.println(courseName2);
						
						/*Long courseCredit2 = (Long) jsonObject4.get("courseCredit");
						System.out.println(courseCredit2);*/
						
						JSONArray obj6 =  (JSONArray) jsonObject4.get("prerequisites");
						for(Object prerequisites : obj6) {
							System.out.println(prerequisites);
						}
						
					}
					
					System.out.println("//students\\");
					
					
					JSONObject jsonObject4 = (JSONObject) jsonObject2.get("lecturer");
					
					String lecturerName = (String) jsonObject4.get("lecturerName");
					System.out.println(lecturerName);
					
					String lecturerSurname = (String) jsonObject4.get("lecturerSurname");
					System.out.println(lecturerSurname);
					
					JSONObject jsonObject5 = (JSONObject) jsonObject4.get("schedule");
					JSONObject jsonObject6 = (JSONObject) jsonObject5.get("courseDayHour");
					
					JSONArray obj7 =  (JSONArray) jsonObject6.get("Monday");
					if(obj7 != null) {
						System.out.println("Monday");
						for(Object Monday : obj7) {
							System.out.println(Monday);
						}
					}
					
					JSONArray obj8 =  (JSONArray) jsonObject6.get("Tuesday");
					if(obj8 != null) {
						System.out.println("Tuesday");
						for(Object Tuesday : obj8) {
							System.out.println(Tuesday);
						}
					}
					
					JSONArray obj9 =  (JSONArray) jsonObject6.get("Wednesday");
					if(obj9 != null) {
						System.out.println("Wednesday");
						for(Object Wednesday : obj9) {
							System.out.println(Wednesday);
						}
					}
					
					JSONArray obj10 =  (JSONArray) jsonObject6.get("Thursday");
					if(obj10 != null) {
						System.out.println("Thursday");
						for(Object Thursday : obj10) {
							System.out.println(Thursday);
						}
					}
					
					JSONArray obj11 =  (JSONArray) jsonObject6.get("Friday");
					if(obj11 != null) {
						System.out.println("Friday");
						for(Object Friday : obj11) {
							System.out.println(Friday);
						}
					}
					
					
					
				}
				//Transcript transcriptBefore = new Transcript(grade, (Float) GPA, (Integer) takenCredit, );
				
				System.out.println("//students\\");

				//Advisor advisor = (Advisor) jsonObject.get("advisor");

				//Semester semester = (Semester) jsonObject.get("semester");

				//Schedule schedule = (Schedule) jsonObject.get("schedule");

				
				System.out.println("-----------------");
				
				//students.add(new Student(studentName, studentSurname, ))
			}
			 
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

		try {//https://stackoverflow.com/questions/10926353/how-to-read-json-file-into-java-with-simple-json-library
			JSONArray obj = (JSONArray) parser.parse(new FileReader(path));
			
			for(Object takenCourses : obj) {
				JSONObject jsonObject2 = (JSONObject) takenCourses;
				
				String courseCode = (String) jsonObject2.get("courseCode");
				System.out.println(courseCode);
				
				String courseName = (String) jsonObject2.get("courseName");
				System.out.println(courseName);
				
				Long courseCredit = (Long) jsonObject2.get("courseCredit");
				System.out.println(courseCredit);
				
				JSONArray obj4 =  (JSONArray) jsonObject2.get("prerequisites");
				for(Object prerequisites : obj4) {
					System.out.println(prerequisites);
				}
				
				/*JSONObject jsonObject3 = (JSONObject) jsonObject2.get("semester");
				
				String semesterName = (String) jsonObject3.get("semesterName");
				System.out.println(semesterName);
				
				JSONArray obj5 =  (JSONArray) jsonObject3.get("openedCourses");
				for(Object openedCourses : obj5) {
					System.out.println("*******************");
					JSONObject jsonObject4 = (JSONObject) openedCourses;
					
					String courseCode2 = (String) jsonObject4.get("courseCode");
					System.out.println(courseCode2);
					
					String courseName2 = (String) jsonObject4.get("courseName");
					System.out.println(courseName2);
					
					/*Long courseCredit2 = (Long) jsonObject4.get("courseCredit");
					System.out.println(courseCredit2);
					
					JSONArray obj6 =  (JSONArray) jsonObject4.get("prerequisites");
					for(Object prerequisites : obj6) {
						System.out.println(prerequisites);
					}
					
				}*/
				 
				System.out.println("//students\\");
				
				JSONObject jsonObject4 = (JSONObject) jsonObject2.get("lecturer");
				
				String lecturerName = (String) jsonObject4.get("lecturerName");
				System.out.println(lecturerName);
				
				String lecturerSurname = (String) jsonObject4.get("lecturerSurname");
				System.out.println(lecturerSurname);
				
				JSONObject jsonObject5 = (JSONObject) jsonObject4.get("schedule");
				JSONObject jsonObject6 = (JSONObject) jsonObject5.get("courseDayHour");
				
				JSONArray obj7 =  (JSONArray) jsonObject6.get("Monday");
				if(obj7 != null) {
					System.out.println("Monday");
					for(Object Monday : obj7) {
						System.out.println(Monday);
					}
				}
				
				JSONArray obj8 =  (JSONArray) jsonObject6.get("Tuesday");
				if(obj8 != null) {
					System.out.println("Tuesday");
					for(Object Tuesday : obj8) {
						System.out.println(Tuesday);
					}
				}
				
				JSONArray obj9 =  (JSONArray) jsonObject6.get("Wednesday");
				if(obj9 != null) {
					System.out.println("Wednesday");
					for(Object Wednesday : obj9) {
						System.out.println(Wednesday);
					}
				}
				
				JSONArray obj10 =  (JSONArray) jsonObject6.get("Thursday");
				if(obj10 != null) {
					System.out.println("Thursday");
					for(Object Thursday : obj10) {
						System.out.println(Thursday);
					}
				}
				
				JSONArray obj11 =  (JSONArray) jsonObject6.get("Friday");
				if(obj11 != null) {
					System.out.println("Friday");
					for(Object Friday : obj11) {
						System.out.println(Friday);
					}
				}
				
			}
			 
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

		try {//https://stackoverflow.com/questions/10926353/how-to-read-json-file-into-java-with-simple-json-library
			JSONArray obj = (JSONArray) parser.parse(new FileReader(path));
			
			for(Object o : obj) {
				JSONObject jsonObject4 = (JSONObject) o;
				
				String lecturerName = (String) jsonObject4.get("lecturerName");
				System.out.println(lecturerName);
				
				String lecturerSurname = (String) jsonObject4.get("lecturerSurname");
				System.out.println(lecturerSurname);
				
				JSONObject jsonObject5 = (JSONObject) jsonObject4.get("schedule");
				JSONObject jsonObject6 = (JSONObject) jsonObject5.get("courseDayHour");
				
				JSONArray obj7 =  (JSONArray) jsonObject6.get("Monday");
				if(obj7 != null) {
					System.out.println("Monday");
					for(Object Monday : obj7) {
						System.out.println(Monday);
					}
				}
				
				JSONArray obj8 =  (JSONArray) jsonObject6.get("Tuesday");
				if(obj8 != null) {
					System.out.println("Tuesday");
					for(Object Tuesday : obj8) {
						System.out.println(Tuesday);
					}
				}
				
				JSONArray obj9 =  (JSONArray) jsonObject6.get("Wednesday");
				if(obj9 != null) {
					System.out.println("Wednesday");
					for(Object Wednesday : obj9) {
						System.out.println(Wednesday);
					}
				}
				
				JSONArray obj10 =  (JSONArray) jsonObject6.get("Thursday");
				if(obj10 != null) {
					System.out.println("Thursday");
					for(Object Thursday : obj10) {
						System.out.println(Thursday);
					}
				}
				
				JSONArray obj11 =  (JSONArray) jsonObject6.get("Friday");
				if(obj11 != null) {
					System.out.println("Friday");
					for(Object Friday : obj11) {
						System.out.println(Friday);
					}
				}
				
				
				
			}
			
			System.out.println("//students\\");
			 
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

		try {//https://stackoverflow.com/questions/10926353/how-to-read-json-file-into-java-with-simple-json-library
			JSONArray obj = (JSONArray) parser.parse(new FileReader(path));
			
			for(Object o : obj) {
				JSONObject jsonObject4 = (JSONObject) o;
				
				String lecturerName = (String) jsonObject4.get("lecturerName");
				System.out.println(lecturerName);
				
				String lecturerSurname = (String) jsonObject4.get("lecturerSurname");
				System.out.println(lecturerSurname);
				
				JSONObject jsonObject5 = (JSONObject) jsonObject4.get("schedule");
				JSONObject jsonObject6 = (JSONObject) jsonObject5.get("courseDayHour");
				
				JSONArray obj7 =  (JSONArray) jsonObject6.get("Monday");
				if(obj7 != null) {
					System.out.println("Monday");
					for(Object Monday : obj7) {
						System.out.println(Monday);
					}
				}
				
				JSONArray obj8 =  (JSONArray) jsonObject6.get("Tuesday");
				if(obj8 != null) {
					System.out.println("Tuesday");
					for(Object Tuesday : obj8) {
						System.out.println(Tuesday);
					}
				}
				
				JSONArray obj9 =  (JSONArray) jsonObject6.get("Wednesday");
				if(obj9 != null) {
					System.out.println("Wednesday");
					for(Object Wednesday : obj9) {
						System.out.println(Wednesday);
					}
				}
				
				JSONArray obj10 =  (JSONArray) jsonObject6.get("Thursday");
				if(obj10 != null) {
					System.out.println("Thursday");
					for(Object Thursday : obj10) {
						System.out.println(Thursday);
					}
				}
				
				JSONArray obj11 =  (JSONArray) jsonObject6.get("Friday");
				if(obj11 != null) {
					System.out.println("Friday");
					for(Object Friday : obj11) {
						System.out.println(Friday);
					}
				}
				
				
				
			}
			
			System.out.println("//students\\");
			 
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

		return new Student(studentName,studentSurname,transcript,semester,schedule,advisor, enrolledYear);


	}
	
	public Semester initializeSemester(JSONObject jsonObject){
		
		Gson gson = new Gson();
		String semesterName = jsonObject.get("name").toString();
		Type courseListType = new TypeToken<ArrayList<Course>>(){}.getType();
		ArrayList<Course> openedCourse = gson.fromJson(jsonObject.get("openedCourse").toString(),courseListType);

		return new Semester(semesterName, openedCourse);

	}
	
	public Schedule initializeSchedule(JSONObject jsonObject){
		
		Gson gson = new Gson();
		HashMap courseDayHour = jsonToMap(jsonObject.get("courseDayHour").toString());

		return new Schedule(courseDayHour);

	}
	
	public Lecturer initializeLecturer(JSONObject jsonObject){
		
		Gson gson = new Gson();
		Type courseListType = new TypeToken<ArrayList<Student>>(){}.getType();
		String lecturerName = jsonObject.get("name").toString();
		String lecturerSurname = jsonObject.get("surname").toString();
		Schedule schedule = jsonToClassSchedule(jsonObject.get("schedule").toString());
		ArrayList<Course> givenCourses = gson.fromJson(jsonObject.get("givenCourses").toString(),courseListType);

		return new Lecturer(lecturerName, lecturerSurname, schedule, givenCourses);

	}
	
	public Advisor initializeAdvisor(JSONObject jsonObject){
		
		Gson gson = new Gson();
		Type courseListType = new TypeToken<ArrayList<Student>>(){}.getType();
		ArrayList<Student> advisedStudents = gson.fromJson(jsonObject.get("advisedStudents").toString(),courseListType);
		String advisorName = jsonObject.get("name").toString();
		String advisorSurname = jsonObject.get("surname").toString();

		return new Advisor(advisedStudents, advisorName, advisorSurname);

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
