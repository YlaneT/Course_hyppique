package Model;

import java.util.ArrayList;

public class Cheval {
	private        String            nom;
	private        int               age;
	private        int               nbVictoire;
	
	private Cheval (String nom, int age, int nbVictoire) {
		this.nom = nom.strip();
		this.age = age;
		this.nbVictoire = nbVictoire;
	}
	
	public Cheval (String nom, int age) {
		this(nom, age, 0);
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder("CHEVAL { ");
		sb.append("NOM : " + nom);
		sb.append(",\tAGE : " + age);
		sb.append(",\tVICTOIRES : " + nbVictoire);
		sb.append(" }");
		return sb.toString();
	}
	
	public String getNom () {
		return nom;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
	
	public int getAge () {
		return age;
	}
	
	public void setAge (int age) {
		this.age = age;
	}
	
	public int getNbVictoire () {
		return nbVictoire;
	}
	
	public void setNbVictoire (int nbVictoire) {
		this.nbVictoire = nbVictoire;
	}
}
