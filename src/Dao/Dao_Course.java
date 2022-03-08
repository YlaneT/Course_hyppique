package Dao;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dao_Course {
	// public int calculerNbVictoire(Cheval ch) throws
	// ExecutionControl.NotImplementedException {
	// throw new ExecutionControl.NotImplementedException("");
	// }
	
	public Dao_Course () {
	
	}
	
	public static void updateCourseNomName (Course course, String nouveauCourseNom) {
		course.setNom(nouveauCourseNom);
		// return Data.getInstance().set
	}
	
	public static boolean supprimerCourse (Course course) {
		return Data.getInstance().getCourses().remove(course);
	}
	
	public static void supprimerCourse (int index) {
		ArrayList<Course> data_courses     = Data.getInstance().getCourses();
		Course            courseASupprimer = data_courses.get(index);
		data_courses.remove(courseASupprimer);
	}
	
	public boolean createCourse (String nom, LocalDate date) {
		return Data.getInstance().getCourses().add(new Course(nom, date));
	}
	
	public boolean createCourse (String nom, LocalDate date, ArrayList<Cheval> chevaux, Cheval vainqueur) {
		return Data.getInstance().getCourses().add(new Course(nom, date, chevaux, vainqueur));
	}
	
	public Course getCourseByName (String courseNom) {
		ArrayList<Course> courseList = Data.getInstance().getCourses();
		for(Course course : courseList) {
			if (course.getNom().equalsIgnoreCase(courseNom)) {
				return course;
			}
		}
		return null;
	}
	
	public void addChevauxToCourse (Course course, ArrayList<Cheval> chevalList) {
		/*if (chevalList.size() >= 6)
			return false;*/
		/*for (Cheval cheval : chevalList) {
			Data.getInstance().getCourses().add(cheval);
		}*/
		//course.getChevaux().addAll(chevalList);
		course.setChevaux(chevalList);
	}
	
	public ArrayList<Course> getAllCourses () {
		return Data.getInstance().getCourses();
	}
}