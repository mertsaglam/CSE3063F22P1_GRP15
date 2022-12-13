package Iteration_2.src;



import java.util.ArrayList;
import java.util.HashMap;

public  class CompulsoryCourse extends Course {
	

	private ArrayList<String> prerequisites; //includes courseCodes only
	private Lecturer lecturer;
	private  CourseSection courseSection;
	private ArrayList<Student> courseStudents;
	private  String givenSemester;


	//Constructor with parameters takes in a course code, course name, credit, prerequisites, schedule, semester and course students


	public CompulsoryCourse(String courseCode, String courseName, int credit) {
	}

	public CompulsoryCourse(String courseCode, String courseName, int credit, ArrayList<String> prerequisites, Lecturer lecturer, CourseSection courseSection, ArrayList<Student> courseStudents, String givenSemester) {
		this.prerequisites = prerequisites;
		this.lecturer = lecturer;
		this.courseSection = courseSection;
		this.courseStudents = courseStudents;
		this.givenSemester = givenSemester;
	}


	public ArrayList<String> getPrerequisites() {
		return prerequisites;
	}
	//Getter for semester property
	//Getter for schedule property
	public Lecturer getLecturer() {
		return lecturer;
	}
	//Getter for course students property
	public ArrayList<Student> getCourseStudents() {
		return courseStudents;
	}
	//Setter for course students property
	public void setCourseStudents(ArrayList<Student> courseStudent) {
		this.courseStudents = courseStudents;
	}

	public CourseSection getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(CourseSection courseSection) {
		this.courseSection = courseSection;
	}

	@Override
	public String toString() {
		return "CompulsoryCourse{" +
				", prerequisites=" + prerequisites +
				", lecturer=" + lecturer +
				", courseSection=" + courseSection +
				", courseStudents=" + courseStudents +
				'}';
	}
}
class CourseSection {

	private String courseCode;
	private int sectionCount;
	private HashMap<String,Schedule> schedule;
	private int quota;

	public CourseSection(String courseCode, int sectionCount, HashMap<String, Schedule> schedule, int quota) {
		this.courseCode = courseCode;
		this.sectionCount = sectionCount;
		this.schedule = schedule;
		this.quota = quota;
	}

	public CourseSection() {
	}

	public String getCourse() {
		return courseCode;
	}

	public void setCourse(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getSectionID() {
		return sectionCount;
	}

	public void setSectionCount(int sectionCount) {
		this.sectionCount = sectionCount;
	}


	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getSectionCount() {
		return sectionCount;
	}

	public HashMap<String, Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(HashMap<String, Schedule> schedule) {
		this.schedule = schedule;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	@Override
	public String toString() {
		return "CourseSection{" +
				"courseCode='" + courseCode + '\'' +
				", sectionCount=" + sectionCount +
				", schedule=" + schedule +
				", quota=" + quota +
				'}';
	}
}

