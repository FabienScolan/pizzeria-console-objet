package fr.pizzeria.vue;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pizzaDao, Scanner questionUser) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("\nMise � jour de la pizza");
		for (Pizza pizza : pizzaDao.findAllPizzas()) {
			if (pizza != null)
				System.out.println(pizza.toString());
		}
		System.out.println("Veuillez saisir le code de la pizza � modifier : ");
		String editCode = questionUser.next();
		if (editCode.length()>4) throw new UpdatePizzaException("Le code ne doit pas d�passer 4 lettres");
		System.out.println("Veuillez saisir le nouveau nom : ");
		String editNom = questionUser.next();
		System.out.println("Veuillez saisir le nouveau prix : ");
		double editPrix = Double.parseDouble(questionUser.next());
		if (editPrix < 0.0) throw new SavePizzaException();
		System.out.println("Veuillez d�finir le type de la pizza : ");
		CategoriePizza catPizza=null;
		try {
		    catPizza = CategoriePizza.valueOf(questionUser.next() );
		} catch ( IllegalArgumentException e ) {
		    System.err.println( "Ce type de pizza n'existe pas" );
		}
		Pizza editPizza = new Pizza(editCode, editNom, editPrix, catPizza);
		pizzaDao.updatePizza(editCode, editPizza);
	}


}
