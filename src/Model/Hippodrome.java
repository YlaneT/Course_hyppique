package Model;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

public class Hippodrome {
	private static Hippodrome instance = null;
	
	private String nom;
	private ArrayList<Course> courses;
	
	
	public static Hippodrome getInstance (){
		if (instance == null){
			instance = new Hippodrome();
		}
		return instance;
	}
	
	public Hippodrome () {
		this.nom = "Ynov Courses Hippiques";
	}
	
	private void afficherResultatsDixCourses () {
	
	}
	
	public int calculerNbVictoire(Cheval ch) throws ExecutionControl.NotImplementedException {
		throw new ExecutionControl.NotImplementedException("");
	}
}
