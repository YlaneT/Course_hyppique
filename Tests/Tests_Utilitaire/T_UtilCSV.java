package Tests_Utilitaire;

import Model.Cheval;
import Model.Course;
import Util.UtilCSV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class T_UtilCSV {
	UtilCSV util;
	
	@BeforeEach
	public void init () {
		util = new UtilCSV("csv_chevaux_test.csv", "csv_courses_test.csv");
		Cheval            ch1         = new Cheval("GENERAL KENOBI", 15);
		Cheval            ch2         = new Cheval("GENERAL GRIEVOUS", 15);
		Cheval            ch3         = new Cheval("MACE WINDU", 15);
		Cheval            ch4         = new Cheval("MAITRE YODA", 15);
		Cheval            ch5         = new Cheval("R2D2", 15);
		Cheval            ch6         = new Cheval("DARK VADOR", 15);
		ArrayList<Cheval> chevaux     = new ArrayList<>(Arrays.asList(ch1, ch2, ch3, ch4, ch5, ch6));
		Course            course_test = new Course("Course de pod", LocalDate.now(), chevaux, ch5);
	}
	
	@Test
	public void testCreationFichiers () throws FileNotFoundException {
		util.creationFichiers();
		assertTrue(new File("csv_chevaux_test.csv").exists() && new File("csv_courses_test.csv").exists());
		util.getChevaux().delete();
		util.getCourses().delete();
	}
}
