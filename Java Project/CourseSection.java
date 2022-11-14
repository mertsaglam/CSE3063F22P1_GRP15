public class CourseSection {

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
