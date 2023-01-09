class EnrollmentRequest:
    def __init__(self, courses, student):
        self.__courses = courses
        self.__student = student
        self.__schedule = {}
        self.__result = {}
        self.__credit_limit = 0
        self.__error = ""

    def get_courses(self):
        return self.__courses

    def set_courses(self, courses):
        self.__courses = courses

    def get_result(self):
        return self.__result

    def set_result(self, result):
        self.__result = result

    def get_student(self):
        return self.__student

    def set_student(self, student):
        self.__student = student

    def get_schedule(self):
        return self.__schedule

    def set_schedule(self, schedule):
        self.__schedule = schedule

    def append_result(self, result1):
        temp = self.__result
        temp.update(result1)
        self.set_result(temp)

    def get_credit_limit(self):
        return self.__credit_limit

    def set_credit_limit(self, credit_limit):
        self.__credit_limit = credit_limit

    def get_total_credit(self):
        credit = 0
        for course in self.__courses:
            credit += course.get_credit()
        return credit

    def get_error(self):
        return self.__error

    def set_error(self, error):
        self.__error = error

    def __str__(self):
        return "EnrollmentRequest{{courses={}, student={}, schedule={}, result={}, credit_limit={}, error='{}'}}".format(self.__courses, self.__student, self.__schedule, self.__result, self.__credit_limit, self.__error)