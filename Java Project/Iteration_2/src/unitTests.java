package Iteration_2.src;

import org.testng.annotations.Test;

import java.util.ArrayList;


public class unitTests {
	
	@Test
	public void testAssertions() throws Exception {
		
		CourseRegistrationSimulation c = new CourseRegistrationSimulation();
		c.createCourses();
		
		//ArrayList<Student> students = c.createRandomStudent(5);
		
		/*assertTrue(students.size()==5);
		assertNotNull(students);*/
	}

}
