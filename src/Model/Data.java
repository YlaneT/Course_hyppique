package Model;

import java.util.ArrayList;

public class Data {
	private static Data              instance = null;
	private        Hippodrome        hippodrome;
	private        ArrayList<Cheval> chevaux;
	private        ArrayList<Course> courses;
	
	public Data () {
		this.hippodrome = Hippodrome.getInstance();
		this.chevaux = new ArrayList<Cheval>();
		this.courses = new ArrayList<Course>();
	}
	
	public static Data getInstance () {
		if (instance == null) {
			instance = new Data();
		}
		return instance;
	}
	
	public static void setInstance (Data instance) {
		Data.instance = instance;
	}
	
	public Hippodrome getHippodrome () {
		return hippodrome;
	}
	
	public void setHippodrome (Hippodrome hippodrome) {
		this.hippodrome = hippodrome;
	}
	
	public ArrayList<Cheval> getChevaux () {
		return chevaux;
	}
	
	public void setChevaux (ArrayList<Cheval> chevaux) {
		this.chevaux = chevaux;
	}
	
	public ArrayList<Course> getCourses () {
		return courses;
	}
	
	public void setCourses (ArrayList<Course> courses) {
		this.courses = courses;
	}
}
