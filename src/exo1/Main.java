package exo1;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLIntegrityConstraintViolationException;
//import java.sql.Statement;
//import java.util.Scanner;

public class Main {




	// var ville
//	private static String nomVille;
//	private static int superficie;

	public static void main(String[] args) {

		

		MyConnection.getConnection();
		Menu.menu();

			

//			do {
//				
//
//				switch (i) {
//
////				Création d'un pays
//				case 1:
//					connexion.setAutoCommit(false);
//					
//					try {
//						request = "INSERT INTO pays (nom_pays,nombre_habitant,nombre_ville) VALUES(?,?,0);";
//						ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//						System.out.print("Entrez le nom du pays :");
//						nomPays = sc.next().toLowerCase();
//						System.out.print("Entrez le nombre d'habitant :");
//						nombreHabitant = sc.nextInt();
//						ps.setString(1, nomPays);
//						ps.setInt(2, nombreHabitant);
//						crea = ps.executeUpdate();
//
//						if (crea == 0) {
//							System.out.println("Erreur");
//						} else {
//							resultat = ps.getGeneratedKeys();
//							resultat.next();
//							System.out.println("Création Ok !");
//							System.out.println("id:" + resultat.getInt(1));
//							System.out.println("pays : " + nomPays);
//							System.out.println("nombre d'habitant : " + nombreHabitant);
//						}
//						connexion.commit();
//						
//					} catch (SQLIntegrityConstraintViolationException e) {
//						System.out.println("Impossible de créer, ce pays existe dèja");
//					}
//					
//					
//					break;
//
//				// Création d'une ville
//				case 2:
//					connexion.setAutoCommit(false);
//					
//					try {
//						request = "INSERT INTO ville (nom_ville,superficie,pays) VALUES(?,?,?);";
//						ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//						System.out.print("Entrez le nom de ville :");
//						nomVille = sc.next().toLowerCase();
//						System.out.print("Entrez la superficie :");
//						superficie = sc.nextInt();
//						System.out.print("Entrez le nom du pays :");
//						nomPays = sc.next().toLowerCase();
//						ps.setString(1, nomVille);
//						ps.setInt(2, superficie);
//						ps.setString(3, nomPays);
//						crea = ps.executeUpdate();
//
//						if (crea == 0) {
//							System.out.println("Erreur");
//						} else {
//							resultat = ps.getGeneratedKeys();
//							resultat.next();
//							System.out.println("\nCréation ville Ok !\n*******************************");
//							System.out.println("id :" + resultat.getInt(1));
//							System.out.println("Ville : " + nomVille);
//							System.out.println("superficie : " + superficie);
//							System.out.println("Pays: " + nomPays);
//						}
//						
//						connexion.commit();
//					} catch (SQLIntegrityConstraintViolationException e) {
//						System.out.println("Impossible de créer, cette ville existe dèja");
//					}
//					
//
//					break;
//				case 3: // supprimer un pays
//
//					connexion.setAutoCommit(false);
//					
//					System.out.print("Entrez le nom du pays :");
//					nomPays = sc.next().toLowerCase();
//					request = "delete from pays where nom_pays =?;";
//					ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//					ps.setString(1, nomPays);
//					crea = ps.executeUpdate();
//					if (crea == 0) {
//						System.out.println("Erreur");
//					} else {
//						resultat = ps.getGeneratedKeys();
//						resultat.next();
//						System.out.println("\nSupression Ok !\n*******************************");
//					}
//					connexion.commit();
//					
//					break;
//				case 4:// supprimer une ville
//					
//					connexion.setAutoCommit(false);
//					System.out.print("Entrez nom de ville :");
//					nomVille = sc.next().toLowerCase();
//					request = "delete from ville where nom_ville =?;";
//					ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//					ps.setString(1, nomVille);
//					crea = ps.executeUpdate();
//					if (crea == 0) {
//						System.out.println("Erreur");
//					} else {
//						resultat = ps.getGeneratedKeys();
//						resultat.next();
//						System.out.println("\nSupression Ok !\n*******************************");
//					}
//					connexion.commit();
//					break;
//
//				case 5: // lister les pays
//					request = "select * from pays;";
//					ps = connexion.prepareStatement(request);
//					resultat = ps.executeQuery();
//					while (resultat.next()) {
//						num = resultat.getInt(1);
//						nomPays = resultat.getString(2);
//						nombreHabitant = resultat.getInt(3);
//						nombreVille = resultat.getInt(4);
//						System.out.println(num + " " + nomPays + " " + nombreHabitant + " " + nombreVille);
//					}
//					break;
//
//				case 6: // lister les villes
//					request = "select * from ville;";
//					ps = connexion.prepareStatement(request);
//					resultat = ps.executeQuery();
//					while (resultat.next()) {
//						num = resultat.getInt(1);
//						nomVille = resultat.getString(2);
//						superficie = resultat.getInt(3);
//						nomPays = resultat.getString(4);
//						System.out.println(num + " " + nomVille + " " + superficie + " " + nomPays);
//					}
//					break;
//				case 7:
//					CONDITION_ARRÊT = false;
//					sc.close();
//					System.out.println("A bientot !");
//					break;
//				default:
//					break;
//				}
//
//			} while (CONDITION_ARRÊT);

		

	}

}
