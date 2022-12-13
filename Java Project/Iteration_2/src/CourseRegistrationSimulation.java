package Iteration_2.src;



import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CourseRegistrationSimulation {
    private ArrayList<Student> students;
    private ArrayList<CompulsoryCourse> courses;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Advisor> advisors;
    private int creditLimit;
    private ArrayList<EnrollmentRequest> enrollmentRequests;
    private ArrayList<String> errors ;

    public CourseRegistrationSimulation(ArrayList<Student> students, ArrayList<CompulsoryCourse> courses, ArrayList<Lecturer> lecturers, ArrayList<Advisor> advisors,  int creditLimit) {
        this.students = students;
        this.courses = courses;
        this.lecturers = lecturers;
        this.advisors = advisors;
        this.creditLimit = creditLimit;
    }

    public CourseRegistrationSimulation() {
    }

    public void starSimulation() {
        createCourses();
        createStudents();
        createLecturer();
        createEnrollmentRequest();
        printOutputs();


    }

    public void readParameters() {
        FileManager fileManager = new FileManager();

    }

    public void createCourses() {
        FileManager1 fileManager1 = new FileManager1();
        this.courses = fileManager1.readCourse("Jsons/compulsoryCourses.json");

    }

    public void createStudents() {//done
        FileManager1 fileManager1 = new FileManager1();
        this.students = fileManager1.readStudent("Jsons/student.json");

    }

    public void createLecturer() {
        FileManager1 fileManager1 = new FileManager1();
        this.lecturers = fileManager1.readLecturers("Jsons/lecturer.json");

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

    public void createEnrollmentRequest() {
        for (Student student : this.students) {
            ArrayList<CompulsoryCourse> randomCourse = this.courses;
            HashMap<String, Schedule> scheduleWithCourse = new HashMap<>();
            for (CompulsoryCourse course : randomCourse) {
          //      scheduleWithCourse.put(course.getCourseCode(), course.getSchedule());
            }//CAN NOT HANDLE HOW TO REACH COURSE SECTION CLASS SCHEDULE POSTPONE TO LATER

            ArrayList<EnrollmentRequest> enrollmentRequests = new ArrayList<EnrollmentRequest>();
            enrollmentRequests.add(new EnrollmentRequest(randomCourse, student, scheduleWithCourse));
            this.enrollmentRequests = enrollmentRequests;

        }

    }

    /*public void checkSystemRequirements() {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        for (EnrollmentRequest enrollmentRequest1 : this.enrollmentRequests) {
            registrationSystem.getTotalCredit(enrollmentRequest1);
            registrationSystem.checkCourseIsTakenBefore(enrollmentRequest1);
            registrationSystem.checkPrerequisites(enrollmentRequest1);
            checkCourseIsOpened();

        }

    }*/


    public Schedule combineSchedule(ArrayList<Schedule> schedules) {
        Schedule combinedSchedule = new Schedule();
        HashMap<String, ArrayList<String>> temp = new HashMap<String, ArrayList<String>>();
        for (Schedule schedule : schedules) {
            temp.putAll(schedule.getCourseDayHour());
        }
        combinedSchedule.setCourseDayHour(temp);
        return combinedSchedule;
    }

    public ArrayList<CompulsoryCourse> getRandomCourse(ArrayList<CompulsoryCourse> list) {
        Random random = new Random();
        ArrayList<CompulsoryCourse> newList = new ArrayList<CompulsoryCourse>();

        for (int i = 0; i < random.nextInt(list.size()); i++) {
            int randomIndex = random.nextInt(list.size());
            newList.add(list.get(randomIndex));

        }
        return newList;
    }


    public void setTranscriptAfter() {
        for (EnrollmentRequest enrollmentRequest : this.enrollmentRequests) {
            ArrayList<CompulsoryCourse> courses = enrollmentRequest.getCourses();
            Student student = enrollmentRequest.getStudent();
            ArrayList<String> passedCourses = new ArrayList<String>();
            Random random = new Random();
            Transcript transcript = student.getTranscriptBefore();
            for (CompulsoryCourse course : courses) {
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
            Transcript transcript1 = new Transcript(courseGrades, /*student,*/ random.nextFloat()*4, totalCredit, transcript.getTakenCourses(), transcript.getNotTakenCourses());
            student.setTranscriptAfter(transcript1);
        }
    }

    public CompulsoryCourse getCoursebyCourseCode(String courseCode) {
        for (CompulsoryCourse course : this.courses) {
            if (course.getCourseCode().equals(courseCode))
                return course;

        }
        return null;
    }

    public void printOutputs() {

        System.out.println(this.errors);
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

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    /*public void checkCourseIsOpened() {
        Semester semester = this.semester;
        for (EnrollmentRequest enrollmentRequest : this.enrollmentRequests) {
            for (CompulsoryCourse course : enrollmentRequest.getCourses()) {
                if (!semester.getOpenedCourse().contains(course)) {

                    enrollmentRequest.setError(enrollmentRequest.getStudent().getStudentName() + course.getCourseCode() + " not opened");
                    ArrayList<String> errorsBefore = new ArrayList<String>();
                    errorsBefore.add(enrollmentRequest.getStudent().getStudentName() + course.getCourseCode() + " not opened");
                    this.errors = errorsBefore;
                }

            }
        }

    }*/
}
