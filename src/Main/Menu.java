package Main;

import Controller.Controller_Cheval;
import Controller.Controller_Course;
import Model.Cheval;
import Util.Utilitaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Menu {
	private static Controller_Cheval contCh = new Controller_Cheval();
	private static Controller_Course contCo = new Controller_Course();
	
	private static void creationCourse () {
		System.out.println("== CREATION DE COURSE ==");
		String nom = Utilitaire.saisieString("Donnez un nom à votre course : ");
		// TODO : Vérifier qu'il n'existe pas une course possédant le même nom
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
		// TODO : Vérifier qu'il n'existe pas un cheval possédant le même nom
		int age = Utilitaire.saisieInt("Donnez l'age du cheval : ");
		contCh.creerCheval(nom, age);
	}
	
	private static void ajoutCheval () {
	}
	
	private static void suppressionCourse () {
	}
	
	private static void suppressionCheval () {
	}
	
	public void choix () {
		// FIXME
		int info = typeInfo();
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
		}
		
		
		switch (Utilitaire.saisieInt("Entrez une valeur entre 1 et 3")) {
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
		}
	}
	
	private int typeInfo () {
		System.out.println("=== A quel type de données voulez-vous accéder ? ===");
		System.out.println("1.\tHippodrome");
		System.out.println("2.\tCourses");
		System.out.println("3.\tChevaux");
		int choice = 0;
		do {
			choice = Utilitaire.saisieInt("Entrez une valeur entre 1 et 3 : ");
		} while (choice < 1 || choice > 3);
		System.out.println("\n");
		return choice;
	}
	
	private void afficherHippodrome () {
	
	}
	
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
		int choice;
		do {
			choice = Utilitaire.saisieInt("Entrez une valeur entre 1 et 4 : ");
		} while (choice < 1 || choice > 4);
		System.out.println("\n");
	}
}
