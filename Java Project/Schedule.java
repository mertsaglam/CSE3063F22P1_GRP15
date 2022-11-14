//import java.util.ArrayList;
//import java.text.SimpleDateFormat;
import java.util.HashMap;

 public class Schedule {

    //added ver1.0 private HashMap<String,String[]> courseDayHour = new HashMap <String,String[]>();
     private HashMap<String,String[]> courseDayHour;

    //added ver1.0
    public Schedule (HashMap<String,String[]> courseDayHour) {
       this.courseDayHour = courseDayHour;


       //days and start hours
        courseDayHour.put("Monday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        courseDayHour.put("Tuesday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        courseDayHour.put("Wednesday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        courseDayHour.put("Thursday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        courseDayHour.put("Friday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        courseDayHour.put("Saturday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        courseDayHour.put("Sunday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
    }


    // added ver 2.0
public Schedule (){
      this.courseDayHour = new HashMap<String,String[]>();
}


//getter
//HashMap<String day,String[] startHour>

public HashMap<String ,String[]> getCourseDayHour(){
        return courseDayHour;
    }

    //setter
//HashMap<String day,String[] startHour>
public void setCourseDayHour(HashMap<String ,String[]>courseDayHour){

        this.courseDayHour= courseDayHour;
}
}
