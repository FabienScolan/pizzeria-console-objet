package vue;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;

public abstract class MenuService {
	//abstract void executeUC();

	public abstract void executeUC(PizzaMemDao pizzaDao, Scanner questionUser);
}
