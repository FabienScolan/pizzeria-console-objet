package fr.pizzeria.console;

public class Pizza {
	public int id;
	public String code, libelle;
	public double prix;
	static int compteur;
	public Pizza(String code,String libelle,double prix){
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		id=compteur;
		compteur++;
		
	}
	public Pizza(int id,String code,String libelle,double prix){
		this(code, libelle,prix);
		this.id=id;
		
	}
}
