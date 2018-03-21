package vue;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pizzaDao,Scanner questionUser) {
		// TODO Auto-generated method stub
		System.out.println("\nListe des pizzas");
		for (Pizza pizza : pizzaDao.findAllPizzas()) {
			if (pizza != null)
				System.out.println(pizza.toString());
		}
	}

	

}
