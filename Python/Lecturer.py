
class Lecturer:

    def __init__(self, lecturerName, lecturerSurname, schedule):
        self.__lecturerName = lecturerName
        self.__lecturerSurname = lecturerSurname
        self.__schedule = schedule

#   ?-------------------?
#J  public Lecturer() {

#J  }
#   ?-------------------?

    def getLecturerName(self):
        return self.__lecturerName

    def getLecturerSurname(self):
        return self.__lecturerSurname

    def getSchedule(self):
        return self.__schedule

#-------------------------------MOVED TO ADVISOR---------------------------------------
#   def lecturerToAdvisor(self, lecturers):
#       advisors = list()
#       for lecturer in lecturers:
#           advisor = Advisor.Advisor(lecturer.getLecturerName(), lecturer.getLecturerSurname(), lecturer.getSchedule())  #? , new ArrayList<String>()
#           advisors.append(advisor)
#       return advisors
#--------------------------------------------------------------------------------------

    def __str__(self):
        return "Lecturer{Name='" + self.__lecturerName + "\'" + ", Surname='" + self.__lecturerSurname + "\'" + ", Schedule=" + self.__schedule + "}"
