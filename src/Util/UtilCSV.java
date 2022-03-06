package Util;

import Model.*;

import java.io.*;
import java.util.ArrayList;

public class UtilCSV {
	private static String  csv_chevaux = "chevaux.csv";
	private static String  csv_courses = "courses.csv";
	private static UtilCSV instance    = null;
	private        File    chevaux;
	private        File    courses;
	
	// SINGLETON
	private UtilCSV () {
		chevaux = new File(csv_chevaux);
		courses = new File(csv_courses);
	}
	
	// Pour les tests
	public UtilCSV (String csv_chevaux_test, String csv_courses_test) {
		csv_chevaux = csv_chevaux_test;
		csv_courses = csv_courses_test;
		chevaux = new File(csv_chevaux);
		courses = new File(csv_courses);
	}
	
	public static UtilCSV getInstance () {
		if (instance == null) {
			instance = new UtilCSV();
		}
		return instance;
	}
	
	// CREATION DES FICHIERS
	public void creationFichiers () throws FileNotFoundException {
		while (!chevaux.exists() ){
			try {
				chevaux.createNewFile();
			} catch (IOException exc) {
				System.err.println(exc.getMessage());
			}
		}
		while (!courses.exists() ){
			try {
				courses.createNewFile();
			} catch (IOException exc) {
				System.err.println(exc.getMessage());
			}
		}
		PrintWriter pw_ch = new PrintWriter(chevaux);
		pw_ch.println("NOM, AGE, VICTOIRES");
		pw_ch.close();
		
		PrintWriter pw_co = new PrintWriter(courses);
		pw_co.println("NOM, DATE, CHEVAL1, CHEVAL2, CHEVAL3, CHEVAL4, CHEVAL5, CHEVAL6, VAINQUEUR");
		pw_co.close();
		
	}
	
	// CHEVAL
	public void sauvegarderChevaux () throws FileNotFoundException {
		PrintWriter       pw_ch        = new PrintWriter(getInstance().getChevaux());
		ArrayList<Cheval> data_chevaux = Data.getInstance().getChevaux();
		for(Cheval ch : data_chevaux) {
			pw_ch.println(String.format("%s, %d, %d", ch.getNom(), ch.getAge(), ch.getNbVictoire()));
		}
		pw_ch.close();
	}
	
	public void chargerChevaux () {}
	
	// COURSE
	public void sauvegarderCourses () throws FileNotFoundException {
		PrintWriter       pw_ch        = new PrintWriter(getInstance().getCourses());
		ArrayList<Course> data_courses = Data.getInstance().getCourses();
		for(Course co : data_courses) {
			StringBuilder sb = new StringBuilder(co.getNom()).append(", ");
			sb.append(co.getDate().toString()).append(", ");
			for(Cheval ch : co.getChevaux()) {
				sb.append(ch.getNom()).append(", ");
			}
			sb.append(co.getVainqueur().getNom());
			pw_ch.println(sb.toString());
		}
		pw_ch.close();
	}
	
	public void chargerCourse () {}
	
	// MISE A JOUR
	public void majCSV () throws IOException {
		chevaux.delete();
		courses.delete();
		getInstance().creationFichiers();
		getInstance().sauvegarderChevaux();
		getInstance().sauvegarderCourses();
	}
	
	// GETTERS
	public File getChevaux () {
		return chevaux;
	}
	
	public File getCourses () {
		return courses;
	}
}
