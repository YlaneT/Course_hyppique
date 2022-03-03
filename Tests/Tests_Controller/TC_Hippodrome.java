package Tests_Controller;

import Controller.Controller_Course;
import Controller.Controller_Hippodrome;
import Model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

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
		String    courseNom = "course test blblblbllblblblblbblblblbl";
		LocalDate date      = LocalDate.now();
		
		// WHEN
		courseController.creerCourse(courseNom, date);
		
		// THEN
		int nbrCourse = Data.getInstance().getCourses().size();
		System.out.println(nbrCourse);
		assertEquals(1, nbrCourse);
		System.out.println(d.getCourses().get(nbrCourse - 1).getNom());
		assertEquals(courseNom, d.getCourses().get(nbrCourse - 1).getNom());
	}
}
