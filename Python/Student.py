import logging
import random
import CompulsoryCourse
import Transcript
import Schedule
import Advisor
from typing import List

class Student:
    def __init__(self, student_name: str, student_surname: str, transcript_before: 'Transcript', transcript_after: 'Transcript',
                 schedule: 'Schedule', advisor: 'Advisor', enrolled_year: str) -> None:
        self.student_name = student_name
        self.student_surname = student_surname
        self.transcript_before = transcript_before
        self.transcript_after = transcript_after
        self.schedule = schedule
        self.advisor = advisor
        self.enrolled_year = enrolled_year

    def __init__(self, student_name: str, student_surname: str, transcript_before: 'Transcript',
                 schedule: 'Schedule', advisor: 'Advisor', enrolled_year: str) -> None:
        self.student_name = student_name
        self.student_surname = student_surname
        self.transcript_before = transcript_before
        self.schedule = schedule
        self.advisor = advisor
        self.enrolled_year = enrolled_year

    def __init__(self, student_id: str, student_name: str, student_surname: str, enrolled_year: str) -> None:
        self.student_name = student_name
        self.student_surname = student_surname
        self.enrolled_year = enrolled_year

    def get_studentID(self):
        return self.studentID

    def set_studentID(self, studentID):
        self.studentID = studentID

    def get_studentSurname(self):
        return self.studentSurname

    def set_studentSurname(self, studentSurname):
        self.studentSurname = studentSurname

    def get_studentName(self):
        return self.studentName

    def set_studentName(self, studentName):
        self.studentName = studentName

    def get_transcriptBefore(self):
        return self.transcriptBefore

    def set_transcriptBefore(self, transcriptBefore):
        self.transcriptBefore = transcriptBefore

    def get_transcriptAfter(self):
        return self.transcriptAfter

    def set_transcriptAfter(self, transcriptAfter):
        self.transcriptAfter = transcriptAfter

    def get_schedule(self):
        return self.schedule

    def set_schedule(self, schedule):
        self.schedule = schedule

    def get_advisor(self):
        return self.advisor

    def set_advisor(self, advisor):
        self.advisor = advisor

    def get_enrolledYear(self):
        return self.enrolledYear

    def set_enrolledYear(self, enrolledYear):
        self.enrolledYear = enrolledYear

    def create_studentID(self):
        department = "1501"
        self.set_studentID(department + self.enrolledYear[2:] + str(int(random.random() * 899) + 100))

    def calculateTranscriptAfter(self, enrollmentRequest, prob):
        student = enrollmentRequest.getStudent()
        transcriptBefore = student.getTranscriptBefore()
        logger = logging.getLogger(__name__)

        temp = Transcript()

        courses = enrollmentRequest.getCourses()
        taken_credit = 0
        for credit in courses.map(CompulsoryCourse.getCredit):
            taken_credit += credit
        logger.info(f"End of the term: Student {student.getStudentID()} passed the courses: {courses.map(CompulsoryCourse.getCourseCode)}")
        temp.setTakenCredit(transcriptBefore.getTakenCredit() + taken_credit)
        temp.addCourseGrade(temp.randomCourseGrade(courses, prob))
        temp.addCourseGrade(transcriptBefore.getCourseGrades())
        temp.addTakenCourse(courses)
        temp.addTakenCourse(transcriptBefore.getTakenCourses())
        temp.setGpa(temp.calculateGpa())
        student.setTranscriptAfter(temp)
        logger.info("New GPA is calculated and transcript is updated.")

    def toString(self):
        return "Student{studentID='{}', studentName='{}', studentSurname='{}', transcriptBefore={}, transcriptAfter={}, schedule={}, advisor={}, enrolledYear='{}'}".format(self.studentID, self.studentName, self.studentSurname, self.transcriptBefore, self.transcriptAfter, self.schedule, self.advisor, self.enrolledYear)