package Main;

import Model.*;

public class Main {
	
	public static void main (String[] args) {
		Hippodrome hippodrome = Hippodrome.getInstance();
		Data       data       = Data.getInstance();
		Cheval     c          = new Cheval("Mon grand poney", 2);
	}
}
