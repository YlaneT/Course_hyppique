package Controller;

import Dao.Dao_Cheval;
import Model.Cheval;

import java.util.ArrayList;

public class Controller_Cheval {
	Dao_Cheval dao = new Dao_Cheval();
	
	// CREATE
	public void creerCheval (String nom, int age) {
		Cheval cheval = new Cheval(nom, age);
		dao.creerCheval(cheval);
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
	
	public int afficherChevauxNumerotes () {
		ArrayList<Cheval> data_chevaux = dao.getAllCheval();
		int i;
		for(i = 1 ; i < data_chevaux.size() ; i++) {
			System.out.println(i + ".\t" + data_chevaux.get(i).toString());
		}
		return i ;
	}
	
	public Cheval trouverChevalParNom (String nom) {
		return dao.getChevalByName(nom);
	}

	public Cheval trouverChevalParIndex (int index) {
		return dao.getChevalByIndex(index);
	}

	public ArrayList<Cheval> recupChevaux(){
		return dao.getAllCheval();
	}
	
	// UPDATE
	/*public void modifierCheval () {
	
	}
	
	public void modifierNom () {
	
	}
	
	public void modifierAge () {
	
	}*/
	
	// DELETE
	public void supprimerCheval (Cheval cheval) {
		Dao_Cheval.supprimerCheval(cheval);
	}
	
	public void supprimerCheval (int index){
		Dao_Cheval.supprimerCheval(index);
	}
}
