package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaConsoleAdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n**** Pizzeria Administration ****");
		System.out.println("\n1. Lister les pizzas");
		System.out.println("\n2. Ajouter une nouvelle pizza");
		System.out.println("\n3. Mettre à jour une pizza");
		System.out.println("\n4. Supprimer une pizza");
		System.out.println("\n99. Sortir");
		int option;
		Scanner questionUser = new Scanner(System.in);
		option = questionUser.nextInt();
		while (option != 99) {
			switch (option) {
			case 1:
				System.out.println("\nListe des pizzas");
				break;
			case 2:
				System.out.println("\nAjout d'une nouvelle pizza");
				break;
			case 3:
				System.out.println("\nMise à jour de la pizza");
				break;
			case 4:
				System.out.println("\nSuppression de la pizza");
				break;
			}
				System.out.println("\n**** Pizzeria Administration ****");
				System.out.println("\n1. Lister les pizzas");
				System.out.println("\n2. Ajouter une nouvelle pizza");
				System.out.println("\n3. Mettre à jour une pizza");
				System.out.println("\n4. Supprimer une pizza");
				System.out.println("\n99. Sortir");
				option = questionUser.nextInt();
			
		}
		System.out.println("\nAu revoir ☹");
		questionUser.close();
	}

}
