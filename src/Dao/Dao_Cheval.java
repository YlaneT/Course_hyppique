package Dao;

import Model.Cheval;
import Model.Data;

import java.util.ArrayList;

public class Dao_Cheval {
	
	public Cheval getChevalByName (String chevalNom) {
		ArrayList<Cheval> chevalList = Data.getInstance().getChevaux();
		for(int i = 0 ; i < chevalList.size() ; i++) {
			if (chevalList.get(i).getNom().equals(chevalNom)) {
				return chevalList.get(i);
			}
		}
		return null;
	}
	
	public void updateCheval (Cheval cheval, String nouveauNom, int nouveauAge) {
		ArrayList<Cheval> dataChevaux     = Data.getInstance().getChevaux();
		Cheval            chevalAModifier = dataChevaux.get(dataChevaux.indexOf(cheval));
		chevalAModifier.setNom(nouveauNom);
		chevalAModifier.setAge(nouveauAge);
	}
}
