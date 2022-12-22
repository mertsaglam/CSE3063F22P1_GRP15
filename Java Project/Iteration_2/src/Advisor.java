package Iteration_2.src;


import java.util.ArrayList;
import java.util.Objects;

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
        this.students=new ArrayList<>();
    }

    public void appendStudent(String studentID) {
        this.students.add(studentID);
    }

    //Constructor for advisor with no parameters
    public void checkScheduleCollision(EnrollmentRequest enrollmentRequest) {
        ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
        ArrayList<CompulsoryCourse> canBeTaken = new ArrayList<>();
        Schedule schedule = enrollmentRequest.getStudent().getSchedule();

        if (courses.size() == 1) {
            System.out.println("Course " + courses.get(0).getCourseCode() + " is passed from 'schedule collision ' test. ");
            canBeTaken.add(courses.get(0));
        } else {
            for (CompulsoryCourse course : courses) {
                for(CompulsoryCourse course1 : courses){
                    if(!Objects.equals(course.getCourseCode(), course1.getCourseCode())){
                        if (schedule.isCollided(course.getRandomSection(),course1.getRandomSection())){
                            System.out.println("Advisor "+ this.getLecturerName()+ " did not allowed to take course "+ course.getCourseCode()+ " because time conflict");
                            canBeTaken.remove(course);
                        }
                        else{
                            System.out.println("Course " + courses.get(0).getCourseCode() + " is passed from 'schedule collision ' test. ");
                            canBeTaken.add(course);
                        }
                    }
                }

            }
        }
        enrollmentRequest.setCourses(canBeTaken);
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
