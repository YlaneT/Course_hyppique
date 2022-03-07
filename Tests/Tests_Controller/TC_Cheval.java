package Tests_Controller;

import Controller.Controller_Cheval;
import Model.Cheval;
import Model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TC_Cheval {
	Cheval            chevaux;
	Controller_Cheval controller_cheval;
	
	@BeforeEach
	
	public void init () {
		controller_cheval = new Controller_Cheval();
	}
	
//	@Test
//	public void testCreationSixChevaux () {
//		assertEquals(6, controller_cheval.creerSixChevaux().size());
//	}
	
	@Test
	public void creerChevalTest () {
		controller_cheval.creerCheval("Mon petit poney", 1);
		assertEquals(1, Data.getInstance().getChevaux().size());
	}
}
