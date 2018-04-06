package fr.pizzeria.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PizzaMemDb implements IPizzaDao {

	Connection myConnection;

	public PizzaMemDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("url"),
					ResourceBundle.getBundle("jdbc").getString("user"),
					ResourceBundle.getBundle("jdbc").getString("pass"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		List<Pizza> pizzas = new ArrayList<Pizza>();
		Statement requete = null;
		ResultSet resultat = null;
		try {
			createConnection();
			requete = myConnection.createStatement();
			resultat = requete.executeQuery("SELECT * FROM pizzas");
			while (resultat.next()) {
				Pizza p = new Pizza(resultat.getInt("ID"), resultat.getString("code"), resultat.getString("libelle"),
						resultat.getDouble("prix"), CategoriePizza.valueOf(resultat.getString("type_pizza")));
				pizzas.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				requete.close();
				resultat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);

			}
		}

		return pizzas;
	}

	public void saveNewPizza(Pizza pizza) {
		PreparedStatement requete = null;
		if (pizza != null) {
			try {
				createConnection();
				requete = myConnection.prepareStatement("INSERT INTO pizzas(code,libelle,prix,type_pizza) VALUES(?,?,?,?)");
				requete.setString(1, pizza.getCode());
				requete.setString(2, pizza.getLibelle());
				requete.setDouble(3, pizza.getPrix());
				requete.setString(4, pizza.getTypePizza().getType());
				requete.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} finally {
				try {
					requete.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}

		}

	}

	public void updatePizza(String codePizza, Pizza pizza) {
		PreparedStatement requete = null;
		if (this.pizzaExists(codePizza) && pizza != null) {
			try {
				createConnection();
				requete = myConnection
						.prepareStatement("UPDATE pizzas SET code=?,libelle=?,prix=?,type_pizza=? WHERE code=?");
				requete.setString(1, pizza.getCode());
				requete.setString(2, pizza.getLibelle());
				requete.setDouble(3, pizza.getPrix());
				requete.setString(4, pizza.getTypePizza().getType());
				requete.setString(5, codePizza);
				requete.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} finally {
				try {
					requete.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		}

	}

	public void deletePizza(String codePizza) {
		PreparedStatement requete = null;
		try {
			createConnection();
			requete = myConnection.prepareStatement("DELETE FROM pizzas WHERE code=?");
			requete.setString(1, codePizza);
			requete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				requete.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	}

	public Pizza findPizzaByCode(String codePizza) {
		Pizza p = null;
		PreparedStatement requete = null;
		try {
			createConnection();
			requete = myConnection.prepareStatement("SELECT * FROM pizzas WHERE code=?");
			requete.setString(1, codePizza);
			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {
				p = new Pizza(resultat.getInt("ID"), resultat.getString("code"), resultat.getString("libelle"),
						resultat.getDouble("prix"), CategoriePizza.valueOf(resultat.getString("type_pizza").toUpperCase()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				requete.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
		return p;
	}

	public boolean pizzaExists(String codePizza) {

		return findPizzaByCode(codePizza) != null;
	}

	public void createConnection() {

		try {
			if (myConnection.isClosed())
				myConnection = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("url"),
						ResourceBundle.getBundle("jdbc").getString("user"),
						ResourceBundle.getBundle("jdbc").getString("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public void closeConnection(){
		try {
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
