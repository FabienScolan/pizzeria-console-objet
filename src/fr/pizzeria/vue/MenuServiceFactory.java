package fr.pizzeria.vue;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;

public class MenuServiceFactory {

	MenuService menupizza;
	public void choixMenu(int option, Scanner questionUser, PizzaMemDao pizzaDao){
		switch (option) {
		case 1:
			menupizza = new ListerPizzaService();
			break;
		case 2:
			menupizza = new AjouterPizzaService();
			break;
		case 3:
			menupizza = new ModifierPizzaService();
			break;
		case 4:
			menupizza = new SupprimerPizzaService();
			break;
		}
		menupizza.executeUC(pizzaDao, questionUser);
	}
}
