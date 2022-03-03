package Model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Course {
	
	private        String            nom;
	private        LocalDate         date;
	private        ArrayList<Cheval> chevaux;
	private        Cheval            vainqueur;
	
	public Course (String nom, LocalDate date, ArrayList<Cheval> chevaux, Cheval vainqueur) {
		this.nom = nom;
		this.date = date;
		this.chevaux = chevaux;
		this.vainqueur = vainqueur;
	}
	
	public Course (String nom, LocalDate date) {
		this.nom = nom;
		this.date = date;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder("COURSE { ");
		sb.append("NOM : " + nom);
		sb.append(",\tDATE : " + date + "\n");
		sb.append(",\tCHEVAUX : [ ");
		String delim = "";
		for(Cheval ch : chevaux) {
			sb.append(delim + ch.getNom() + " ");
			delim = "/ ";
		}
		sb.append(" ]\n");
		sb.append("VAINQUEUR : " + vainqueur);
		sb.append(" }\n");
		return sb.toString();
	}
	
	public String getNom () {
		return nom;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
	
	public LocalDate getDate () {
		return date;
	}
	
	public void setDate (LocalDate date) {
		this.date = date;
	}
	
	public ArrayList<Cheval> getChevaux () {
		return chevaux;
	}
	
	public void setChevaux (ArrayList<Cheval> chevaux) {
		this.chevaux = chevaux;
	}
	
	public Cheval getVainqueur () {
		return vainqueur;
	}
	
	public void setVainqueur (Cheval vainqueur) {
		this.vainqueur = vainqueur;
	}
	
	public boolean equals(Course course) {
		return this.nom.equals(course.nom);
	}
}
