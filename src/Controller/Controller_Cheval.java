package Controller;

import Model.Cheval;
import Util.Utilitaire;

import java.util.ArrayList;

public class Controller_Cheval {
	public ArrayList<Cheval> creerSixChevaux () {
		String[] nomsChevaux = new String[] {
			"JUST IN LOVE", "TANTPISPOUREUX", "MY CHARMING PRINCE", "SITUMELEDEMANDAIS", "THE MAGIC MAN", "SRI LA " +
			"FRIME", "DAUPHIN", "UMBREUIL", "NEWPORT", "GOLDEN RASH", "ANTHONY KHELLIL"
		};
		ArrayList<Cheval> ch = new ArrayList<>();
		for(int i = 0 ; i < 6 ; i++) {
			ch.add(new Cheval(nomsChevaux[i], Utilitaire.boundRandint(10, 25)));
		}
		return ch;
	}
}
