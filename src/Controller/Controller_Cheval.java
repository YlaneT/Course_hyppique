package Controller;

import Dao.Dao_Cheval;
import Model.Cheval;

import java.util.ArrayList;

public class Controller_Cheval {
	Dao_Cheval dao = new Dao_Cheval();
	
	// CREATE
	public void creerCheval (String nom, int age) {
		Cheval cheval = new Cheval(nom, age);
		calculerVictoires(cheval);
	}
	
	public void calculerVictoires (Cheval cheval) {
		cheval.setNbVictoire(dao.calculerVictoires(cheval));
	}
	
	// READ
	public void afficherChevaux () {
		ArrayList<Cheval> data_chevaux = dao.getAllCheval();
		for(Cheval ch : data_chevaux) {
			System.out.println(ch.toString());
		}
	}
	
	public Cheval trouverChevalParNom (String nom) {
		return dao.getChevalByName(nom);
	}
	
	// UPDATE
	public void modifierCheval () {
	
	}
	
	public void modifierNom () {
	
	}
	
	public void modifierAge () {
	
	}
	
	// DELETE
	public boolean supprimerCheval (Cheval cheval) {
		return Dao_Cheval.supprimerCheval(cheval);
	}
}
