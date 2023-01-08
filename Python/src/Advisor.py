
import Lecturer
import logging.config


#-----LOGGER FIRST TRIAL-----
#import logging
#logging.basicConfig(handlers=[logging.FileHandler("LogFile.log"), logging.StreamHandler()], encoding='utf-8', level=logging.DEBUG, format='%(asctime)s - %(levelname)s: %(message)s', datefmt='%d/%m/%Y %I:%M:%S %p')
#----------------------------

logging.config.fileConfig("logging.conf")
logger = logging.getLogger()


class Advisor(Lecturer.Lecturer):

    def __init__(self, lecturerName, lecturerSurname, schedule, students):
        super().__init__(lecturerName, lecturerSurname, schedule)
        self.__students = students

    def Advisor(self):
        self.__students = list()

    def appendStudent(self, studentID):
        self.__students.append(studentID)

    def checkScheduleCollision(self, enrollmentRequest):
        logger = logging.getLogger(__name__)
        courses = enrollmentRequest.getCourses()
        canBeTaken = list()
        schedule = enrollmentRequest.getStudent().getSchedule()

        if courses.len() == 1:
            print("Course " + courses[0].getCourseCode() + " passed the 'schedule collision' test. ")
            canBeTaken.append(courses[0])
        else:
            for course in courses:
                for course1 in courses:
                    if not(course.getCourseCode() == course1.getCourseCode()):
                        if schedule.isCollided(course.getRandomSection(), course1.getRandomSection()):
                            print("Advisor " + self.getLecturerName() + " did not allow the taking of course " + course.getCourseCode() + " because of a time conflict")
                            logging.info("Course " + courses[0].getCourseCode() + " failed the 'schedule collision ' test. ")
                            canBeTaken.remove(course)
                        else:
                            logging.info("Course " + courses[0].getCourseCode() + " passed the 'schedule collision ' test. ")
                            canBeTaken.append(course)
        enrollmentRequest.setCourses(canBeTaken)

    def __str__(self):
        return "Advisor{Name='" + super().getLecturerName() + '\'' + ", Surname='" + super().getLecturerSurname() + '\'' + ", Students='" + self.__students + '\'' + ", Schedule=" + super().getSchedule() + '}'

#-------------------------------MOVED HERE FROM LECTURER--------------------------------------
    def lecturerToAdvisor(self, lecturers):
        advisors = list()
        for lecturer in lecturers:
            advisor = Advisor(lecturer.getLecturerName(), lecturer.getLecturerSurname(), lecturer.getSchedule(), list())
            advisors.append(advisor)
        return advisors
#---------------------------------------------------------------------------------------------
