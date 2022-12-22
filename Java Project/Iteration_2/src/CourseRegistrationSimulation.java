package Iteration_2.src;


import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CourseRegistrationSimulation {
    private ArrayList<Student> students;
    private ArrayList<CompulsoryCourse> courses;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Advisor> advisors;
    private int creditLimit;
    private ArrayList<EnrollmentRequest> enrollmentRequests;
    private ArrayList<String> errors;
    private double probToPassClass;
    private double probTo;
    private String[] names = {"Ahmet", "Ali", "Ayşe", "Fatma", "Kemal"};
    private String[] surnames = {"Kebapçı", "Çevik", "Öztürk", "Vural", "Ertekin"};
    private String[] letterGrades = {"AA", "BA", "BB", "CB", "CC", "DC"};
    private String term;

    public CourseRegistrationSimulation(ArrayList<Student> students, ArrayList<CompulsoryCourse> courses, ArrayList<Lecturer> lecturers, ArrayList<Advisor> advisors, int creditLimit) {
        this.students = students;
        this.courses = courses;
        this.lecturers = lecturers;
        this.advisors = advisors;
        this.creditLimit = creditLimit;
    }

    public CourseRegistrationSimulation() {
    }

    public void starSimulation() throws IOException {
        FileManager1 fileManager1 = new FileManager1();
        createParams();
        createStudents();
        createLecturer();

        createAdvisors();
        createCourses();
        matchStudentAdvisor();
        for (Student student : this.students) {
            ArrayList<CompulsoryCourse> appliedCourses = applyCourse(student);
            EnrollmentRequest enrollmentRequest = new EnrollmentRequest(appliedCourses, student);
            Advisor advisor = student.getAdvisor();
            checkSystemRequirements(enrollmentRequest);
            advisor.checkScheduleCollision(enrollmentRequest);
            System.out.println(this.term);
            System.out.println("Added Courses: "+ enrollmentRequest.getCourses().stream().map(CompulsoryCourse::getCourseCode).toList());
            student.calculateTranscriptAfter(enrollmentRequest,this.probToPassClass);
            fileManager1.writeToFile(student,("Java Project/Iteration_2/src/Outputs/"+ student.getStudentID()+".json"));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



    public void createCourses() {
        FileManager1 fileManager1 = new FileManager1();
        this.courses = fileManager1.readCourse("Java Project/Iteration_2/src/Jsons/compulsoryCourses.json");

    }

    public void createStudents() throws IOException {//done
        FileManager1 fileManager1 = new FileManager1();
        ArrayList<Student> students = fileManager1.readStudent("Java Project/Iteration_2/src/Jsons/Students");

        this.students = students;

    }
    public void createParams(){
        FileManager1 fileManager1 = new FileManager1();
        HashMap<String, String> params = fileManager1.readParams("Java Project/Iteration_2/src/input.json") ;
        this.probToPassClass =  Double.parseDouble(params.get("prob_to_fail_class"));
        this.term =  params.get("semester");

    }

    public void createLecturer() {
        FileManager1 fileManager1 = new FileManager1();
        this.lecturers = fileManager1.readLecturers("Java Project/Iteration_2/src/Jsons/lecturer.json");

    }

    public void createAdvisors() {
        Lecturer lecturer = new Lecturer();
        this.advisors = lecturer.lecturerToAdvisor(lecturers);
    }

    /*public void createAdvisor() {  // no need for iteration 1
        FileManager fileManager = new FileManager();
        this.advisors = fileManager.readAdvisor("/Users/omerfarukbulut/Downloads/student1.json");
    }*/

    public void matchStudentAdvisor() {
        Random random = new Random();
        int size = advisors.size();
        for (Student student : this.students) {
            Advisor advisor = this.advisors.get(random.nextInt(size));
            student.setAdvisor(advisor);
            advisor.appendStudent(student.getStudentID());

        }
    }

    public ArrayList<CompulsoryCourse> applyCourse(Student student) {
        ArrayList<CompulsoryCourse> courses = this.courses;
        Random random = new Random();
        int appliedCourseNumber = random.nextInt(1, 10);
        ArrayList<CompulsoryCourse> appliedCourses = new ArrayList<CompulsoryCourse>();
        for (int i = 0; i < appliedCourseNumber; i++) {
            CompulsoryCourse randomCourse = courses.get(random.nextInt(courses.size()));
            appliedCourses.add(randomCourse);
            System.out.println(student.getStudentID() + " applied for " + randomCourse.getCourseCode());
            // Log


        }

        return appliedCourses;


    }

    public void checkSystemRequirements(EnrollmentRequest enrollmentRequest) {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        registrationSystem.checkCourseIsTakenBefore(enrollmentRequest);
        registrationSystem.checkPrerequisites(enrollmentRequest);
        registrationSystem.isOpenedThisTerm(enrollmentRequest, this.term);

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

    public boolean passOrFail() {
        Random random = new Random();
        return random.nextDouble() < this.probToPassClass;
    }


    public void createRandomStudent(int size) throws IOException {
        FileManager1 fileManager1 = new FileManager1();
        ArrayList<Student> students1 = new ArrayList<Student>();
        for (int i = 0; i < size; i++) {
            students1.add(new Student(names[new Random().nextInt(names.length - 1)], surnames[new Random().nextInt(surnames.length - 1)], new Transcript(), new Transcript(), new Schedule(), new Advisor(), "2020"));
            students1.get(i).createStudentID();
            Transcript transcriptBefore = students1.get(i).getTranscriptBefore();
            transcriptBefore.setTakenCourses(getRandomCourse(courses));

            HashMap<String, String> courseGrades = new HashMap<String, String>();
            int takenCredit = 0;
            for (int j = 0; j < transcriptBefore.getTakenCourses().size(); j++) {
                takenCredit += transcriptBefore.getTakenCourses().get(j).getCredit();
                transcriptBefore.setTakenCredit(takenCredit);

                courseGrades.put(transcriptBefore.getTakenCourses().get(j).getCourseCode(), letterGrades[new Random().nextInt(letterGrades.length)]);
            }
            transcriptBefore.setCourseGrades(courseGrades);
            
            transcriptBefore.setGpa(transcriptBefore.calculateGpa());
            fileManager1.writeToFile(students1.get(i),"Java Project/Iteration_2/src/Jsons/Students/"+students.get(i).getStudentID()+".json");

        }

    }

//    public void writeToJson() {
//    	JsonArrayBuilder builder = Json.createArrayBuilder();
//
//    	for(int i = 0; i < students.size(); i++) {
//        		     builder.add(Json.createObjectBuilder()
//        		         .add("studentID", students.get(i).getStudentID())
//        		         .add("studentName", students.get(i).getStudentName())
//        		         .add("studentSurname", students.get(i).getStudentSurname())
//        		         .add("transcriptBefore", students.get(i).getTranscriptBefore().toString())
//        		         .add("transcriptAfter", students.get(i).getTranscriptAfter().toString())
//        		         .add("schedule", students.get(i).getSchedule().toString())
//        		         .add("advisor", students.get(i).getAdvisor().toString())
//        		         .add("enrolledYear", students.get(i).getEnrolledYear()))
//        		     .build();
//    	}
//    	//JsonArray array = builder.build();
//
//    	try {
//    		JsonWriter writer = (JsonWriter) Json.createWriter(new FileOutputStream("deneme.json"));
//    		//writer.writeArray(array);
//    		writer.close();
//
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    }

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
