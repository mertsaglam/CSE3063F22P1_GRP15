package Iteration_2.src;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public  class CompulsoryCourse {

	private String courseCode;
	private  String courseName;
	private int credit;
	private ArrayList<String> prerequisites; //includes courseCodes only
	private Lecturer lecturer;
	private  CourseSection courseSection;
	private ArrayList<Student> courseStudents;
	private  String openedTerm;


	//Constructor with parameters takes in a course code, course name, credit, prerequisites, schedule, semester and course students


	public CompulsoryCourse(String courseCode, String courseName, int credit, ArrayList<String> prerequisites, Lecturer lecturer, CourseSection courseSection, ArrayList<Student> courseStudents, String givenSemester) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credit = credit;
		this.prerequisites = prerequisites;
		this.lecturer = lecturer;
		this.courseSection = courseSection;
		this.courseStudents = courseStudents;
		this.openedTerm = givenSemester;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public String getCourseCode() {
		return courseCode;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public String getCourseName() {
		return courseName;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public int getCredit() {
		return credit;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setCredit(int credit) {
		this.credit = credit;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setPrerequisites(ArrayList<String> prerequisites) {
		this.prerequisites = prerequisites;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public String getOpenedTerm() {
		return openedTerm;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setOpenedTerm(String openedTerm) {
		this.openedTerm = openedTerm;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public ArrayList<String> getPrerequisites() {
		return prerequisites;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}
	//Getter for semester property
	//Getter for schedule property
	public Lecturer getLecturer() {
		return lecturer;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}
	//Getter for course students property
	public ArrayList<Student> getCourseStudents() {
		return courseStudents;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}
	//Setter for course students property
	public void setCourseStudents(ArrayList<Student> courseStudent) {
		this.courseStudents = courseStudents;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public CourseSection getCourseSection() {
		return courseSection;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setCourseSection(CourseSection courseSection) {
		this.courseSection = courseSection;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}
	public Schedule getRandomSection(){
		int size =this.getCourseSection().getSchedule().size();
		HashMap<String,Schedule> scheduleHashMap = this.getCourseSection().getSchedule();
		Random random = new Random();
		return size == 1 ? scheduleHashMap.get(String.valueOf(1)):scheduleHashMap.get(String.valueOf(random.nextInt(1,size)));
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();

	}

	@Override
	public String toString() {
		return "CompulsoryCourse{" +
				"courseCode='" + courseCode + '\'' +
				", courseName='" + courseName + '\'' +
				", credit=" + credit +
				", prerequisites=" + prerequisites +
				", lecturer=" + lecturer +
				", courseSection=" + courseSection +
				", courseStudents=" + courseStudents +
				", givenSemester='" + openedTerm + '\'' +
				'}';
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
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
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public CourseSection() {
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public String getCourse() {
		return courseCode;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setCourse(String courseCode) {
		this.courseCode = courseCode;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public int getSectionID() {
		return sectionCount;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setSectionCount(int sectionCount) {
		this.sectionCount = sectionCount;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}


	public String getCourseCode() {
		return courseCode;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public int getSectionCount() {
		return sectionCount;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public HashMap<String, Schedule> getSchedule() {
		return schedule;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public void setSchedule(HashMap<String, Schedule> schedule) {
		this.schedule = schedule;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
	}

	public int getQuota() {
		return quota;
		Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        	LoggingAgent.LoggerMethod();
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

