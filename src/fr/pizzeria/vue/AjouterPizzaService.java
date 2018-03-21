package fr.pizzeria.vue;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pizzaDao, Scanner questionUser) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("\nAjout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String nvCode = questionUser.next();
		if (nvCode.length()>4) throw new SavePizzaException("Le code ne doit pas dépasser 4 lettres");
		System.out.println("Veuillez saisir le nom : ");
		String nvNom = questionUser.next();
		System.out.println("Veuillez saisir le prix : ");
		double nvPrix = Double.parseDouble(questionUser.next());
		if (nvPrix < 0.0) throw new SavePizzaException("Impossible de mettre un prix inférieur à 0€");
		System.out.println("Veuillez définir le type de la pizza : ");
		//comment savoir type enum via scanner
		CategoriePizza catPizza=null;
		try {
		    catPizza = CategoriePizza.valueOf(questionUser.next() );
		} catch ( IllegalArgumentException e ) {
		    System.err.println( "Ce type de pizza n'existe pas" );
		}
		Pizza nvPizza = new Pizza(nvCode, nvNom, nvPrix, catPizza);
		pizzaDao.saveNewPizza(nvPizza);
	}
	

}
