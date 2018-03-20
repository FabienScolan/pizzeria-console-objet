package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class PizzeriaConsoleAdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaMemDao pizzaDb = new PizzaMemDao();
		// System.out.println(pizzas[0].toString());
		System.out.println("\n**** Pizzeria Administration ****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		int option;
		Scanner questionUser = new Scanner(System.in);
		option = questionUser.nextInt();
		while (option != 99) {
			switch (option) {
			case 1:

				System.out.println("\nListe des pizzas");
				for (Pizza pizza : pizzaDb.findAllPizzas()) {
					if (pizza != null)
						System.out.println(pizza.toString());
				}
				break;
			case 2:
				System.out.println("\nAjout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code : ");
				String nvCode = questionUser.next();
				System.out.println("Veuillez saisir le nom : ");
				String nvNom = questionUser.next();
				System.out.println("Veuillez saisir le prix : ");
				double nvPrix = Double.parseDouble(questionUser.next());
				Pizza nvPizza = new Pizza(nvCode, nvNom, nvPrix);
				pizzaDb.saveNewPizza(nvPizza);
				break;
			case 3:
				System.out.println("\nMise à jour de la pizza");
				for (Pizza pizza : pizzaDb.findAllPizzas()) {
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
				pizzaDb.updatePizza(editCode, editPizza);
				break;
			case 4:
				System.out.println("\nSuppression de la pizza");
				for (Pizza pizza : pizzaDb.findAllPizzas()) {
					if (pizza != null)
						System.out.println(pizza.toString());
				}
				System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
				String suppCode = questionUser.next();
				/*
				 * boolean trouveSupp = false; for (Pizza pizza : pizzas) { if
				 * (pizza != null && pizza.getCode().equals(suppCode)) {
				 * trouveSupp = true; pizza = null; } }
				 */
				pizzaDb.deletePizza(suppCode);
				break;
			}
			System.out.println("\n**** Pizzeria Administration ****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			option = questionUser.nextInt();

		}
		System.out.println("\nAu revoir ☹");
		questionUser.close();
	}

}
