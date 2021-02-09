package exo1;

import java.util.Scanner;

public class Menu {

	private static boolean CONDITION_ARRÊT = true;
	static Scanner scannerMenu = new Scanner(System.in);
	PaysDAOImp nouveauPays = new PaysDAOImp();


	public static void menu() {

		int menuRep ;

		do {
			System.out.println("Menu :");
			System.out.println("Entrez '1' \tCréer un pays");
			System.out.println("Entrez '2' \tCréer une ville");
			System.out.println("Entrez '3' \tSupprimer un pays");
			System.out.println("Entrez '4' \tSupprimer une ville");
			System.out.println("Entrez '5' \tLister les pays");
			System.out.println("Entrez '6' \tLister les villes");
			System.out.println("Entrez '7' \t Pour sortir");
			System.out.print("\t>");
			
			 menuRep = scannerMenu.nextInt();
			
			switch (menuRep) {

//			Création d'un pays
			case 1:

//				nouveauPays.creationPays();
				
//				Menu.menu();

				
				
				break;

				
				
				
				
//			// Création d'une ville
//			case 2:
//				connexion.setAutoCommit(false);
//				
//				try {
//					request = "INSERT INTO ville (nom_ville,superficie,pays) VALUES(?,?,?);";
//					ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//					System.out.print("Entrez le nom de ville :");
//					nomVille = sc.next().toLowerCase();
//					System.out.print("Entrez la superficie :");
//					superficie = sc.nextInt();
//					System.out.print("Entrez le nom du pays :");
//					nomPays = sc.next().toLowerCase();
//					ps.setString(1, nomVille);
//					ps.setInt(2, superficie);
//					ps.setString(3, nomPays);
//					crea = ps.executeUpdate();
		//
//					if (crea == 0) {
//						System.out.println("Erreur");
//					} else {
//						resultat = ps.getGeneratedKeys();
//						resultat.next();
//						System.out.println("\nCréation ville Ok !\n*******************************");
//						System.out.println("id :" + resultat.getInt(1));
//						System.out.println("Ville : " + nomVille);
//						System.out.println("superficie : " + superficie);
//						System.out.println("Pays: " + nomPays);
//					}
//					
//					connexion.commit();
//				} catch (SQLIntegrityConstraintViolationException e) {
//					System.out.println("Impossible de créer, cette ville existe dèja");
//				}
//				
		//
//				break;
//			case 3: // supprimer un pays
		//
//				connexion.setAutoCommit(false);
//				
//				System.out.print("Entrez le nom du pays :");
//				nomPays = sc.next().toLowerCase();
//				request = "delete from pays where nom_pays =?;";
//				ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//				ps.setString(1, nomPays);
//				crea = ps.executeUpdate();
//				if (crea == 0) {
//					System.out.println("Erreur");
//				} else {
//					resultat = ps.getGeneratedKeys();
//					resultat.next();
//					System.out.println("\nSupression Ok !\n*******************************");
//				}
//				connexion.commit();
//				
//				break;
//			case 4:// supprimer une ville
//				
//				connexion.setAutoCommit(false);
//				System.out.print("Entrez nom de ville :");
//				nomVille = sc.next().toLowerCase();
//				request = "delete from ville where nom_ville =?;";
//				ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//				ps.setString(1, nomVille);
//				crea = ps.executeUpdate();
//				if (crea == 0) {
//					System.out.println("Erreur");
//				} else {
//					resultat = ps.getGeneratedKeys();
//					resultat.next();
//					System.out.println("\nSupression Ok !\n*******************************");
//				}
//				connexion.commit();
//				break;
		//
//			case 5: // lister les pays
//				request = "select * from pays;";
//				ps = connexion.prepareStatement(request);
//				resultat = ps.executeQuery();
//				while (resultat.next()) {
//					num = resultat.getInt(1);
//					nomPays = resultat.getString(2);
//					nombreHabitant = resultat.getInt(3);
//					nombreVille = resultat.getInt(4);
//					System.out.println(num + " " + nomPays + " " + nombreHabitant + " " + nombreVille);
//				}
//				break;
		//
//			case 6: // lister les villes
//				request = "select * from ville;";
//				ps = connexion.prepareStatement(request);
//				resultat = ps.executeQuery();
//				while (resultat.next()) {
//					num = resultat.getInt(1);
//					nomVille = resultat.getString(2);
//					superficie = resultat.getInt(3);
//					nomPays = resultat.getString(4);
//					System.out.println(num + " " + nomVille + " " + superficie + " " + nomPays);
//				}
//				break;
			case 7:
				CONDITION_ARRÊT = false;
				scannerMenu.close();
				System.out.println("A bientot !");
				break;
			default:
				break;
		}
			

		} while (CONDITION_ARRÊT);

	}
}
