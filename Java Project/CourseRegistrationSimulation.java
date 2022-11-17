import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CourseRegistrationSimulation {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Advisor> advisors;
    private Semester semester;
    private int creditLimit;
    private ArrayList<EnrollmentRequest> enrollmentRequests;

    public CourseRegistrationSimulation(ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Lecturer> lecturers, ArrayList<Advisor> advisors, Semester semester, int creditLimit) {
        this.students = students;
        this.courses = courses;
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
        createLecturer();
        createSemester();
        createEnrollementRequest();
        checkSystemRequirements();
        setTranscriptAfter();

    }

    public void readParameters() {
        FileManager fileManager = new FileManager();

    }

    public void createStudents() {//done
        FileManager1 fileManager1 = new FileManager1();
        this.students = fileManager1.readStudent("/Users/omerfarukbulut/Downloads/student1.json");

    }

    //CREATE COMPULSARY AND CREATE ELECTIVE COURSES
    public void createSemester() {
        FileManager1 fileManager1 = new FileManager1();
        this.semester = fileManager1.readSemester("/Users/omerfarukbulut/Downloads/student1.json");


    }

    public void createLecturer() {
        FileManager1 fileManager1 = new FileManager1();
        this.lecturers = fileManager1.readLecturers("/Users/omerfarukbulut/Downloads/student1.json");

    }

    /*public void createAdvisor() {  // no need for iteration 1
        FileManager fileManager = new FileManager();
        this.advisors = fileManager.readAdvisor("/Users/omerfarukbulut/Downloads/student1.json");
    }*/

    public void matchStudentAdvisor() {
        for (Student student : this.students) {
            student.setAdvisor(this.advisors.get(ThreadLocalRandom.current().nextInt(0, this.advisors.size() + 1)));
        }
    }

    public void createEnrollementRequest() {
        for (Student student : this.students) {
            ArrayList<Course> randomCourse = getRandomCourse(this.courses);
            HashMap<String, Schedule> scheduleWithCourse = new HashMap<>();
            for (Course course : randomCourse) {
                scheduleWithCourse.put(course.getCourseCode(), course.getCourseSection().getSchedule());
            }//CAN NOT HANDLE HOW TO REACH COURSE SECTION CLASS SCHEDULE POSTPONE TO LATER

            EnrollmentRequest enrollmentRequest = new EnrollmentRequest(randomCourse, student, scheduleWithCourse);

        }

    }

    public void checkSystemRequirements() {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        for (EnrollmentRequest enrollmentRequest1 : this.enrollmentRequests) {
            registrationSystem.getTotalCredit(enrollmentRequest1);
            registrationSystem.checkCourseIsTakenBefore(enrollmentRequest1);
            registrationSystem.checkPrerequisites(enrollmentRequest1);
            checkCourseIsOpened(enrollmentRequest1);
        }

    }


    public Schedule combineSchedule(ArrayList<Schedule> schedules) {
        Schedule combinedSchedule = new Schedule();
        HashMap<String, ArrayList<String>> temp = new HashMap<String, ArrayList<String>>();
        for (Schedule schedule : schedules) {
            temp.putAll(schedule.getCourseDayHour());
        }
        combinedSchedule.setCourseDayHour(temp);
        return combinedSchedule;
    }

    public ArrayList<Course> getRandomCourse(ArrayList<Course> list) {
        Random rand = new Random(); // object of Random class.

        //temprory list to hold selected items.
        ArrayList<Course> tempList = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(list.size()); i++) {
            int randomIndex = rand.nextInt(list.size());
            tempList.add(list.get(randomIndex));
        }
        return tempList;
    }

    public void setTranscriptAfter() {
        for (EnrollmentRequest enrollmentRequest : this.enrollmentRequests) {
            ArrayList<Course> courses = enrollmentRequest.getCourses();
            Student student = enrollmentRequest.getStudent();
            ArrayList<String> passedCourses = new ArrayList<String>();
            Random random = new Random();
            Transcript transcript = student.getTranscriptBefore();
            for (Course course : courses) {
                if (!enrollmentRequest.getResult().containsKey(course.getCourseCode())) {
                    passedCourses.add(course.getCourseCode());
                }
            }
            HashMap<String, Float> courseGrades = new HashMap<String, Float>();
            for (String courseCode : passedCourses) {
                courseGrades.put(courseCode, random.nextFloat(100));
                transcript.addTakenCourse(getCoursebyCourseCode(courseCode));
                transcript.removeCourse(getCoursebyCourseCode(courseCode));
            }
            int totalCredit = enrollmentRequest.getTotalCredit() + student.getTranscriptBefore().getTakenCredit();
            Transcript transcript1 = new Transcript(courseGrades, student, random.nextFloat(4), totalCredit, transcript.getTakenCourses(), transcript.getNotTakenCourses());
            student.setTranscriptAfter(transcript1);
        }
    }

    public Course getCoursebyCourseCode(String courseCode) {
        for (Course course : this.courses) {
            if (course.getCourseCode().equals(courseCode))
                return course;

        }
        return null;
    }
/*
    public ArrayList<ElectiveCourse> getRandomElectiveCourses(ArrayList<ElectiveCourse> list) {
        Random rand = new Random(); // object of Random class.

        //temprory list to hold selected items.
        ArrayList<ElectiveCourse> tempList = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(list.size()); i++) {
            int randomIndex = rand.nextInt(list.size());
            tempList.add(list.get(randomIndex));
        }
        return tempList;
    }*/

    public void printArraylist(ArrayList<Student> arr) {
        for (int i = 0; i < arr.size(); i++) {
            // Assuming arr is an ArrayList object
            Object current = arr.get(i).toString();
            System.out.println(current);
            // Do something with the current element here
        }

    }

    public void checkCourseIsOpened(EnrollmentRequest enrollmentRequest) {
        Semester semester = this.semester;
            for(Course course: enrollmentRequest.getCourses()){
                if(! semester.getOpenedCourse().contains(course)){
                    HashMap<String,String> temp = new HashMap<String,String>();
                    temp.put(course.getCourseCode(),"NotOpened");
                    enrollmentRequest.appendResult(temp);
                }

        }


    }
}
