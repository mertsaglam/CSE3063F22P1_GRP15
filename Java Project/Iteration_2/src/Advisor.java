package Iteration_2.src;



import java.util.ArrayList;

public class Advisor extends Lecturer {
    //The students that are advised by the advisor

    //The advisor's surname

    //Constructor for advisor takes in an arraylist of students, name and surname

    public Advisor(String lecturerName, String lecturerSurname, Schedule schedule) {
        super(lecturerName, lecturerSurname, schedule);
    }

    public Advisor() {
    }
    //Constructor for advisor with no parameters
    public void checkScheduleCollision(EnrollmentRequest enrollmentRequest){
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        ArrayList<CompulsoryCourse> canBeTaken = new ArrayList<>();
        Schedule schedule = new Schedule();
        for(CompulsoryCourse course: courses){
            if (canBeTaken.isEmpty()){
                canBeTaken.add(course);
            }
            else{
                for (CompulsoryCourse compulsoryCourse: canBeTaken){
                  //  if(schedule.isCollided(compulsoryCourse.get))
                }
            }
        }

    }
}