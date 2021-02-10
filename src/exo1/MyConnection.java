package exo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLNonTransientConnectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConnection {

	private static String url = "jdbc:mysql://localhost:3306/cda_bdd3?useSSL=false&serverTimezone=UTC";
	private static String utilisateur = "user3";
	private static String motDePasse = "user3";
	static Connection connexion = null;
	static Logger logger = LoggerFactory.getLogger(Main.class);


	private MyConnection() throws SQLNonTransientConnectionException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (Exception e) {
			logger.error("connection error");
		}
	}

	public static Connection getConnection() {
		if (connexion == null) {
			try {
				new MyConnection();
			} catch (SQLNonTransientConnectionException e) {
				logger.error("connection failed");
			}

		}
		return connexion;
	}

//	public static void stop() {
//		if (connexion != null) {
//			try {
//				connexion.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

}