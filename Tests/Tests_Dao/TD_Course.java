package Tests_Dao;

import Dao.Dao_Course;
import Dao.Dao_Hippodrome;
import Model.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TD_Course {
	
	Dao_Course     courseDao;
	Dao_Hippodrome hippodromeDao;
	Data           d;
	
	/*
	 * @BeforeEach public void init() { hippodromeDao = new Dao_Hippodrome();
	 * courseDao = new Dao_Course(); d = Data.getInstance(); }
	 */
	
	@Test
	public void getCourseTest () {
		hippodromeDao = new Dao_Hippodrome();
		courseDao = new Dao_Course();
		d = Data.getInstance();
		ArrayList<Course> course = courseDao.getAllCourse();
		assertNotNull(course);
	}
	
	@Test
	public void createCourseTestOK () {
		hippodromeDao = new Dao_Hippodrome();
		courseDao = new Dao_Course();
		d = Data.getInstance();
		
		LocalDate date = null;
		
		String  courseNom = "xhello";
		boolean res       = courseDao.createCourse(courseNom, date);
		assertTrue(res);
	}
	
	@Test
	public void updateCourseNomTestOk () {
		hippodromeDao = new Dao_Hippodrome();
		courseDao = new Dao_Course();
		d = Data.getInstance();
		
		LocalDate date = null;
		
		String courseNom = "xhello";
		Course course    = new Course("vhjfrbe", date);
		
		courseDao.updateCourseNomName(course, courseNom);
		
		assertEquals(courseNom, course.getNom());
	}
	
	@Test
	public void deleteCourseTestOK () {
		LocalDate date   = null;
		Course    course = new Course("xhello", date);
		courseDao = new Dao_Course();
		
		courseDao.getAllCourse().add(course);
		
		boolean res = courseDao.supprimerCourse(course);
		
		assertTrue(res);
	}
	
	@Test
	public void deleteCourseTestKO () {
		LocalDate date   = null;
		Course    course = new Course("xhello", date);
		courseDao = new Dao_Course();
		boolean res = courseDao.supprimerCourse(course);
		
		assertFalse(res);
	}
	
	@Test
	public void addChevalToCourseTestOK () {
		// String courseNom = "xhello";
		LocalDate date   = null;
		Course    course = new Course("xhello", date);
		courseDao = new Dao_Course();
		
		ArrayList<Cheval> chevalList = new ArrayList<>();
		for(int i = 0 ; i < 6 ; i++) {
			chevalList.add(new Cheval("grgr", 10));
		}
		courseDao.addChevauxToCourse(course, chevalList);
		
		// assertTrue(res);
		
		for(int i = 0 ; i < chevalList.size() ; i++) {
			assertEquals("grgr", course.getChevaux().get(i).getNom());
		}
	}
	
	
	@Test
	public void getCourseByNameTestOK () {
		String    courseNom = "vfjeh";
		LocalDate date      = null;
		courseDao = new Dao_Course();
		d = Data.getInstance();
		d.getCourses().add(new Course(courseNom, date));
		
		Course res = courseDao.getCourseByName(courseNom);
		assertEquals(courseNom, res.getNom());
	}
	
	@Test
	public void getCourseByNameTestKO () {
		String courseNom = "vfjeh";
		courseDao = new Dao_Course();
		Course res = courseDao.getCourseByName(courseNom);
		assertNull(res);
	}
}