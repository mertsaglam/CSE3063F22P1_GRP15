import random

class CompulsoryCourse:

	#Constructor with parameters takes in a course code, course name, credit, prerequisites, schedule, semester and course students


	def __init__(self, courseCode, courseName, credit, prerequisites, lecturer, courseSection, courseStudents, givenSemester):
		self.__courseCode = courseCode
		self.__courseName = courseName
		self.__credit = credit
		self.__prerequisites = prerequisites
		self.__lecturer = lecturer
		self.__courseSection = courseSection
		self.__courseStudents = courseStudents
		self.__openedTerm = givenSemester

	def getCourseCode(self):
		return self.__courseCode


	def setCourseCode(self, courseCode):
		self.__courseCode = courseCode


	def getCourseName(self):
		return self.__courseName


	def setCourseName(self, courseName):
		self.__courseName = courseName


	def getCredit(self):
		return self.__credit


	def setCredit(self, credit):
		self.__credit = credit


	def setPrerequisites(self, prerequisites):
		self.__prerequisites = prerequisites


	def setLecturer(self, lecturer):
		self.__lecturer = lecturer


	def getOpenedTerm(self):
		return self.__openedTerm


	def setOpenedTerm(self, openedTerm):
		self.__openedTerm = openedTerm


	def getPrerequisites(self):
		return self.__prerequisites

	#Getter for semester property
	#Getter for schedule property
	def getLecturer(self):
		return self.__lecturer

	#Getter for course students property
	def getCourseStudents(self):
		return self.__courseStudents

	#Setter for course students property
	def setCourseStudents(self, courseStudents):
		self.__courseStudents = courseStudents


	def getCourseSection(self):
		return self.__courseSection


	def setCourseSection(self, courseSection):
		self.__courseSection = courseSection

	def getRandomSection(self):
		size = self.getCourseSection().getSchedule().size()
		scheduleHashMap = self.getCourseSection().getSchedule()
		r1 = random.randint(1,size)
		return scheduleHashMap.get(1) if size == 1 else scheduleHashMap.get(r1)


	def toString(self):
		return "CompulsoryCourse{" + "courseCode='" + self.__courseCode + '\'' + ", courseName='" + self.__courseName + '\'' + ", credit=" + self.__credit + ", prerequisites=" + self.__prerequisites + ", lecturer=" + self.__lecturer + ", courseSection=" + self.__courseSection + ", courseStudents=" + self.__courseStudents + ", givenSemester='" + self.__openedTerm + '\'' + '}'


class CourseSection:

	#courseCode = ""
	#sectionCount = 0
	#schedule
	#quota = 0

	def __init__(self, courseCode, sectionCount, schedule, quota):
		self.__courseCode = courseCode
		self.__sectionCount = sectionCount
		self.__schedule = schedule
		self.__quota = quota

	def getCourse(self):
		return self.__courseCode


	def setCourse(self, courseCode):
		self.__courseCode = courseCode


	def getSectionID(self):
		return self.__sectionCount


	def setSectionCount(self, sectionCount):
		self.__sectionCount = sectionCount


	def getCourseCode(self):
		return self.__courseCode


	def setCourseCode(self, courseCode):
		self.__courseCode = courseCode


	def getSectionCount(self):
		return self.__sectionCount


	def getSchedule(self):
		return self.__schedule


	def setSchedule(self, schedule):
		self.__schedule = schedule


	def getQuota(self):
		return self.__quota


	def setQuota(self, quota):
		self.__quota = quota


	def toString(self):
		return "CourseSection{" + "courseCode='" + self.__courseCode + '\'' + ", sectionCount=" + self.__sectionCount + ", schedule=" + self.__schedule + ", quota=" + self.__quota + '}'
