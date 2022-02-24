package Model;

import java.util.ArrayList;
import java.util.Date;

public class Course {
	private String            nom;
	private Date              date;
	private ArrayList<Cheval> chevaux;
	
	public Course (String nom, Date date, ArrayList<Cheval> chevaux) {
		this.nom = nom;
		this.date = date;
		this.chevaux = chevaux;
	}
	
	public String toString () {
		return null;
	}
}
