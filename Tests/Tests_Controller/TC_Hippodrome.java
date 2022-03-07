package Tests_Controller;

import Controller.Controller_Course;
import Controller.Controller_Hippodrome;
import Model.Course;
import Model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class TC_Hippodrome {
	Controller_Hippodrome hippodromeController;
	Controller_Course     courseController;
	Data                  d;
	
	@BeforeEach
	void init () {
		d = Data.getInstance();
		hippodromeController = new Controller_Hippodrome();
		courseController = new Controller_Course();
	}
	
	@Test
	public void creerCourseTestOK () {
		// GIVEN
		String    courseNom = "helloThere";
		LocalDate date      = LocalDate.now();
		
		// WHEN
		courseController.creerCourse(courseNom, date);
		
		// THEN
		int    indexCourse = d.getCourses().size() - 1;
		Course nvleCourse  = d.getCourses().get(indexCourse);
		assertTrue(d.getCourses().size() == 1 && courseNom.equals(nvleCourse.getNom()) && nvleCourse.getDate().equals(date));
	}
}
