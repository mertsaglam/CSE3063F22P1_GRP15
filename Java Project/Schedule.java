import java.util.HashMap;

 public class Schedule {

    //added ver1.0 private HashMap<String,String[]> courseDayHour = new HashMap <String,String[]>();
     private HashMap<String,String[]> courseDayHour;

    //added ver1.0
    public Schedule (HashMap<String,String[]> courseDayHour) {
       this.courseDayHour = courseDayHour;
       
       //days and start hours
        //added ver1.0 courseDayHour.put("Monday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        //added ver1.0  courseDayHour.put("Tuesday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        //added ver1.0 courseDayHour.put("Wednesday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        //added ver1.0  courseDayHour.put("Thursday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        //added ver1.0  courseDayHour.put("Friday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        //added ver1.0  courseDayHour.put("Saturday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
        //added ver1.0   courseDayHour.put("Sunday",new String[]{"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
    }

    
    // added ver 2.0
public Schedule (){
      this.courseDayHour = new HashMap<String,String[]>();
}


//getter
//HashMap<String day,String[] startHour>
//added ver 1.0
public HashMap<String,String[]> getCourseDayHour(){
        return courseDayHour;
}


    //setter
//HashMap<String day,String[] startHour>
     //added ver1.0
public void setCourseDayHour(HashMap<String,String[]>courseDayHour){
        this.courseDayHour = courseDayHour;
}
}
