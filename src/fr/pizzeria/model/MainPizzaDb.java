package fr.pizzeria.model;

public class MainPizzaDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaMemDb pizzadb = new PizzaMemDb();
		//pizzadb.updatePizza("TST", new Pizza("TST","Update pizza SQL", 11.75, CategoriePizza.POISSON));
		//Pizza ptest = pizzadb.findPizzaByCode("TST");
		pizzadb.deletePizza("TST");
		//System.out.println(ptest.toString());  
		pizzadb.closeConnection();
	}

}
