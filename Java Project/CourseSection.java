public class CourseSection {
	private Course course;
	private int sectionID;
	private Schedule schedule;
	private int quota;
	
	public CourseSection(CompulsaryCourse course, int sectionID, Schedule schedule, int quota) {
		this.course = course;
		this.sectionID = sectionID;
		this.schedule = schedule;
		this.quota = quota;
	}
}
