package Iteration_2.src;



import java.util.ArrayList;

public class Advisor extends Lecturer {
    //The students that are advised by the advisor
    ArrayList<String> students;
    //The advisor's surname

    //Constructor for advisor takes in an arraylist of students, name and surname


    public Advisor(String lecturerName, String lecturerSurname, Schedule schedule, ArrayList<String> students) {
        super(lecturerName, lecturerSurname, schedule);
        this.students = students;
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
                  if(!schedule.isCollided(course.getRandomSection(),compulsoryCourse.getRandomSection())){
                      canBeTaken.add(course);
                      System.out.println("Course "+ course.getCourseCode()+" is passed from 'schedule collision ' test. ");
                  }
                  else {
                      System.out.println("Course "+ course.getCourseCode()+" can not taken because it collides with " +compulsoryCourse.getCourseCode());
                  }
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Advisor{" +
                "Name='" + getLecturerName() + '\'' +
                ", Surname='" + getLecturerSurname() + '\'' +
                ", Students='" + students + '\'' +
                ", schedule=" + getSchedule() +
                '}';
    }
}