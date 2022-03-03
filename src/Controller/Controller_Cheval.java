package Controller;

import Model.*;
import Util.Utilitaire;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

public class Controller_Cheval {
	// CREATE
	public void creerCheval (String nom, int age) {
		Data.getInstance().getChevaux().add(new Cheval(nom, age));
	}
	
	// READ
	public void afficherChevaux () {
	
	}
	
	// UPDATE
	public void modifierNom () {
	
	}
	
	public void modifierAge () {
	
	}
	
	// DELETE
	public void supprimerCheval () {
	
	}
}
