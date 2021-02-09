package exo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;
public class Main {
	private static boolean CONDITION_ARR�T = true;
	private static String request;
	private static String requestTest;
	private static PreparedStatement ps;
//	private static ResultSet resultatInt;
	private static ResultSet resultat;
	private static int crea;
	private static int num;
	// var pays
	private static String nomPays;
	private static int nombreVille;
	private static int nombreHabitant;
	// var ville
	private static String nomVille;
	private static int superficie;
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("chargement du driver OK !");
		} catch (ClassNotFoundException e) {
			System.out.println("echec chargement driver jdbc");
		}
		String url = "jdbc:mysql://localhost:3306/cda_bdd3?useSSL=false&serverTimezone=UTC";
		String user = "user3";
		String password = "user3";
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, user, password);
			System.out.println("Connection BDD OK !");
			System.out.println("****************\n");
			do {
				System.out.println("Menu :");
				System.out.println("Entrez '1' \tCr�er un pays");
				System.out.println("Entrez '2' \tCr�er une ville");
				System.out.println("Entrez '3' \tSupprimer un pays");
				System.out.println("Entrez '4' \tSupprimer une ville");
				System.out.println("Entrez '5' \tLister les pays");
				System.out.println("Entrez '6' \tLister les villes");
				System.out.println("Entrez '7' \t Pour sortir");
				System.out.print("\t>");
				Scanner sc = new Scanner(System.in);
				int i = sc.nextInt();
				switch (i) {
//				Cr�ation d'un pays
				case 1:
					connexion.setAutoCommit(false);
					try {
						request = "INSERT INTO pays (nom_pays,nombre_habitant,nombre_ville) VALUES(?,?,0);";
						ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
						System.out.print("Entrez le nom du pays :");
						nomPays = sc.next().toLowerCase();
						System.out.print("Entrez le nombre d'habitant :");
						nombreHabitant = sc.nextInt();
						ps.setString(1, nomPays);
						ps.setInt(2, nombreHabitant);
						crea = ps.executeUpdate();
						if (crea == 0) {
							System.out.println("Erreur");
						} else {
							resultat = ps.getGeneratedKeys();
							resultat.next();
							System.out.println("Cr�ation Ok !");
							System.out.println("id:" + resultat.getInt(1));
							System.out.println("pays : " + nomPays);
							System.out.println("nombre d'habitant : " + nombreHabitant);
						}
						connexion.commit();
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("Impossible de cr�er, ce pays existe d�ja");
					}
					break;
				// Cr�ation d'une ville
				case 2:
					connexion.setAutoCommit(false);
					try {
						request = "INSERT INTO ville (nom_ville,superficie,pays) VALUES(?,?,?);";
						ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
						System.out.print("Entrez le nom de ville :");
						nomVille = sc.next().toLowerCase();
						System.out.print("Entrez la superficie :");
						superficie = sc.nextInt();
						System.out.print("Entrez le nom du pays :");
						nomPays = sc.next().toLowerCase();
						ps.setString(1, nomVille);
						ps.setInt(2, superficie);
						ps.setString(3, nomPays);
						crea = ps.executeUpdate();
						if (crea == 0) {
							System.out.println("Erreur");
						} else {
							resultat = ps.getGeneratedKeys();
							resultat.next();
							System.out.println("\nCr�ation ville Ok !\n*******************************");
							System.out.println("id :" + resultat.getInt(1));
							System.out.println("Ville : " + nomVille);
							System.out.println("superficie : " + superficie);
							System.out.println("Pays: " + nomPays);
						}
						connexion.commit();
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("Impossible de cr�er, cette ville existe d�ja");
					}
					break;
				case 3: // supprimer un pays
					connexion.setAutoCommit(false);
					System.out.print("Entrez le nom du pays :");
					nomPays = sc.next().toLowerCase();
					request = "delete from pays where nom_pays =?;";
					ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(1, nomPays);
					crea = ps.executeUpdate();
					if (crea == 0) {
						System.out.println("Erreur");
					} else {
						resultat = ps.getGeneratedKeys();
						resultat.next();
						System.out.println("\nSupression Ok !\n*******************************");
					}
					connexion.commit();
					break;
				case 4:// supprimer une ville
					connexion.setAutoCommit(false);
					System.out.print("Entrez nom de ville :");
					nomVille = sc.next().toLowerCase();
					request = "delete from ville where nom_ville =?;";
					ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(1, nomVille);
					crea = ps.executeUpdate();
					if (crea == 0) {
						System.out.println("Erreur");
					} else {
						resultat = ps.getGeneratedKeys();
						resultat.next();
						System.out.println("\nSupression Ok !\n*******************************");
					}
					connexion.commit();
					break;
				case 5: // lister les pays
					request = "select * from pays;";
					ps = connexion.prepareStatement(request);
					resultat = ps.executeQuery();
					while (resultat.next()) {
						num = resultat.getInt(1);
						nomPays = resultat.getString(2);
						nombreHabitant = resultat.getInt(3);
						nombreVille = resultat.getInt(4);
						System.out.println(num + " " + nomPays + " " + nombreHabitant + " " + nombreVille);
					}
					break;
				case 6: // lister les villes
					request = "select * from ville;";
					ps = connexion.prepareStatement(request);
					resultat = ps.executeQuery();
					while (resultat.next()) {
						num = resultat.getInt(1);
						nomVille = resultat.getString(2);
						superficie = resultat.getInt(3);
						nomPays = resultat.getString(4);
						System.out.println(num + " " + nomVille + " " + superficie + " " + nomPays);
					}
					break;
				case 7:
					CONDITION_ARR�T = false;
					sc.close();
					System.out.println("A bientot !");
					break;
				default:
					break;
				}
			} while (CONDITION_ARR�T);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
	}
}