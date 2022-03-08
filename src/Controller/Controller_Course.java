package Controller;

import Dao.Dao_Course;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Controller_Course {

	// CREATE
	public void creerCourse(String nom, LocalDate date, ArrayList<Cheval> chevaux, Cheval vainqueur) {
		Data.getInstance().getCourses().add(new Course(nom, date, chevaux, vainqueur));
	}

	public void creerCourse(String nom, LocalDate date) {
		Data.getInstance().getCourses().add(new Course(nom, date));
	}

	// READ
	public ArrayList<Course> getAllCourses() {
		return Data.getInstance().getCourses();
	}

	public Course getCourseByName(String courseNom) {
		ArrayList<Course> course = Data.getInstance().getCourses();
		for (int i = 0; i < course.size(); i++) {
			if (course.get(i).getNom().equals(courseNom)) {
				return course.get(i);
			}
		}
		return null;
	}

	// UPDATE
	public void modifierNom() {

	}

	public void modifierNom(Course course, String nouveauNomCourse) {
		Dao_Course.updateCourseNomName(course, nouveauNomCourse);

	}

	public void modifierDate() {

	}

	public void modifierChevaux() {

	}

	public void modifierVainqueur() {

	}

	// DESTROY
	public boolean supprimerCourse(Course course) {
		return Dao_Course.supprimerCourse(course);
	}

}
