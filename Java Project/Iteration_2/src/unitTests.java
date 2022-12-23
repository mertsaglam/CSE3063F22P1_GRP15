package Iteration_2.src;

import org.testng.annotations.Test;

import java.util.ArrayList;

import  org.junit.jupiter.api.Assertions.*;


public class unitTests {
	
	@Test
	public void testAssertions() throws Exception {
		
		CourseRegistrationSimulation c = new CourseRegistrationSimulation();
		c.createCourses();
		
		ArrayList<Student> students = c.createRandomStudent(5);

		//assertEquals(5, students.size());
		//assertNotNull(students);
	}

}
