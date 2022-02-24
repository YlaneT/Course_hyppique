package Util;

import Model.Course;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;

public class Utilitaire {
	
	public static ArrayList<Course> creationCourses () throws ExecutionControl.NotImplementedException {
		
		
		throw new ExecutionControl.NotImplementedException("");
	}
	
	public static String saisieString () {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static int saisieInt () {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static int boundRandint (int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
}
