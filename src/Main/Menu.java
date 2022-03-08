package Main;

import Controller.*;
import Model.Cheval;
import Model.Course;
import Util.UtilCSV;
import Util.Utilitaire;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Menu {
	private static Controller_Cheval     contCh = new Controller_Cheval();
	private static Controller_Course     contCo = new Controller_Course();
	private static Controller_Hippodrome contHi = new Controller_Hippodrome();
	
	// CREATION
	private static void creationCourse () {
		System.out.println("== CREATION DE COURSE ==");
		String nom = Utilitaire.saisieString("Donnez un nom à votre course : ");
		while (contCo.getCourseByName(nom) != null || nom.strip().equalsIgnoreCase("null")) {
			System.out.println("Choisissez un autre nom");
			nom = Utilitaire.saisieString("Donnez un nom à votre course : ");
		}
		System.out.print("\nEntrez la date de la course (jj/mm/aaaa) : ");
		LocalDate         date    = Utilitaire.saisieDate();
		ArrayList<Cheval> chevaux = new ArrayList<Cheval>();
		// TODO : Afficher la liste des chevaux et faire une boucle qui demande lesquels on veut ajouter
		// TODO : Créer un choix pour créer un cheval et l'ajouter une fois créé
		contCo.creerCourse(nom, date);
	}
	
	private static void creationCheval () {
		System.out.println("== CREATION DE CHEVAL ==");
		String nom = Utilitaire.saisieString("Donnez un nom à votre cheval : ");
		while (contCh.trouverChevalParNom(nom) != null || nom.strip().equalsIgnoreCase("null")) {
			System.out.println("Choisissez un autre nom");
			nom = Utilitaire.saisieString("Donnez un nom à votre cheval : ");
		}
		int age = Utilitaire.saisieInt("Donnez l'age du cheval : ");
		contCh.creerCheval(nom, age);
	}
	
	//	private static void ajoutCheval () {
	//	}
	
	// MENU PRINCIPAL
	public void menu_principal () throws IOException {
		// FIXME
		int info = type_info();
		switch (info) {
			case 1:
				afficherHippodrome();
				break;
			case 2:
				crudCourse();
				break;
			case 3:
				crudCheval();
				break;
			case 4:
				UtilCSV.getInstance().majCSV();
				// TODO : Fin de boucle
		}
		// TODO : Boucle
		
		
		/*switch (Utilitaire.saisieInt("Entrez une valeur entre 1 et 3")) {
			case 1:
				creationCourse();
				break;
			case 2:
				creationCheval();
				break;
			case 3:
				ajoutCheval();
				break;
			case 4:
				suppressionCourse();
				break;
			case 5:
				suppressionCheval();
				break;
			default:
		}*/
	}
	
	private int type_info () {
		System.out.println("=== A quel type de données voulez-vous accéder ? ===");
		System.out.println("1.\tHippodrome");
		System.out.println("2.\tCourses");
		System.out.println("3.\tChevaux");
		System.out.println("4.\tSauvegarder et quitter");
		int choice = 0;
		do {
			choice = Utilitaire.saisieInt("Entrez une valeur entre 1 et 3 : ");
		} while (choice < 1 || choice > 4);
		System.out.println("\n");
		return choice;
	}
	
	// CRUD CHEVAL / COURSE
	private void crudCourse () {
		System.out.println("=== Que voulez-vous faire ? ===");
		System.out.println("1.\tAjouter une course");
		System.out.println("2.\tAfficher les courses");
		System.out.println("3.\tModifier une course"); // TODO : Gérer chaque variable
		System.out.println("4.\tSupprimer une course");
		int choice;
		do {
			choice = Utilitaire.saisieInt("Entrez une valeur entre 1 et 4 : ");
		} while (choice < 1 || choice > 4);
		System.out.println("\n");
	}
	
	private void crudCheval () {
		System.out.println("=== Que voulez-vous faire ? ===");
		System.out.println("1.\tAjouter un cheval");
		System.out.println("2.\tAfficher les chevaux");
		System.out.println("3.\tModifier un cheval"); // TODO : Gérer chaque variable
		System.out.println("4.\tSupprimer un cheval");
		int choix;
		do {
			choix = Utilitaire.saisieInt("Entrez une valeur entre 1 et 4 : ");
		} while (choix < 1 || choix > 4);
		System.out.println("\n");
		
		switch (choix) {
			case 1:
				creationCheval();
				break;
			case 2:
				break;
			case 3:
				crudCheval();
				break;
		}
	}
	
	// AFFICHAGE
	private void afficherHippodrome () {
		contHi.afficherNom();
	}
	
	private void afficherChevaux () {
		contCh.afficherChevaux();
	}
	
	private void afficherDixDernieresCourses () {
		for(Course co : contCo.coursesTriées()) {
			System.out.println(co.toString());
		}
	}
	
	// SUPPRESSION
	private static void suppressionCourse (String nom) {
		Course course = contCo.getCourseByName(nom);
		if (course == null) {
			System.out.println("Cette course n'existe pas");
		}
		else {
			contCo.supprimerCourse(course);
			System.out.println("Course supprimée");
		}
	}
	
	private static void suppressionCheval (String nom) {
		Cheval cheval = contCh.trouverChevalParNom(nom);
		if (cheval == null) {
			System.out.println("Cette cheval n'existe pas");
		}
		else {
			contCh.supprimerCheval(cheval);
			System.out.println("Cheval supprimée");
		}
	}
	
	// MODIFICATION
}
