import java.util.ArrayList;

public class CompulsaryCourse extends Course {
	private CourseSection courseSection;
	private Schedule schedule;

	public CompulsaryCourse(String courseCode, int credit, ArrayList<Course> prerequisites, Schedule schedule,
			Semester semester, CourseSection courseSection) {
		this.courseCode = courseCode;
		this.credit = credit;
		this.prerequisites = prerequisites;
		this.schedule = schedule;
		this.semester = semester;
		this.courseSection = courseSection;
	}

	public CompulsaryCourse() {
	}
}
