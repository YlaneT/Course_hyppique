package Dao;

import Model.Cheval;
import Model.Data;

import java.util.ArrayList;

public class Dao_Cheval {
	// CREATE
	public boolean creerCheval (String nom, int age) {
		return Data.getInstance().getChevaux().add(new Cheval(nom, age));
	}
	
	// READ
	public ArrayList<Cheval> getAllCheval () {
		return Data.getInstance().getChevaux();
	}
	
	public Cheval getChevalByName (String chevalNom) {
		ArrayList<Cheval> chevalList = Data.getInstance().getChevaux();
		for(int i = 0 ; i < chevalList.size() ; i++) {
			if (chevalList.get(i).getNom().equals(chevalNom)) {
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
}
