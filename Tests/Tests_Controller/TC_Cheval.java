package Tests_Controller;

import Controller.Controller_Cheval;
import Model.Cheval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TC_Cheval {
	Controller_Cheval cc;
	
	@BeforeEach
	public void init () {
		cc = new Controller_Cheval();
	}
	
	@Test
	public void testCreationSixChevaux () {
		assertEquals(6, cc.creerSixChevaux().size());
	}
	
	private void assertTrue () {
	}
}
