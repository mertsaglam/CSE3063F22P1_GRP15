import java.util.ArrayList;

public class ElectiveCourse extends Course {
	
	private int quota;
	private String electiveType;
	
	public ElectiveCourse(String courseCode, int credit, ArrayList<Course> prerequisites, Schedule schedule, Semester semester, int quota, String electiveType) {
		this.courseCode = courseCode;
		this.credit = credit;
		this.prerequisites = prerequisites;
		this.schedule = schedule;
		this.semester = semester;
		this.quota = quota;
		this.electiveType = electiveType;
	}
}
