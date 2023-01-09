import unittest
import CourseRegistrationSimulation

class TestUnitTests(unittest.TestCase):
    def test_assertions1(self):
        c = CourseRegistrationSimulation.CourseRegistrationSimulation()
        c.create_courses()

        students = c.create_random_student(5)

        self.assertEqual(5, len(students))
        self.assertIsNotNone(students)



    def test_assertions2(self):
        c = CourseRegistrationSimulation.CourseRegistrationSimulation()
        c.match_student_advisor()

        self.assertIsNotNone(c)



    def test_assertions3(self):
        c = CourseRegistrationSimulation.CourseRegistrationSimulation()
        c.create_courses()

        courses = c.applyCourse(c.students)

        self.assertEqual(12, len(courses))
        self.assertIsNotNone(courses)
