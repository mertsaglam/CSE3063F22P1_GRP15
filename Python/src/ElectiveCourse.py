class ElectiveCourse:
    def __init__(self, course_code, course_name, credit, quota, schedule, elective_type):
        self.quota = quota
        self.schedule = schedule
        self.elective_type = elective_type

    def __init__(self, quota, schedule, elective_type):
        self.quota = quota
        self.schedule = schedule
        self.elective_type = elective_type

    def get_quota(self):
        return self.quota

    def set_quota(self, quota):
        self.quota = quota

    def get_schedule(self):
        return self.schedule

    def set_schedule(self, schedule):
        self.schedule = schedule

    def get_elective_type(self):
        return self.elective_type

    def set_elective_type(self, elective_type):
        self.elective_type = elective_type
