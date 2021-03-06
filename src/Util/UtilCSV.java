package Util;

import Dao.Dao_Cheval;
import Model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		while (!chevaux.exists()) {
			try {
				chevaux.createNewFile();
			} catch (IOException exc) {
				System.err.println(exc.getMessage());
			}
			PrintWriter pw_ch = new PrintWriter(chevaux);
			pw_ch.println("NOM, AGE, VICTOIRES");
			pw_ch.close();
		}
		while (!courses.exists()) {
			try {
				courses.createNewFile();
			} catch (IOException exc) {
				System.err.println(exc.getMessage());
			}
			PrintWriter pw_co = new PrintWriter(courses);
			pw_co.println("NOM, DATE, CHEVAL1, CHEVAL2, CHEVAL3, CHEVAL4, CHEVAL5, CHEVAL6, VAINQUEUR");
			pw_co.close();
		}
	}
	
	public void chargerData () throws IOException {
		chargerChevaux();
		chargerCourses();
	}
	
	// CHEVAL
	public void sauvegarderChevaux () throws FileNotFoundException {
		PrintWriter       pw_ch        = new PrintWriter(getInstance().getChevaux());
		ArrayList<Cheval> data_chevaux = Data.getInstance().getChevaux();
		pw_ch.println("NOM, AGE, VICTOIRES");
		for(Cheval ch : data_chevaux) {
			pw_ch.append(String.format("%s, %d, %d", ch.getNom(), ch.getAge(), ch.getNbVictoire()));
		}
		pw_ch.close();
	}
	
	private void chargerChevaux () throws IOException {
		String            delim      = ", ";
		ArrayList<Cheval> dataCheval = Data.getInstance().getChevaux();
		if (!chevaux.exists()) {
			creationFichiers();
		}
		else {
			FileReader     fr = new FileReader(chevaux);
			BufferedReader br = new BufferedReader(fr);
			String         cheval;
			br.readLine(); // passer la ligne d'en-t??te
			while ((cheval = br.readLine()) != null) {
				String[] params = cheval.split(delim);
				String   nom    = params[0];
				int      age    = Integer.parseInt(params[1]);
				int      victoires    = Integer.parseInt(params[2]);
				dataCheval.add(new Cheval(nom, age, victoires));
			}
			br.close();
		}
	}
	
	// COURSE
	public void sauvegarderCourses () throws FileNotFoundException {
		PrintWriter       pw_co        = new PrintWriter(getInstance().getCourses());
		ArrayList<Course> data_courses = Data.getInstance().getCourses();
		pw_co.println("NOM, DATE, CHEVAL1, CHEVAL2, CHEVAL3, CHEVAL4, CHEVAL5, CHEVAL6, VAINQUEUR");
		for(Course co : data_courses) {
			StringBuilder sb = new StringBuilder(co.getNom()).append(", ");
			sb.append(co.getDate().toString()).append(", ");
			for(Cheval ch : co.getChevaux()) {
				sb.append(ch.getNom()).append(", ");
			}
			sb.append(co.getVainqueur().getNom());
			pw_co.append(sb.toString());
		}
		pw_co.close();
	}
	
	private void chargerCourses () throws IOException {
		String            delim      = ", ";
		ArrayList<Course> dataCourse = Data.getInstance().getCourses();
		Dao_Cheval        dao_ch     = new Dao_Cheval();
		if (!courses.exists()) {
			creationFichiers();
		}
		else {
			FileReader     fr = new FileReader(courses);
			BufferedReader br = new BufferedReader(fr);
			String         cheval;
			br.readLine(); // passer la ligne d'en-t??te
			while ((cheval = br.readLine()) != null) {
				String[]          params       = cheval.split(delim);
				String            nom          = params[0];
				LocalDate         date         = LocalDate.parse(params[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				ArrayList<Cheval> participants = new ArrayList<>();
				for(int i = 2 ; i < 8 ; i++) {
					if (params[i].equalsIgnoreCase("null")) {
						participants.add(null);
					}
					else {
						participants.add(dao_ch.getChevalByName(params[i]));
					}
				}
				Cheval vainqueur = null;
				if (!params[8].equalsIgnoreCase("null")) {
					vainqueur = dao_ch.getChevalByName(params[8]);
				}
				dataCourse.add(new Course(nom, date, participants, vainqueur));
			}
			br.close();
		}
	}
	
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
