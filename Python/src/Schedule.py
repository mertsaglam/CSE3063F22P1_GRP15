class Schedule :
    # (not sure)
    # courseDayHour = None

    def __init__(self, courseDayHour) :
        self.__courseDayHour = courseDayHour

    # (not sure)
    def Schedule(self) :
        self.__courseDayHour =  dict()

    def  getCourseDayHour(self) :
        return self.__courseDayHour


    def setCourseDayHour(self, courseDayHour) :
        self.__courseDayHour = courseDayHour
   #toString to __str__     
    def  __str__(self) :
        return "Schedule{" + "courseDayHour=" + str(self.__courseDayHour) + str('}')
        
    # function to check whether there is a collision, a clash 
    #in schedule 
    
    def  isCollided(self, schedule,  schedule1) :
        for key,value in schedule.getCourseDayHour().items() :
            if ((key in schedule1.getCourseDayHour().keys())) :
                for value in schedule.getCourseDayHour().get(key) :
                    if (value  in schedule1.getCourseDayHour().get(key)) :
                        return True
        return False
        
    #appending the schedule
    
    def  appendSchedule(self, schedule,  schedule1) :
        currentSchedule = self.__courseDayHour
        schedule.__courseDayHour.putAll(schedule1.__courseDayHour)
        self.__courseDayHour = schedule.__courseDayHour
        return schedule
