package Model;

public class Cheval {
	private String nom;
	private int    age;
	private int    nbVictoire;
	
	public Cheval (String nom, int age, int nbVictoire) {
		this.nom = nom;
		this.age = age;
		this.nbVictoire = nbVictoire;
	}
	
	public Cheval (String nom, int age) {
		this(nom, age, 0);
	}
}
