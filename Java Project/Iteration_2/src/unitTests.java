package Iteration_2/src;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class unitTests {
	
	@Test
	public void testAssertions() throws Exception {
		
		CourseRegistrationSimulation c = new CourseRegistrationSimulation();
		c.createCourses();
		
		ArrayList<Student> students = c.createRandomStudent(5);
		
		assertTrue(students.size()==5);
		assertNotNull(students);
	}

}
