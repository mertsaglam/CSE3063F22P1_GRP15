class EnrollmentRequest:
    def __init__(self, courses, student):
        self.courses = courses
        self.student = student
        self.schedule = {}
        self.result = {}
        self.credit_limit = 0
        self.error = ""

    def get_courses(self):
        return self.courses

    def set_courses(self, courses):
        self.courses = courses

    def get_result(self):
        return self.result

    def set_result(self, result):
        self.result = result

    def get_student(self):
        return self.student

    def set_student(self, student):
        self.student = student

    def get_schedule(self):
        return self.schedule

    def set_schedule(self, schedule):
        self.schedule = schedule

    def append_result(self, result1):
        temp = self.result
        temp.update(result1)
        self.set_result(temp)

    def get_credit_limit(self):
        return self.credit_limit

    def set_credit_limit(self, credit_limit):
        self.credit_limit = credit_limit

    def get_total_credit(self):
        credit = 0
        for course in self.courses:
            credit += course.get_credit()
        return credit

    def get_error(self):
        return self.error

    def set_error(self, error):
        self.error = error

    def __str__(self):
        return "EnrollmentRequest{{courses={}, student={}, schedule={}, result={}, credit_limit={}, error='{}'}}".format(self.courses, self.student, self.schedule, self.result, self.credit_limit, self.error)