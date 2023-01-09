import unittest
import CourseRegistrationSimulation

class TestUnitTests(unittest.TestCase):
    def test_assertions(self):
        c = CourseRegistrationSimulation.CourseRegistrationSimulation()
        c.create_courses()

        students = c.create_random_student(5)

        self.assertEqual(5, len(students))
        self.assertIsNotNone(students)
