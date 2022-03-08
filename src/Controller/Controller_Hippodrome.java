package Controller;

import Model.Hippodrome;

public class Controller_Hippodrome {
	// READ
	public void afficherNom () {
		System.out.println(Hippodrome.getInstance().toString());
	}
}
