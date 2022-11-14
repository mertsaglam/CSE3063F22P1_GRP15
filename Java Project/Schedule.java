import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    HashMap<String,String[]> courseDayHour;

    public Schedule(HashMap<String, String[]> courseDayHour) {
        this.courseDayHour = courseDayHour;
    }

    public HashMap<String, String[]> getCourseDayHour() {
        return courseDayHour;
    }

    public void setCourseDayHour(HashMap<String, String[]> courseDayHour) {
        this.courseDayHour = courseDayHour;
    }

    public Schedule() {
    }
}
