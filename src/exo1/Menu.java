package exo1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {
	private static boolean CONDITION_ARRÊT = true;		
	static Logger logger = LoggerFactory.getLogger(Menu.class);

	
	
	
	public static void menu() {

		PaysDAO nouveauPays = new PaysDAOImp();
		VilleDAO nouvelleVille = new VilleDAOImp();
		Scanner scannerMenu = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int menuRep = 0;
				
		do {
			listMenu();
			try {
				menuRep = scannerMenu.nextInt();

			} catch (InputMismatchException e) {
				scannerMenu.nextLine();
//				System.out.println("erreur de saisie");
				logger.warn("erreur de saisie");
				continue;
			}
			
			switch (menuRep) {

			case 1://			Création d'un pays
				System.out.print("Entrez le nom du pays");
				System.out.print("  < ");
				String nomPays = scanner.next().toLowerCase();
				System.out.print("Entrez le nombre d'habitant");
				System.out.print("  < ");
				int nombreHabitant = scanner.nextInt();
				Pays p = nouveauPays.creationPays(new Pays(nomPays,nombreHabitant));
				
				if (p != null) {
					System.out.println("\n  > Pays créé avec succès ("+p.getNomPays()+")");
				}
				break;
				
			case 2://			Création d'une ville
				
				System.out.print("Entrez le nom de la ville");
				System.out.print("  < ");
				String nomVille = scanner.next().toLowerCase();
				System.out.print("Entrez une superficie");
				System.out.print("  < ");
				int superficie = scanner.nextInt();
				System.out.print("Entrez le nom de pays");
				System.out.print("  < ");
				String pays = scanner.next().toLowerCase();
				Ville v = nouvelleVille.creationVille(new Ville(nomVille,superficie,pays));
				
				if (v != null) {
					System.out.println("\n  > Ville créé avec succès ("+v.getNomVille()+")");
				}
				break;
				
			case 3://			Suppression d'un pays
				
				System.out.print("Entrez le nom du pays :");
				System.out.print("  < ");
				String nomP = scanner.next().toLowerCase();
				boolean suppressionPays = nouveauPays.suppressionPays(nomP);
				
				if (suppressionPays) {
					System.out.println("  > ("+nomP+") supprimé avec succés");
				} else {
					System.out.println("  > ! ERREUR : ce pays n'existe pas");
				}
				break;
				
			case 4://			Suppression d'une ville
				
				System.out.print("Entrez le nom de la ville :");
				System.out.print("  < ");
				String nomV = scanner.next().toLowerCase();
				boolean suppressionVille = nouvelleVille.suppressionVille(nomV);
				
				if (suppressionVille) {
					System.out.println("  > ("+nomV+") supprimé avec succés");
				} else {
					System.out.println("  > ! ERREUR : cette ville n'existe pas");
				}
				break;

			case 5:
				
				List<Pays> allPays = nouveauPays.listePays();
				if(allPays.isEmpty()) {
					System.out.println("  > aucun pays !");
				} else {
					allPays.stream().forEach(e->{
						System.out.println("  > "+e);
					});
				}
				
				break;
				
			case 6:
				
				List<Ville> allVille = nouvelleVille.listeVille();
				if(allVille.isEmpty()) {
					System.out.println("  > aucune ville !");
				} else {
					allVille.stream().forEach(e->{
						System.out.println("  > "+e);
					});
				}
				
				break;
				
			case 7:
				CONDITION_ARRÊT = false;
				scannerMenu.close();
				scanner.close();
				System.out.println("A bientot !");
				break;
			default:
				break;
		}
			

		} while (CONDITION_ARRÊT);

	}
	
	
	private static void listMenu() {
		System.out.println("Menu :");
		System.out.println("Entrez '1' \tCréer un pays");
		System.out.println("Entrez '2' \tCréer une ville");
		System.out.println("Entrez '3' \tSupprimer un pays");
		System.out.println("Entrez '4' \tSupprimer une ville");
		System.out.println("Entrez '5' \tLister les pays");
		System.out.println("Entrez '6' \tLister les villes");
		System.out.println("Entrez '7' \t Pour sortir");
		System.out.print("\t>");
	}
	
}
