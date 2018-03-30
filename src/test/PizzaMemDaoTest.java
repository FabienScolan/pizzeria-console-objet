package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class PizzaMemDaoTest {

	@Test
	public void testPizzaMemDao() {
		PizzaMemDao pdao = new PizzaMemDao();
		assertTrue(pdao != null);
	}

	@Test
	public void testFindAllPizzas() {
		PizzaMemDao pdao = new PizzaMemDao();
		List <Pizza> lpizzas =pdao.findAllPizzas();
		assertTrue(lpizzas.size()==8);
		
	}

	@Test
	public void testSaveNewPizza() {
		PizzaMemDao pdao = new PizzaMemDao();
		List <Pizza> lpizzas =pdao.findAllPizzas();
		int taille = lpizzas.size();
		Pizza nvPizza = new Pizza("TEST", "test_pizza", 12.34, CategoriePizza.VIANDE);
		pdao.saveNewPizza(nvPizza);
		assertTrue(taille+1== lpizzas.size() && pdao.findPizzaByCode("TEST").getLibelle()==nvPizza.getLibelle());
	}

	@Test
	public void testUpdatePizza() {
		PizzaMemDao pdao = new PizzaMemDao();
		String newname = "La 4 fromages";
		Pizza nvPizza = pdao.findPizzaByCode("FRO");
		nvPizza.setLibelle(newname);
		pdao.updatePizza("FRO", nvPizza);
		assertTrue(pdao.findPizzaByCode("FRO").getLibelle().equals(newname));
	}

	@Test
	public void testDeletePizza() {
		PizzaMemDao pdao = new PizzaMemDao();
		List <Pizza> lpizzas =pdao.findAllPizzas();
		int taille = lpizzas.size();
		pdao.deletePizza("ORI");
		assertEquals(lpizzas.size(), taille-1);
	}

	@Test
	public void testFindPizzaByCode() {
		PizzaMemDao pdao = new PizzaMemDao();
		Pizza nvPizza = pdao.findPizzaByCode("CAN");
		assertTrue(nvPizza.getLibelle().equals("La Cannibale") && nvPizza.getPrix() == 12.50);
	}

	@Test
	public void testPizzaExists() {
		PizzaMemDao pdao = new PizzaMemDao();
		Pizza nvPizza = pdao.findPizzaByCode("CAN");
		assertTrue(nvPizza!=null);
	}

}
