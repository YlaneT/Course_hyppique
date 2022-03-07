package Tests_Dao;

import Dao.Dao_Cheval;
import Dao.Dao_Hippodrome;
import Model.Cheval;
import Model.Data;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TD_Cheval {
	Dao_Hippodrome hippodromeDao;
	Dao_Cheval     chevalDao;
	
	/*
	 * @BeforeEach public void init() { hippodromeDao = new Dao_Hippodrome();
	 * chevalDao = new Dao_Cheval(); }
	 */
	
	@Test
	public void getChevalTest () {
		hippodromeDao = new Dao_Hippodrome();
		chevalDao = new Dao_Cheval();
		ArrayList<Cheval> res = chevalDao.getAllCheval();
		assertNotNull(res);
	}
	
	@Test
	public void createChevalTestOK () {
		String chevalNom = "gtere";
		chevalDao = new Dao_Cheval();
		assertTrue(chevalDao.creerCheval(chevalNom, 12));
	}
	
	@Test
	public void updateChevalTestOK () {
		String chevalNom = "gjfze";
		chevalDao = new Dao_Cheval();
		
		Cheval cheval = new Cheval(chevalNom, 12);
		
		Data d = Data.getInstance();
		d.getChevaux().add(cheval);
		
		chevalDao.updateCheval(cheval, "feee", 12);
		
		assertEquals("feee", cheval.getNom());
	}
	
	@Test
	public void deleteChevalTestOk () {
		String chevalNom = "gjfze";
		chevalDao = new Dao_Cheval();
		
		Cheval cheval = new Cheval(chevalNom, 12);
		Data   d      = Data.getInstance();
		d.getChevaux().add(cheval);
		
		boolean res = chevalDao.deleteCheval(cheval);
		assertTrue(res);
	}
	
	@Test
	public void deleteChevalTestKO () {
		String chevalNom = "gjfze";
		chevalDao = new Dao_Cheval();
		
		Cheval cheval = new Cheval(chevalNom, 12);
		
		boolean res = chevalDao.deleteCheval(cheval);
		assertFalse(res);
	}
	
	@Test
	public void getChevalByNameTestOK () {
		String chevalNom = "grfue";
		Data   d         = Data.getInstance();
		chevalDao = new Dao_Cheval();
		
		d.getChevaux().add(new Cheval(chevalNom, 12));
		Cheval res = chevalDao.getChevalByName(chevalNom);
		
		assertEquals(chevalNom, res.getNom());
		assertEquals(12, res.getAge());
	}
	
	@Test
	public void getChevalByNameTestKO () {
		String chevalNom = "grfue";
		chevalDao = new Dao_Cheval();
		Cheval res = chevalDao.getChevalByName(chevalNom);
		
		assertNull(res);
	}
}