import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CourseRegistrationSimulation {
    private ArrayList<Student> students;
    private ArrayList<CompulsaryCourse> compulsaryCourses;
    private ArrayList<ElectiveCourse> electiveCourses;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Advisor> advisors;
    private Semester semester;
    private int creditLimit;
    private ArrayList<EnrollmentRequest> enrollmentRequests;

    public CourseRegistrationSimulation(ArrayList<Student> students, ArrayList<CompulsaryCourse> compulsaryCourses, ArrayList<ElectiveCourse> electiveCourses, ArrayList<Lecturer> lecturers, ArrayList<Advisor> advisors, Semester semester, int creditLimit) {
        this.students = students;
        this.compulsaryCourses = compulsaryCourses;
        this.electiveCourses = electiveCourses;
        this.lecturers = lecturers;
        this.advisors = advisors;
        this.semester = semester;
        this.creditLimit = creditLimit;
    }

    public CourseRegistrationSimulation() {
    }

    public void starSimulation() {
        readParameters();
        createStudents();
        createAdvisor();
        createLecturer();
        createSemester();
        createEnrollementRequest();
        checkSystemRequirements();

    }

    public void readParameters() {
        FileManager fileManager = new FileManager();
        // not finalized
    }

    public void createStudents() {
        FileManager fileManager = new FileManager();
        this.students = fileManager.readStudent("/Users/omerfarukbulut/Downloads/student1.json");
        System.out.println((Arrays.toString(this.students.toArray())));

    }

    //CREATE COMPULSARY AND CREATE ELECTIVE COURSES
    public void createSemester() {
        FileManager fileManager = new FileManager();
        // not finalized

    }

    public void createLecturer() {
        FileManager fileManager = new FileManager();
        try {
            this.lecturers = fileManager.readLecturer("/Users/omerfarukbulut/Downloads/student1.json");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void createAdvisor() {
        FileManager fileManager = new FileManager();
        this.advisors = fileManager.readAdvisor("/Users/omerfarukbulut/Downloads/student1.json");
    }

    public void matchStudentAdvisor() {
        for (Student student : this.students) {
            student.setAdvisor(this.advisors.get(ThreadLocalRandom.current().nextInt(0, this.advisors.size() + 1)));
        }
    }

    public void createEnrollementRequest() {
        for (Student student : this.students) {
            ArrayList<CompulsaryCourse> randomCompulsaryCourses = getRandomCompulsaryCourses(this.compulsaryCourses);
            ArrayList<ElectiveCourse> randomElectiveCourses = getRandomElectiveCourses(this.electiveCourses);
            ArrayList<Schedule> schedules = new ArrayList<>();
            HashMap<String,Schedule> scheduleWithCourse = new HashMap<>();
            for (ElectiveCourse electiveCourse : randomElectiveCourses) {
                scheduleWithCourse.put(electiveCourse.getCourseCode(),electiveCourse.getSchedule());
            }//CAN NOT HANDLE HOW TO REACH COURSE SECTION CLASS SCHEDULE POSTPONE TO LATER

            EnrollmentRequest enrollmentRequest = new EnrollmentRequest(randomCompulsaryCourses, randomElectiveCourses, student, scheduleWithCourse);

        }

    }

    public void checkSystemRequirements() {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        for(EnrollmentRequest enrollmentRequest1 : this.enrollmentRequests){
            registrationSystem.getTotalCredit(enrollmentRequest1);
            registrationSystem.checkCourseIsTakenBefore(enrollmentRequest1);
            registrationSystem.checkPrerequisites(enrollmentRequest1);
            registrationSystem.checkTimeConflict(enrollmentRequest1);
        }

    }

    public Schedule combineSchedule(ArrayList<Schedule> schedules) {
        Schedule combinedSchedule = new Schedule();
        HashMap<String, String[]> temp = new HashMap<String, String[]>();
        for (Schedule schedule : schedules) {
            temp.putAll(schedule.getCourseDayHour());
        }
        combinedSchedule.setCourseDayHour(temp);
        return combinedSchedule;
    }

    public ArrayList<CompulsaryCourse> getRandomCompulsaryCourses(ArrayList<CompulsaryCourse> list) {
        Random rand = new Random(); // object of Random class.

        //temprory list to hold selected items.
        ArrayList<CompulsaryCourse> tempList = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(list.size()); i++) {
            int randomIndex = rand.nextInt(list.size());
            tempList.add(list.get(randomIndex));
        }
        return tempList;
    }

    public ArrayList<ElectiveCourse> getRandomElectiveCourses(ArrayList<ElectiveCourse> list) {
        Random rand = new Random(); // object of Random class.

        //temprory list to hold selected items.
        ArrayList<ElectiveCourse> tempList = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(list.size()); i++) {
            int randomIndex = rand.nextInt(list.size());
            tempList.add(list.get(randomIndex));
        }
        return tempList;
    }

    public void printArraylist(ArrayList<Student> arr) {
        for (int i = 0; i < arr.size(); i++) {
            // Assuming arr is an ArrayList object
            Object current = arr.get(i).toString();
            System.out.println(current);
            // Do something with the current element here
        }

    }
}
