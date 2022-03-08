package Main;

import Model.Data;
import Model.Hippodrome;
import Util.UtilCSV;

import java.io.IOException;

public class Main {
	
	public static void main (String[] args) throws IOException {
		Hippodrome.getInstance();
		Data.getInstance();
		UtilCSV    csv        = UtilCSV.getInstance();
		csv.chargerData();
		while(Menu.menu_principal() != 4);
		csv.majCSV();
	}
}
