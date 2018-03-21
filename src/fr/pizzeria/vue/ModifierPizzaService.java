package fr.pizzeria.vue;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pizzaDao, Scanner questionUser) {
		// TODO Auto-generated method stub
		System.out.println("\nMise à jour de la pizza");
		for (Pizza pizza : pizzaDao.findAllPizzas()) {
			if (pizza != null)
				System.out.println(pizza.toString());
		}
		System.out.println("Veuillez saisir le code de la pizza à modifier : ");
		String editCode = questionUser.next();
		System.out.println("Veuillez saisir le nouveau nom : ");
		String editNom = questionUser.next();
		System.out.println("Veuillez saisir le nouveau prix : ");
		double editPrix = Double.parseDouble(questionUser.next());
		Pizza editPizza = new Pizza(editCode, editNom, editPrix);
		pizzaDao.updatePizza(editCode, editPizza);
	}


}
