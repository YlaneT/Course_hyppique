package Model;

public class Hippodrome {
	private static Hippodrome instance = null;
	
	private String            nom;
	
	public Hippodrome () {
		this.nom = "Ynov Courses Hippiques";
	}
	
	public static Hippodrome getInstance () {
		if (instance == null) {
			instance = new Hippodrome();
		}
		return instance;
	}
	
	// GETTERS & SETTERS
	public String getNom () {
		return nom;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
	
	public String toString () {
		return "HIPPODROME { NOM : " + getNom() + " }";
	}
}
