package Model;

import jdk.jshell.spi.ExecutionControl;

public class Hippodrome {
	private static Hippodrome instance = null;
	
	private String nom;
	
	
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
