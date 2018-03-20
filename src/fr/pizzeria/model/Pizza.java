package fr.pizzeria.model;

public class Pizza {
	private int id;
	private String code, libelle;
	private double prix;
	static int compteur;

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

	public Pizza(String code, String libelle, double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		id = compteur;
		compteur++;

	}

	public Pizza(int id, String code, String libelle, double prix) {
		this(code, libelle, prix);
		this.id = id;

	}

	@Override
	public String toString() {
		return code + " -> " + libelle + " (" + prix + "€)";
	}

}
