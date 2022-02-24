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
	
	public String toString () {
		StringBuilder sb = new StringBuilder("\n{\n\t\"nom\": \"" + nom + "\",\n");
		sb.append("\t\"age\": \"" + age + "\",\n");
		sb.append("\t\"nbVictoire\": \"" + nbVictoire + "\"\n");
		sb.append("}");
		return sb.toString();
	}
}
