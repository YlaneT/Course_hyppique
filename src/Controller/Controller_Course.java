package Controller;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Controller_Course {
	
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
	
	// UPDATE
	public void modifierNom () {
	
	}
	
	public void modifierDate () {
	
	}
	
	public void modifierChevaux () {
	
	}
	
	public void modifierVainqueur () {
	
	}
	
	// DESTROY
	public void supprimerCourse () {
	
	}
}
