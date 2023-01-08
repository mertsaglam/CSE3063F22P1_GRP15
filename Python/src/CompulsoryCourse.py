import random

class CompulsoryCourse:

	#courseCode = ""
	#courseName = ""
	#credit = 0
	#prerequisites #includes courseCodes only
	#lecturer
	#courseSection
	#courseStudents
	#openedTerm = ""


	#Constructor with parameters takes in a course code, course name, credit, prerequisites, schedule, semester and course students


	def __init__(self, courseCode, courseName, credit, prerequisites, lecturer, courseSection, courseStudents, givenSemester):
		self.courseCode = courseCode
		self.courseName = courseName
		self.credit = credit
		self.prerequisites = prerequisites
		self.lecturer = lecturer
		self.courseSection = courseSection
		self.courseStudents = courseStudents
		self.openedTerm = givenSemester

	def getCourseCode(self):
		return self.courseCode


	def setCourseCode(self, courseCode):
		self.courseCode = courseCode


	def getCourseName(self):
		return self.courseName


	def setCourseName(self, courseName):
		self.courseName = courseName


	def getCredit(self):
		return self.credit


	def setCredit(self, credit):
		self.credit = credit


	def setPrerequisites(self, prerequisites):
		self.prerequisites = prerequisites


	def setLecturer(self, lecturer):
		self.lecturer = lecturer


	def getOpenedTerm(self):
		return self.openedTerm


	def setOpenedTerm(self, openedTerm):
		self.openedTerm = openedTerm


	def getPrerequisites(self):
		return self.prerequisites

	#Getter for semester property
	#Getter for schedule property
	def getLecturer(self):
		return self.lecturer

	#Getter for course students property
	def getCourseStudents(self):
		return self.courseStudents

	#Setter for course students property
	def setCourseStudents(self, courseStudents):
		self.courseStudents = courseStudents


	def getCourseSection(self):
		return self.courseSection


	def setCourseSection(self, courseSection):
		self.courseSection = courseSection

	def getRandomSection(self):
		size = self.getCourseSection().getSchedule().size()
		scheduleHashMap = self.getCourseSection().getSchedule()
		r1 = random.randint(1,size)
		return scheduleHashMap.get(1) if size == 1 else scheduleHashMap.get(r1)


	def toString(self):
		return "CompulsoryCourse{" + "courseCode='" + self.courseCode + '\'' + ", courseName='" + self.courseName + '\'' + ", credit=" + self.credit + ", prerequisites=" + self.prerequisites + ", lecturer=" + self.lecturer + ", courseSection=" + self.courseSection + ", courseStudents=" + self.courseStudents + ", givenSemester='" + self.openedTerm + '\'' + '}'


class CourseSection:

	#courseCode = ""
	#sectionCount = 0
	#schedule
	#quota = 0

	def __init__(self, courseCode, sectionCount, schedule, quota):
		self.courseCode = courseCode
		self.sectionCount = sectionCount
		self.schedule = schedule
		self.quota = quota

	def getCourse(self):
		return self.courseCode


	def setCourse(self, courseCode):
		self.courseCode = courseCode


	def getSectionID(self):
		return self.sectionCount


	def setSectionCount(self, sectionCount):
		self.sectionCount = sectionCount


	def getCourseCode(self):
		return self.courseCode


	def setCourseCode(self, courseCode):
		self.courseCode = courseCode


	def getSectionCount(self):
		return self.sectionCount


	def getSchedule(self):
		return self.schedule


	def setSchedule(self, schedule):
		self.schedule = schedule


	def getQuota(self):
		return self.quota


	def setQuota(self, quota):
		self.quota = quota


	def toString(self):
		return "CourseSection{" + "courseCode='" + self.courseCode + '\'' + ", sectionCount=" + self.sectionCount + ", schedule=" + self.schedule + ", quota=" + self.quota + '}'
