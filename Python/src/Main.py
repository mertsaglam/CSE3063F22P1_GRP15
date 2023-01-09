import CourseRegistrationSimulation
import FileManager1
import os
import random

def main():
    file_manager1 = FileManager1.FileManager1()
    courses = file_manager1.read_course("Jsons/compulsoryCourses.json")
    #os.environ["log4j.configurationFile"] = "/Users/omerfarukbulut/CSE3063F22P1_GRP15/Java Project/Iteration_2/src/Resources/log4j.tld"
    course_registration_simulation = CourseRegistrationSimulation.CourseRegistrationSimulation([], [], [], [], None)

    course_registration_simulation.star_simulation()

if __name__ == "__main__":
    main()
