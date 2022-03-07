package Main;

import Model.*;
import Util.UtilCSV;

import java.io.IOException;

public class Main {
	
	public static void main (String[] args) throws IOException {
		Hippodrome hippodrome = Hippodrome.getInstance();
		Data       data       = Data.getInstance();
		Cheval     c          = new Cheval("Mon grand poney", 2);
		
		UtilCSV util = UtilCSV.getInstance();
		util.chargerData();
		
		System.out.println(data.getChevaux());
		System.out.println(data.getCourses());
	}
}
