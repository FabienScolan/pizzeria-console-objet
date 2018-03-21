package fr.pizzeria.model;

public class Pizza {
	private int id;
	private String code, libelle;
	private double prix;
	static int compteur;
	private CategoriePizza typePizza;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Pizza(String code, String libelle, double prix, CategoriePizza typePizza) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.typePizza=typePizza;
		id = compteur;
		compteur++;

	}

	public Pizza(int id, String code, String libelle, double prix, CategoriePizza typePizza) {
		this(code, libelle, prix, typePizza);
		this.id = id;

	}

	public CategoriePizza getTypePizza() {
		return typePizza;
	}

	public void setTypePizza(CategoriePizza typePizza) {
		this.typePizza = typePizza;
	}

	@Override
	public String toString() {
		return code + " -> " + libelle + " (" + prix + "€)" + " type : " + typePizza.getType();
	}

}
