package Iteration_2.src;//import java.util.ArrayList;
//import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Schedule {

    //added ver1.0 private HashMap<String,String[]> courseDayHour = new HashMap <String,String[]>();
    private HashMap<String, ArrayList<String>> courseDayHour;

    //added ver1.0
    public Schedule(HashMap<String, ArrayList<String>> courseDayHour) {
        this.courseDayHour = courseDayHour;


        //days and start hours
        /*
        courseDayHour.put("Monday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
        courseDayHour.put("Tuesday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
        courseDayHour.put("Wednesday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
        courseDayHour.put("Thursday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
        courseDayHour.put("Friday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
        courseDayHour.put("Saturday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
        courseDayHour.put("Sunday", new String[]{"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});*/
    
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }


    // added ver 2.0
    public Schedule() {
        this.courseDayHour = new HashMap<String, ArrayList<String>>();
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }


//getter
//HashMap<String day,String[] startHour>

    public HashMap<String, ArrayList<String>> getCourseDayHour() {
        return courseDayHour;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    //setter
//HashMap<String day,String[] startHour>
    public void setCourseDayHour(HashMap<String, ArrayList<String>> courseDayHour) {

        this.courseDayHour = courseDayHour;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "courseDayHour=" + courseDayHour +
                '}';
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }

    public boolean isCollided(Schedule schedule, Schedule schedule1) {
        for (String key : schedule.getCourseDayHour().keySet()) {
            if (schedule1.getCourseDayHour().containsKey(key)) {

                for (String value : schedule.getCourseDayHour().get(key)) {
                    if (schedule1.getCourseDayHour().get(key).contains(value))
                        return true;

                }
            }
        }
        return false;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();

    }



//Arrayliste dönüştürülecek
    public Schedule appendSchedule(Schedule schedule, Schedule schedule1) {
        HashMap<String, ArrayList<String>> currentSchedule = this.courseDayHour;
        schedule.courseDayHour.putAll(schedule1.courseDayHour);
        this.courseDayHour = schedule.courseDayHour;
        return schedule;
        
        Iteration_2.src.LoggingAgent LoggingAgent = new Iteration_2.src.LoggingAgent();
        LoggingAgent.LoggerMethod();
    }
}
