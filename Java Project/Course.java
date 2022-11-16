import java.util.ArrayList;

public  class Course {
	
	private String courseCode;
	private String courseName;
	private int credit;
	private ArrayList<String> prerequisites; //includes courseCodes only
	private Semester semester;
	private Lecturer lecturer;
	private ArrayList<Student> courseStudents;
	private CourseSection courseSection;

	//Constructor with no parameters
	public Course() {
		this.courseCode = "";
		this.courseName = "";
		this.credit = 0;
		this.prerequisites = new ArrayList<String>();
		this.lecturer = new Lecturer();
		this.courseStudents = new ArrayList<Student>();
	}
	//Constructor with parameters takes in a course code, course name, credit, prerequisites, schedule, semester and course students
	public Course(String courseCode, String courseName, int credit, ArrayList<String> prerequisites, Lecturer lecturer, Semester semester, ArrayList<Student> courseStudents) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credit = credit;
		this.prerequisites = prerequisites;
		this.lecturer = lecturer;
		this.courseStudents = courseStudents;
	}
	//Getters and setters for the properties
	//Getter for course code property
	public String getCourseCode() {
		return courseCode;
	}
	//Getter for course name property
	public String getCourseName() {
		return courseName;
	}
	//Getter for credit property
	public int getCredit() {
		return credit;
	}
	//Getter for prerequisites property
	public ArrayList<String> getPrerequisites() {
		return prerequisites;
	}
	//Getter for semester property
	public Semester getSemester() {
		return semester;
	}
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


}
class CourseSection {

	private String courseCode;
	private int sectionCount;
	private Schedule schedule;
	private int quota;

	public CourseSection(String courseCode, int sectionID, Schedule schedule, int quota) {
		this.courseCode = courseCode;
		this.sectionCount = sectionID;
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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

}

