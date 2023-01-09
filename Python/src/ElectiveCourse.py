class ElectiveCourse:
    def __init__(self, course_code, course_name, credit, quota, schedule, elective_type):
        self.__quota = quota
        self.__schedule = schedule
        self.__elective_type = elective_type

    def __init__(self, quota, schedule, elective_type):
        self.__quota = quota
        self.__schedule = schedule
        self.__elective_type = elective_type

    def get_quota(self):
        return self.__quota

    def set_quota(self, quota):
        self.__quota = quota

    def get_schedule(self):
        return self.__schedule

    def set_schedule(self, schedule):
        self.__schedule = schedule

    def get_elective_type(self):
        return self.__elective_type

    def set_elective_type(self, elective_type):
        self.__elective_type = elective_type
