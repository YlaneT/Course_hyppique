package Tests_Controller;

import Controller.Controller_Cheval;
import Dao.Dao_Cheval;
import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TC_Cheval {
	Controller_Cheval cont;
	Dao_Cheval        dao;
	Cheval ch1;
	
	@BeforeEach
	public void init () {
		cont = new Controller_Cheval();
		dao = new Dao_Cheval();
		ch1 = new Cheval("GENERAL KENOBI", 15);
		Data.getInstance().setChevaux(new ArrayList<Cheval>());
	}
	
	//	@Test
	//	public void testCreationSixChevaux () {
	//		assertEquals(6, controller_cheval.creerSixChevaux().size());
	//	}
	
	@Test
	public void creerChevalTest () {
		cont.creerCheval("Mon petit poney", 1);
		assertEquals(1, Data.getInstance().getChevaux().size());
	}
	
	@Test
	public void calculerVictoiresTest () {
		Cheval            ch2          = new Cheval("GENERAL GRIEVOUS", 15);
		Cheval            ch3          = new Cheval("MACE WINDU", 15);
		Cheval            ch4          = new Cheval("MAITRE YODA", 15);
		Cheval            ch5          = new Cheval("R2D2", 15);
		Cheval            ch6          = new Cheval("DARK VADOR", 15);
		ArrayList<Cheval> chevaux      = new ArrayList<>(Arrays.asList(ch1, ch2, ch3, ch4, ch5, ch6));
		Course            course_test  = new Course("Course de pod", LocalDate.now(), chevaux, ch5);
		Course            course_test1 = new Course("Course de speeders", LocalDate.now(), chevaux, ch2);
		Course            course_test2 = new Course("Course de vaisseaux", LocalDate.now(), chevaux, ch5);
		Data.getInstance().getCourses().addAll(Arrays.asList(course_test, course_test1, course_test2));
		assertEquals(0, dao.calculerVictoires(ch1));
		assertEquals(1, dao.calculerVictoires(ch2));
		assertEquals(0, dao.calculerVictoires(ch3));
		assertEquals(0, dao.calculerVictoires(ch4));
		assertEquals(2, dao.calculerVictoires(ch5));
		assertEquals(0, dao.calculerVictoires(ch6));
	}
	
	@Test
	public void trouverChevalParNomTestOK () {
		ArrayList<Cheval> data_chevaux = new ArrayList<Cheval>();
		data_chevaux.add(ch1);
		Data.getInstance().setChevaux(data_chevaux);
		boolean result = ch1.equals(cont.trouverChevalParNom("General Kenobi"));
		result &= ch1.equals(cont.trouverChevalParNom("GenEral KeNobi"));
		result &= ch1.equals(cont.trouverChevalParNom("   General Kenobi   "));
		assertTrue(result);
	}
	
	@Test
	public void trouverChevalParNomTestKO () {
		ArrayList<Cheval> data_chevaux = new ArrayList<Cheval>();
		data_chevaux.add(ch1);
		Data.getInstance().setChevaux(data_chevaux);
		assertNull(cont.trouverChevalParNom("Compte Dooku"));
	}
	
	@Test
	public void supprimerChevalTest () {
		ArrayList<Cheval> data_chevaux = new ArrayList<Cheval>();
		data_chevaux.add(ch1);
		Data.getInstance().setChevaux(data_chevaux);
		cont.supprimerCheval(ch1);
		assertEquals(0, Data.getInstance().getChevaux().size());
	}
	
	@Test
	public void supprimerChevalParIndexTest () {
		ArrayList<Cheval> data_chevaux = new ArrayList<Cheval>();
		data_chevaux.add(ch1);
		Data.getInstance().setChevaux(data_chevaux);
		cont.supprimerCheval(1);
		assertEquals(0, Data.getInstance().getChevaux().size());
	}
}
