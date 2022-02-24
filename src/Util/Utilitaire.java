package Util;

import Model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
	
	public static ArrayList<Course> creationCourses () {
		return null;
	}
	
	public static String saisieString () {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static int saisieInt () {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
