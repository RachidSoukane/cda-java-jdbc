package exo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	private static String url = "jdbc:mysql://localhost:3306/cda_bdd3?useSSL=false&serverTimezone=UTC";
	private static String utilisateur = "user3";
	private static String motDePasse = "user3";
	static Connection connexion = null;

	private MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			connexion.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connexion == null) {
			new MyConnection();
			System.out.println("Connection BDD OK !");
			System.out.println("****************\n");
		}
		return connexion;
	}

	public static void stop() {
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}