import logging
import time
import random
from typing import List

import Student
import CompulsoryCourse
import Lecturer
import Advisor
import EnrollmentRequest
import FileManager1
import RegistrationSystem

logger = logging.getLogger(__name__)

class CourseRegistrationSimulation:

    __students: List[Student]
    __courses: List[CompulsoryCourse]
    __lecturers: List[Lecturer]
    __advisors: List[Advisor]
    __credit_limit: int
    __enrollment_requests: List[EnrollmentRequest]
    __errors: List[str]
    __prob_to_pass_class: float
    __prob_to: float
    __names = ["Ahmet", "Ali", "Ayşe", "Fatma", "Kemal"]
    __surnames = ["Kebapçı", "Çevik", "Öztürk", "Vural", "Ertekin"]
    __letter_grades = ["AA", "BA", "BB", "CB", "CC", "DC"]
    __year = ["2019", "2020", "2021"]
    __term: str
    __student_size: int
    
    def __init__(self, students: List[Student], courses: List[CompulsoryCourse], lecturers: List[Lecturer], advisors: List[Advisor], credit_limit: int):
        self.__students = students
        self.__courses = courses
        self.__lecturers = lecturers
        self.__advisors = advisors
        self.__credit_limit = credit_limit   

    def star_simulation(self):
        #self.logger.info("Simulation Started.")
        file_manager = FileManager1.FileManager1()
        self.create_params()
        self.create_lecturers()
        self.create_advisors()
        self.create_courses()
        self.__students = self.create_random_students(self.student_size)
        for student in self.__students:
            file_manager.write_to_file(student, f"Jsons/Students/{student.student_id}.json")
        self.create_students()
        self.match_student_advisor()
        for student in self.__students:
            applied_courses = self.apply_course(student)
            enrollment_request = EnrollmentRequest(applied_courses, student)
            self.logger.info(f"Student {student.student_id} created new Enrollment Requests with courses {[c.course_code for c in applied_courses]}")
            advisor = student.advisor
            self.check_system_requirements(enrollment_request)
            advisor.check_schedule_collision(enrollment_request)
            self.logger.info(f"Added courses to Student {student.student_id}: {[c.course_code for c in enrollment_request.courses]}")
            student.calculate_transcript_after(enrollment_request, self.prob_to_pass_class)
            file_manager.write_to_file(student, f"Outputs/{student.student_id}.json")
            time.sleep(0.3)
        self.logger.info("Simulation is over.")
    
    def create_courses(self):
        file_manager = FileManager1.FileManager1()
        self.__courses = file_manager.read_course("Jsons/compulsoryCourses.json")
        self.logger.info(len(self.__courses)+" Course Created.")

    def create_students(self):
        file_manager = FileManager1.FileManager1()
        students = file_manager.read_student("Jsons/Students")
        self.__students = students

    def create_params(self):
        try:
            file_manager = FileManager1.FileManager1()
            params = file_manager.read_params("input.json")
            self.__prob_to_pass_class = float(params["prob_to_fail_class"])
            self.__term = params["semester"]
            number = float(params["student_count"])
            self.__student_size = int(number)
        except Exception as e:
            print(e)
        

    def create_lecturers(self):
        file_manager = FileManager1.FileManager1()
        self.__lecturers = file_manager.read_lecturers("Jsons/lecturer.json")

    def create_advisors(self):
        print(self.__lecturers)
        advisor = Advisor.Advisor(None, None, None, None)
        self.__advisors = advisor.lecturer_to_advisor(self.__lecturers)
        logger.info("Advisors created from Lecturers.")

    def match_student_advisor(self):
        size = len(self.__advisors)
        for student in self.__students:
            advisor = self.__advisors[random.randint(0, size-1)]
            student.set_advisor(advisor)
            advisor.append_student(student.get_student_id())
            logger.info(f"Student {student.get_student_id()} match with {advisor.get_lecturer_name()} {advisor.get_lecturer_surname()}")

    def applyCourse(self, student):
        appliedCourseNumber = random.randint(1, 10)
        appliedCourses = []
        for i in range(appliedCourseNumber):
            randomCourse = self.__courses[random.randint(len(self.courses))]
            appliedCourses.append(randomCourse)
            logger.info(f"{student.getStudentID()} applied for {randomCourse.getCourseCode()}")
        return appliedCourses

    def check_system_requirements(self, enrollment_request):
        logger.info("System Checking {}'s enrollment requests".format(enrollment_request.get_student().get_student_id()))
        registration_system = RegistrationSystem()
        registration_system.check_course_is_taken_before(enrollment_request)
        registration_system.check_prerequisites(enrollment_request)
        registration_system.is_opened_this_term(enrollment_request, self.__term)

    def get_random_course(list):
        new_list = []

        for i in range(random.randint(0, len(list))):
            random_index = random.randint(0, len(list))
            new_list.append(list[random_index])

        return new_list

    def pass_or_fail(self):
        return random.random() < self.__prob_to_pass_class

    def create_random_student(self, size):
        students = []
        for i in range(size):
            students.append(Student(self.__names[random.randint(0, len(self.__names))], self.__surnames[random.randint(0, len(self.__surnames))], Transcript(), Transcript(), Schedule(), Advisor(), self.__year[random.randint(0, len(self.__year))]))
            students[i].create_student_id()

            for k in range(len(students) - 1):
                if students[i].get_student_id() == students[k].get_student_id():
                    students[i].create_student_id()
                    k = 0

            transcript_before = students[i].get_transcript_before()
            transcript_before.set_taken_courses(self.get_random_course(self.__courses))

            course_grades = {}
            taken_credit = 0
            for j in range(len(transcript_before.get_taken_courses())):
                taken_credit += transcript_before.get_taken_courses()[j].get_credit()
                transcript_before.set_taken_credit(taken_credit)

                course_grades[transcript_before.get_taken_courses()[j].get_course_code()] = self.__letter_grades[random.randint(0, len(self.__letter_grades))]
            transcript_before.set_course_grades(course_grades)

            transcript_before.set_gpa(transcript_before.calculate_gpa())

            students[i].set_advisor(self.__advisors[random.randint(0, len(self.__advisors))])

        return students

    def print_arraylist(arr):
        for i in range(len(arr)):
            # Assuming arr is a list object
            current = arr[i].to_string()
            print(current)
            # Do something with the current element here

    def get_errors(self):
        return self.__errors

    def set_errors(self, errors):
        self.__errors = errors

