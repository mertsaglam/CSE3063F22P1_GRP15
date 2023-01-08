
import Lecturer
import logging.config

logging.config.fileConfig("logging.conf")
logger = logging.getLogger()

#-----OLD LOGGER-----
#import logging
#logging.basicConfig(handlers=[logging.FileHandler("LogFile.log"), logging.StreamHandler()], encoding='utf-8', level=logging.DEBUG, format='%(asctime)s - %(levelname)s: %(message)s', datefmt='%d/%m/%Y %I:%M:%S %p')


class Advisor(Lecturer.Lecturer):

    def __init__(self, lecturerName, lecturerSurname, schedule, students):

        super().__init__(lecturerName, lecturerSurname, schedule)
        self.__students = students

#   ?-------------------------------------?
#J  public Advisor() {
#J      this.students=new ArrayList<>();
#J   }
#   ?-------------------------------------?

    def appendStudent(self, studentID):
        self.__students.append(studentID)

    def checkScheduleCollision(self, enrollmentRequest):
#J?     Logger logger = Logger.getLogger(Advisor.class.getName());
        courses = enrollmentRequest.getCourses()
        canBeTaken = list()
        schedule = enrollmentRequest.getStudent().getSchedule

        if courses.len():
            print("Course " + courses.get(0).getCourseCode() + " is passed from 'schedule collision' test. ")
            canBeTaken.append(courses.get(0))
        else:
            for course in courses:
                for course1 in courses:
                    if not(course.getCourseCode() == course1.getCourseCode()):
                        if schedule.isCollided(course.getRandomSection(), course1.getRandomSection()):
                            print("Advisor " + self.getLecturerName() + " did not allow to take course " + course.getCourseCode() + " because of time conflict")
                            logging.info("Course " + courses.get(0).getCourseCode() + " is failed from 'schedule collision ' test. ")
                            canBeTaken.remove(course)
                        else:
                            logging.info("Course " + courses.get(0).getCourseCode() + " is passed from 'schedule collision ' test. ")
                            canBeTaken.append(course)
        enrollmentRequest.setCourses(canBeTaken)

#-------------------------------MOVED HERE FROM LECTURER--------------------------------------
    def lecturerToAdvisor(self, lecturers):
        advisors = list()
        for lecturer in lecturers:
            advisor = Advisor(lecturer.getLecturerName(), lecturer.getLecturerSurname(), lecturer.getSchedule(), [])
            advisors.append(advisor)
        return advisors
#---------------------------------------------------------------------------------------------

    def __str__(self):
        return "Advisor{Name='" + super().getLecturerName() + '\'' + ", Surname='" + super().getLecturerSurname() + '\'' + ", Students='" + self.__students + '\'' + ", Schedule=" + super().getSchedule() + '}'

