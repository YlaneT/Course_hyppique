package Tests_Controller;

import Controller.Controller_Course;
import Controller.Controller_Hippodrome;
import Model.Course;
import Model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TC_Hippodrome {
	Controller_Hippodrome hippodromeController;
	Controller_Course courseController;
	Data d;

	@BeforeEach
	void init() {
		d = Data.getInstance();
		hippodromeController = new Controller_Hippodrome();
		courseController = new Controller_Course();
	}

	@Test
	public void creerCourseTestOK() {
		// GIVEN
		d.setCourses(new ArrayList<>());
		String courseNom = "helloThere";
		LocalDate date = LocalDate.now();

		// WHEN
		courseController.creerCourse(courseNom, date);

		// THEN
		int indexCourse = d.getCourses().size() - 1;
		Course nvleCourse = d.getCourses().get(indexCourse);
		assertTrue(d.getCourses().size() == 1 && courseNom.equalsIgnoreCase(nvleCourse.getNom())
				&& nvleCourse.getDate().equals(date));
	}

	@Test
	public void updateNomCourseTestOK() {
		d.setCourses(new ArrayList<>());
		String nouveauNomCourse = "helloTHere";
		LocalDate date = LocalDate.now();
		Course course = new Course("anthony", date);
		d.getCourses().add(course);

		courseController.modifierNom(course, nouveauNomCourse);
		int nbrcourse = d.getCourses().size();
		assertEquals(1, nbrcourse);
		assertEquals(nouveauNomCourse, d.getCourses().get(nbrcourse - 1).getNom());
	}

	@Test
	public void deleteCourseTestOK() {
		LocalDate date = LocalDate.now();
		Course course = new Course("helloTHere", date);
		d.getCourses().add(course);

		boolean res = courseController.supprimerCourse(course);
		int nbrCourse = d.getCourses().size();
		// assertEquals(0, nbrCourse);
		assertTrue(res);
	}

	@Test
	public void deleteCourseNonExistantTestKO() {
		LocalDate date = LocalDate.now();
		Course course = new Course("helloTHere", date);

		boolean result = courseController.supprimerCourse(course);
		int nbrCourse = d.getCourses().size();
		// assertEquals(0, nbrCourse);
		assertFalse(result);
	}

	@Test
	public void getCourseByNameFirstOK() {
		d.setCourses(new ArrayList<Course>());
		String courseNom = "helloTHere";
		LocalDate date = LocalDate.now();
		Course course = new Course(courseNom, date);
		d.getCourses().add(course);

		Course result = courseController.getCourseByName(courseNom);
		assertNotNull(result);
		assertEquals(courseNom, result.getNom());
	}

	@Test
	public void getCourseByNameFirstNotExist() {
		assertNull(courseController.getCourseByName("helloTHere2"));
	}
}