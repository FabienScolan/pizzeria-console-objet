package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaMemDao implements IPizzaDao {

	List<Pizza> pizzas;

	public PizzaMemDao() {
		pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza(0, "PEP", "Peperroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(4, "CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(6, "ORI", "L'Orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(7, "IND", "L'Indienne", 14.00, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		if (pizza != null) pizzas.add(pizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		if (this.pizzaExists(codePizza) && pizza!=null) {
			Pizza oldPizza = findPizzaByCode(codePizza);
			oldPizza.setCode(pizza.getCode());
			oldPizza.setLibelle(pizza.getLibelle());
			oldPizza.setPrix(pizza.getPrix());
			oldPizza.setTypePizza(pizza.getTypePizza());
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		if (this.pizzaExists(codePizza)) {
			pizzas.remove(findPizzaByCode(codePizza));
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for (Pizza pizza : pizzas) {
			if (pizza != null && pizza.getCode().equals(codePizza))
				return pizza;
		}

		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return (findPizzaByCode(codePizza) != null);
	}

}
