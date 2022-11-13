import java.util.ArrayList;

public abstract class Course {
	
	protected String courseCode;
	protected String courseName;
	protected int credit;
	protected ArrayList<Course> prerequisites;
	protected Schedule schedule;
	protected Semester semester;
	protected ArrayList<Student> courseStudents;
	
	public Course() {
	
	}
	
	public Course getCourse(String courseCode) {
		return this;
	}
}
