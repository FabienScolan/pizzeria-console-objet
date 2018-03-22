package fr.pizzeria.model;

import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;
import fr.pizzeria.validator.Rule;

public class Pizza {
	@ToString
	private int id;
	@Rule(length=4)
	@ToString(toUpperCase=true, separateur= " -> ")
	private String code;
	@ToString(separateur= " -> ")
	private String libelle;
	@Rule(min=0)
	@ToString (separateur= " : ")
	private double prix;
	static int compteur;
	@ToString
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
		this.typePizza = typePizza;
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
		/*Class<?> c1 = this.getClass(); 
		Field[] attributes = c1.getDeclaredFields();
		String chaine = "";
		try {
			for (Field attr: attributes){
				if (attr.isAnnotationPresent(ToString.class)){
					ToString annotation = attr.getAnnotation(ToString.class);
					boolean upperCase = annotation.toUpperCase();
					String separ = annotation.separateur();
					Object attrValue = attr.get(this);
					if (upperCase) attrValue = attrValue.toString().toUpperCase();
					chaine+= attrValue + separ;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		return StringUtils.generateString(this);
	}

}
