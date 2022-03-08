package Controller;

import Dao.Dao_Cheval;
import Dao.Dao_Course;
import Model.*;

import java.time.LocalDate;
import java.util.*;

public class Controller_Course {
	Dao_Course dao = new Dao_Course();
	
	
	// CREATE
	public void creerCourse (String nom, LocalDate date, ArrayList<Cheval> chevaux, Cheval vainqueur) {
		Data.getInstance().getCourses().add(new Course(nom, date, chevaux, vainqueur));
	}
	
	public void creerCourse (String nom, LocalDate date) {
		Data.getInstance().getCourses().add(new Course(nom, date));
	}
	
	// READ
	public void afficherCourses () {
	
	}
	
	public Course getCourseByName(String courseNom) {
		ArrayList<Course> course = Data.getInstance().getCourses();
		for (int i = 0; i < course.size(); i++) {
			if (course.get(i).getNom().equalsIgnoreCase(courseNom)) {
				return course.get(i);
			}
		}
		
		return null;
	}
	
	public ArrayList<Course> coursesTriées () {
		dao.getAllCourse().sort(Comparator.comparing(Course::getDate));
		ArrayList<Course> data_courses = Data.getInstance().getCourses();
		ArrayList<Course> dixCourses = new ArrayList<>();
		for(int i = 0 ; i < Math.min(10, data_courses.size()); i++) {
			dixCourses.add(data_courses.get(i));
		}
		return dixCourses;
	}
	
	// UPDATE
	public void modifierNom () {
	
	}
	
	public void modifierNom(Course course, String nouveauNomCourse) {
		Dao_Course.updateCourseNomName(course, nouveauNomCourse);
		
	}
	
	public void modifierDate () {
	
	}
	
	public void modifierChevaux () {
	
	}
	
	public void modifierVainqueur () {
	
	}
	
	// DESTROY
	public boolean supprimerCourse(Course course) {
		return Dao_Course.supprimerCourse(course);
	}
}
