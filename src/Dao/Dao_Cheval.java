package Dao;

import Model.*;

import java.util.ArrayList;

public class Dao_Cheval {
	public static boolean supprimerCheval (Cheval cheval) {
		return Data.getInstance().getChevaux().remove(cheval);
	}
	
	public static void supprimerCheval (int index) {
		ArrayList<Cheval> data_chevaux     = Data.getInstance().getChevaux();
		Cheval            chevalASupprimer = data_chevaux.get(index-1);
		data_chevaux.remove(chevalASupprimer);
	}
	
	// CREATE
	public boolean creerCheval (Cheval cheval) {
		return Data.getInstance().getChevaux().add(cheval);
	}
	
	// READ
	public ArrayList<Cheval> getAllCheval () {
		return Data.getInstance().getChevaux();
	}
	
	public Cheval getChevalByName (String chevalNom) {
		ArrayList<Cheval> chevalList = Data.getInstance().getChevaux();
		for(int i = 0 ; i < chevalList.size() ; i++) {
			if (chevalList.get(i).getNom().strip().equalsIgnoreCase(chevalNom.strip())) {
				return chevalList.get(i);
			}
		}
		return null;
	}
	
	// UPDATE
	public void updateCheval (Cheval cheval, String nouveauNom, int nouveauAge) {
		ArrayList<Cheval> dataChevaux     = Data.getInstance().getChevaux();
		Cheval            chevalAModifier = dataChevaux.get(dataChevaux.indexOf(cheval));
		chevalAModifier.setNom(nouveauNom);
		chevalAModifier.setAge(nouveauAge);
	}
	
	// DELETE
	public boolean deleteCheval (Cheval cheval) {
		return Data.getInstance().getChevaux().remove(cheval);
	}
	
	public int calculerVictoires (Cheval cheval) {
		ArrayList<Course> data_courses = Data.getInstance().getCourses();
		int               victoires    = 0;
		for(Course co : data_courses) {
			if (co.getVainqueur().equals(cheval)) {
				victoires++;
			}
		}
		return victoires;
	}
}
