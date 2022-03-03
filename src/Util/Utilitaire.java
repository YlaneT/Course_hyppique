package Util;

import Model.Cheval;
import Model.Course;
import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class Utilitaire {
	
	public static ArrayList<Course> creationCourses () throws ExecutionControl.NotImplementedException {
		
		throw new ExecutionControl.NotImplementedException("");
	}
	
	public static String saisieString (String message) {
		if (!message.equals("")) {
			System.out.print(message);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\n");
		return sc.next();
	}
	
	public static int saisieInt (String message) {
		if (!message.equals("")) {
			System.out.print(message);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\n");
		return sc.nextInt();
	}
	
	public static int boundRandint (int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	
	public static LocalDate saisieDate () { // FIXME : Utiliser LocalDate
		Scanner sc = new Scanner(System.in);
		String  date = sc.next(Pattern.compile("[0-3][0-9]/[0-1]?[0-9]/[0-9]{4}"));
		// See DateFormat, parse(String)
		try {
			throw new ExecutionControl.NotImplementedException("");
		} catch (ExecutionControl.NotImplementedException e) {
			System.err.println("Not implemented");
		}
		return null;
	}
	
	public ArrayList<Cheval> creerSixChevaux () { // FIXME
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

