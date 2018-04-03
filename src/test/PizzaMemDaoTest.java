package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

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
	public void testFindAllPizzasMock(){
		PizzaMemDao p2dao = Mockito.mock(PizzaMemDao.class);
		Mockito.when(p2dao.findAllPizzas()).thenReturn(null);
		List <Pizza> l2pizzas =p2dao.findAllPizzas();
		assertTrue(l2pizzas==null);
		List <Pizza> ltpizzas = new PizzaMemDao().findAllPizzas();
		ltpizzas.set(0, null);
		ltpizzas.set(1, new Pizza(null,"code nul",0.0,CategoriePizza.SANS_VIANDE));
		Mockito.when(p2dao.findAllPizzas()).thenReturn(ltpizzas);
		l2pizzas = p2dao.findAllPizzas();
		assertTrue(l2pizzas.get(0)==null);
		assertTrue(l2pizzas.get(1).getCode()==null);
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
