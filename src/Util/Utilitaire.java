package Util;

import Model.Cheval;
import Model.Course;
import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Utilitaire {
	
	public static ArrayList<Course> creationSixCourses () throws ExecutionControl.NotImplementedException {
		
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
	
	public static LocalDate saisieDate (String message) {
//		Scanner scan = new Scanner(System.in);
//		String c = scan.next();
//		System.out.println(c);
//		ZonedDateTime d = ZonedDateTime.parse(c);
//		System.out.println(d);
//
////		String[] words = c.split("-");
////        for (String word : words) {
////            System.out.println(word);
////          
////        }
//		return d;
		
		LocalDate localDate = LocalDate.now();
		return localDate;
        
     // create a formatter
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu");
// 
//        // create a LocalDate object and
//        LocalDate lt
//            = LocalDate.parse(c, formatter);
// 
//        // print result
//        System.out.println("LocalDate : "
//                           + lt.toString());
		//System.out.print(scan);
//	    System.out.print("Enter a date [dd. MMM. yyyy]: ");
	    //String str = scan.nextLine();
//	    System.out.println(str);
	    //System.out.print(LocalDate.parse(scan.next()));
	    //LocalDate dtf = LocalDate.of("dd. MMM. yyyy");
	    //return LocalDate.parse(str, dtf);
	    //return lt;
		
		
		
		//return LocalDate.parse(saisieString(message), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

