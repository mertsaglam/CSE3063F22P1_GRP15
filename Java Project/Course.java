import java.util.ArrayList;

public abstract class Course {
	
	protected String courseCode;
	protected String courseName;
	protected int credit;
	protected ArrayList<Course> prerequisites;
	protected Semester semester;
	protected Lecturer lecturer;
	protected ArrayList<Student> courseStudents;
	
	//Constructor with no parameters
	public Course() {
		this.courseCode = "";
		this.courseName = "";
		this.credit = 0;
		this.prerequisites = new ArrayList<Course>();
		this.lecturer = new Lecturer();
		this.courseStudents = new ArrayList<Student>();
	}
	//Constructor with parameters takes in a course code, course name, credit, prerequisites, schedule, semester and course students
	public Course(String courseCode, String courseName, int credit, ArrayList<Course> prerequisites, Lecturer lecturer, Semester semester, ArrayList<Student> courseStudents) {
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
	public ArrayList<Course> getPrerequisites() {
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



}
