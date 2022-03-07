package Model;

import java.util.ArrayList;

public class Hippodrome {
	private static Hippodrome instance = null;
	
	private String            nom;
	private ArrayList<Course> courses;
	
	
	public Hippodrome () {
		this.nom = "Ynov Courses Hippiques";
	}
	
	public static Hippodrome getInstance () {
		if (instance == null) {
			instance = new Hippodrome();
		}
		return instance;
	}
	
	private void afficherResultatsDixCourses () {
	
	}
	
	// GETTERS & SETTERS
	public String getNom () {
		return nom;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
}
