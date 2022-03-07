package Dao;

import Model.Hippodrome;

public class Dao_Hippodrome {
	
	public Hippodrome hippodrome = new Hippodrome();
	
	public Dao_Hippodrome() {
	
	}
	
	public String getName() {
		return Hippodrome.getInstance().getNom();
		
	}
	
}