package Tests_Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import Controller.Controller_Course;
import Controller.Controller_Hippodrome;
import Model.Course;
import Model.Data;

public class TC_Course {

	Controller_Hippodrome hippodrome_controller;
	Controller_Course course_controller;

	@Test
	public void creerCourseTestOK() {
		hippodrome_controller = new Controller_Hippodrome();
		course_controller = new Controller_Course();
		Data d = Data.getInstance();
		String nameCircuit = "urguirzehguizerhiu";
		LocalDate date = LocalDate.now();
		course_controller.creerCourse(nameCircuit, date);
		int nbCourse = d.getCourses().size();
		assertEquals(nameCircuit, d.getCourses().get(nbCourse - 1).getNom());
	}

	@Test
	public void updateCourseNomTestOK() {
		String newNameCircuit = "urguirzehguizerhiu";
		LocalDate date = LocalDate.now();
		Data d = Data.getInstance();
		Course course = new Course("hguhrtzigzhrti", date);
		d.getCourses().add(course);
		hippodrome_controller = new Controller_Hippodrome();
		course_controller = new Controller_Course();
		course_controller.modifierNom(course, newNameCircuit);
		int nbCourse = d.getCourses().size();
		assertEquals(newNameCircuit, d.getCourses().get(nbCourse - 1).getNom());
	}

	@Test
	public void deleteCourseTestOK() {
		hippodrome_controller = new Controller_Hippodrome();
		course_controller = new Controller_Course();
		LocalDate date = LocalDate.now();
		Data d = Data.getInstance();
		Course course = new Course("reihre", date);
		d.getCourses().add(course);
		boolean result = course_controller.supprimerCourse(course);
		assertTrue(result);
	}

	@Test
	public void deleteCourseNotExistTestKO() {
		hippodrome_controller = new Controller_Hippodrome();
		course_controller = new Controller_Course();
		LocalDate date = LocalDate.now();
		Course course = new Course("vff", date);
		boolean result = course_controller.supprimerCourse(course);
		assertFalse(result);
	}
	
	@Test
	public void getCourseByNameOK() {
		hippodrome_controller = new Controller_Hippodrome();
		course_controller = new Controller_Course();
		LocalDate date = LocalDate.now();
		Data d = Data.getInstance();
		String courseNom = "rrrr";
		Course course = new Course(courseNom, date);
		d.getCourses().add(course);

		Course result = course_controller.getCourseByName(courseNom);

		assertNotNull(result);
		assertEquals(courseNom, result.getNom());
	}
	
	@Test
	public void getCourseWhenNotExistByNameKO() {
		hippodrome_controller = new Controller_Hippodrome();
		course_controller = new Controller_Course();
		String courseNom = "regrtge";

		Course result = course_controller.getCourseByName(courseNom);
		assertNull(result);
	}
	
	
}
