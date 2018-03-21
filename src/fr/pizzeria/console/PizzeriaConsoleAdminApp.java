package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.vue.*;

public class PizzeriaConsoleAdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaMemDao pizzaDb = new PizzaMemDao();
		MenuService menupizza;
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
			menupizza = MenuServiceFactory.choixMenu(option, questionUser, pizzaDb);
			menupizza.executeUC(pizzaDb, questionUser);
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
