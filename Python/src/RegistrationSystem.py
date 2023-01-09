import logging

class RegistrationSystem:
    def __init__(self):
        self.__logger = logging.getLogger(__name__)

    def check_course_is_taken_before(self, enrollment_request):
        student = enrollment_request.student
        courses = enrollment_request.courses
        taken_courses = []
        self.__logger.info(f"System Checking {student.student_id}'s enrollment requests")


        for course in courses:
            if course.course_code in [c.course_code for c in student.transcript_before.taken_courses]:
                print(f"Course {course.course_code} can not be taken because it has already been taken.")
                self.__logger.warning(f"Course {course.course_code} failed 'taken before' test.")
            else:
                self.__logger.info(f"Course {course.course_code} passed 'taken before' test.")
                taken_courses.append(course)

        enrollment_request.courses = taken_courses

    def check_prerequisites(self, enrollment_request):
        courses = enrollment_request.courses
        student = enrollment_request.student
        taken_courses = []

        for course in courses:
            if course.prerequisites is not None:
                if not all(prereq in [c.course_code for c in student.transcript_before.taken_courses] for prereq in
                           course.prerequisites):
                    print(f"Course {course.course_code} can not be taken because prerequisites are not satisfied.")
                    self.__logger.info(f"Course {course.course_code} failed 'prerequisites' test.")
                else:
                    self.__logger.info(f"Course {course.course_code} passed 'prerequisites' test.")
                    taken_courses.append(course)
            else:
                print(f"Course {course.course_code} passed 'prerequisites' test.")
                self.__logger.info(f"Course {course.course_code} passed 'prerequisites' test.")
                taken_courses.append(course)

        enrollment_request.courses = taken_courses

    def is_opened_this_term(self, enrollment_request, term):
        courses = enrollment_request.courses
        student = enrollment_request.student
        taken_courses = []

        for course in courses:
            if course.opened_term == term:
                taken_courses.append(course)
                self.__logger.info(f"Course {course.course_code} passed 'opened this term' test.")
            else:
                print(f"Course {course.course_code} can not been taken because it does not opened this term")
                self.__logger.info(f"Course {course.course_code} failed 'opened this term' test.")

        enrollment_request.courses = taken_courses
