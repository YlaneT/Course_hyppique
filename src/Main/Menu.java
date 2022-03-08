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
		ArrayList<Cheval> courses = new ArrayList<Cheval>();
		// TODO : Afficher la liste des chevaux et faire une boucle qui demande lesquels on veut ajouter
		// TODO : Créer un choix pour créer un cheval et l'ajouter une fois créé
		contCo.creerCourse(nom, date);
	}
	
	private static ArrayList<Cheval> ajouterChevauxACourse () {
		return null;
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
	public static int menu_principal () throws IOException {
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
				break;
			default:
				System.out.println("Entrez une valeur entre 1 et 4 : ");
		}
		return info;
	}
	
	private static int type_info () {
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
	private static void crudCourse () {
		System.out.println("=== Que voulez-vous faire ? ===");
		System.out.println("1.\tAjouter une course");
		System.out.println("2.\tAfficher les courses");
		System.out.println("3.\tModifier une course");
		System.out.println("4.\tSupprimer une course");
		int choix;
		do {
			choix = Utilitaire.saisieInt("Entrez une valeur entre 1 et 4 : ");
		} while (choix < 1 || choix > 4);
		System.out.println("\n");
		// TODO : Gérer chaque cas
		switch (choix) {
			
		}
	}
	
	private static void crudCheval () {
		System.out.println("=== Que voulez-vous faire ? ===");
		System.out.println("1.\tAjouter un cheval");
		System.out.println("2.\tAfficher les chevaux");
		System.out.println("3.\tModifier un cheval");
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
				contCh.afficherChevaux();
				break;
			case 3:
				// TODO
				System.err.println("PAS IMPLEMENTE");
				break;
			case 4:
				suppressionCheval();
		}
	}
	
	// AFFICHAGE
	private static void afficherHippodrome () {
		contHi.afficherNom();
		System.out.println("Dix dernières courses : ");
		afficherDixDernieresCourses();
	}
	
	private static void afficherDixDernieresCourses () {
		for(Course co : contCo.coursesTriees()) {
			System.out.println(co.toString());
		}
	}
	
	// SUPPRESSION
	private static void suppressionCourse (String nom) {
		int limite = contCo.afficherCoursesNumerotes();
		int num;
		do {
			num = Utilitaire.saisieInt("Sélectionnez le numéro du course que vous voulez supprimer");
		} while (num < 1 || num > limite);
		contCo.supprimerCourse(num);
	}
	
	private static void suppressionCheval () {
		int limite = contCh.afficherChevauxNumerotes();
		int num;
		do {
			num = Utilitaire.saisieInt("Sélectionnez le numéro du cheval que vous voulez supprimer");
		} while (num < 1 || num > limite);
		contCh.supprimerCheval(num);
	}
	
	// MODIFICATION
}
