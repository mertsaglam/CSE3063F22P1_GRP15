import random

class Transcript:
    def __init__(self, course_grades, gpa, taken_credit, taken_courses, not_taken_courses):
        self.course_grades = course_grades
        self.gpa = gpa
        self.taken_credit = taken_credit
        self.taken_courses = taken_courses
        self.not_taken_courses = not_taken_courses

    def __init__(self):
        self.course_grades = {}
        self.gpa = 0
        self.taken_credit = 0
        self.taken_courses = []
        self.not_taken_courses = []
    
    def set_transcript(self, course_grades, gpa, taken_credit, taken_courses, not_taken_courses):
        self.course_grades = course_grades
        self.gpa = gpa
        self.taken_credit = taken_credit
        self.taken_courses = taken_courses
        self.not_taken_courses = not_taken_courses

    def add_taken_course(self, courses):
        self.taken_courses.extend(courses)

    def add_taken_course_one(self, course):
        self.taken_courses.append(course)

    def remove_course(self, courses):
        self.not_taken_courses.remove(courses)

    def add_course_grade(self, course_grades):
        self.course_grades.update(course_grades)

    def get_course_grades(self):
        return self.course_grades

    def set_course_grades(self, course_grades):
        self.course_grades = course_grades

    def get_gpa(self):
        return self.gpa

    def set_gpa(self, gpa):
        self.gpa = gpa

    def get_taken_credit(self):
        return self.taken_credit

    def set_taken_credit(self, taken_credit):
        self.taken_credit = taken_credit

    def get_taken_courses(self):
        return self.taken_courses

    def set_taken_courses(self, taken_courses):
        self.taken_courses = taken_courses

    def get_not_taken_courses(self):
        return self.not_taken_courses

    def set_not_taken_courses(self, not_taken_courses):
        self.not_taken_courses = not_taken_courses

    def add_credit(self, added_credit):
        taken_credit = self.get_taken_credit()
        taken_credit += added_credit
        self.set_taken_credit(taken_credit)

    def calculate_gpa(self):
        gpa = 0
        total_credit = 0
        grade_values = {
            "AA": 4,
            "BA": 3.5,
            "BB": 3,
            "CB": 2.5,
            "CC": 2,
            "DC": 1.5,
            "FF": 0
        }
        for j in range(len(self.get_taken_courses())):
            letter_grade = self.get_course_grades().get(self.get_taken_courses()[j].get_course_code())
            gpa += self.get_taken_courses()[j].get_credit() * grade_values.get(letter_grade, 0)
            total_credit += self.get_taken_courses()[j].get_credit()
        
        return round((gpa / total_credit) * 100) / 100


    def random_course_grade(self, courses, prob):
        letter_grades = ["AA", "BA", "BB", "CB", "CC", "DC"]
        hashmap = {}
        for course in courses:
            if random.random() < prob:
                hashmap[course.get_course_code()] = "FF"
            else:
                hashmap[course.get_course_code()] = letter_grades[random.randint(0, len(letter_grades)-1)]
        
        return hashmap

    def __str__(self):
        return f"Transcript{{courseGrades={self.course_grades}, gpa={self.gpa}, takenCredit={self.taken_credit}, takenCourses={self.taken_courses}, notTakenCourses={self.not_taken_courses}}}"






