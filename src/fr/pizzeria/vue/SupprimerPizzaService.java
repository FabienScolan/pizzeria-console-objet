package fr.pizzeria.vue;

import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pizzaDao, Scanner questionUser) throws StockageException{
		// TODO Auto-generated method stub
		System.out.println("\nSuppression de la pizza");
		for (Pizza pizza : pizzaDao.findAllPizzas()) {
			if (pizza != null)
				System.out.println(pizza.toString());
		}
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		String suppCode = questionUser.next();
		if (suppCode.length()>4) throw new DeletePizzaException("Le code ne doit pas dépasser 4 lettres");
		pizzaDao.deletePizza(suppCode);
	}

}
