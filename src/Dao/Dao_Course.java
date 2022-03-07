package Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Cheval;
import Model.Course;
import Model.Data;

public class Dao_Course {
	// public int calculerNbVictoire(Cheval ch) throws
	// ExecutionControl.NotImplementedException {
	// throw new ExecutionControl.NotImplementedException("");
	// }
	
	public Dao_Course() {
	
	}
	
	public static void updateCourseNomName(Course course, String nouveauCourseNom) {
		course.setNom(nouveauCourseNom);
		// return Data.getInstance().set
	}
	
	public static boolean supprimerCourse(Course course) {
		return Data.getInstance().getCourses().remove(course);
	}
	
	public boolean createCourse(String nom, LocalDate date) {
		return Data.getInstance().getCourses().add(new Course(nom, date));
	}
	
	public boolean createCourse(String nom, LocalDate date, ArrayList<Cheval> chevaux, Cheval vainqueur) {
		return Data.getInstance().getCourses().add(new Course(nom, date, chevaux, vainqueur));
	}
	
	public Course getCourseByName(String courseNom) {
		ArrayList<Course> courseList = Data.getInstance().getCourses();
		for(Course course : courseList) {
			if (course.getNom().equals(courseNom)) {
				return course;
			}
		}
		return null;
	}
	
	public void addChevauxToCourse(Course course, ArrayList<Cheval> chevalList) {
		/*if (chevalList.size() >= 6)
			return false;*/
		/*for (Cheval cheval : chevalList) {
			Data.getInstance().getCourses().add(cheval);
		}*/
		//course.getChevaux().addAll(chevalList);
		course.setChevaux(chevalList);
	}
	
	public ArrayList<Course> getAllCourse() {
		return Data.getInstance().getCourses();
	}
}