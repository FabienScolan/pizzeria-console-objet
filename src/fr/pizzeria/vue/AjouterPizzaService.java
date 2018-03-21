package fr.pizzeria.vue;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pizzaDao, Scanner questionUser) {
		// TODO Auto-generated method stub
		System.out.println("\nAjout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String nvCode = questionUser.next();
		System.out.println("Veuillez saisir le nom : ");
		String nvNom = questionUser.next();
		System.out.println("Veuillez saisir le prix : ");
		double nvPrix = Double.parseDouble(questionUser.next());
		Pizza nvPizza = new Pizza(nvCode, nvNom, nvPrix);
		pizzaDao.saveNewPizza(nvPizza);
	}
	

}
