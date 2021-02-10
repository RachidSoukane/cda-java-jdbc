package exo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PaysDAOImp implements PaysDAO {
	private static final Logger logger = LoggerFactory.getLogger(PaysDAOImp.class);


	@Override
	public Pays creationPays(Pays pays) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				logger.info("connection success");



				PreparedStatement ps = c.prepareStatement("insert into pays (nom_pays,nombre_habitant) values (?,?); ",PreparedStatement.RETURN_GENERATED_KEYS);

				try {
					ps.setString(1, pays.getNomPays());
					ps.setInt(2, pays.getNombreHabitant());

					ps.executeUpdate();
					ResultSet resultat = ps.getGeneratedKeys();
					if (resultat.next()) {

						return pays;
					}
					
				} catch (SQLIntegrityConstraintViolationException e) {
//					System.out.println("Ce pays existe dèja");
					logger.error("pays dèja existant");
				}

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean suppressionPays(String nom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {

				PreparedStatement ps = c.prepareStatement("DELETE FROM PAYS WHERE NOM_PAYS=?");

					ps.setString(1, nom);

					ps.executeUpdate();
//					System.out.println("suppression OK !");
					return true;
				} catch (SQLException e) {
					logger.warn("erreur de suppression");			}
			}
			return false;
	}

	@Override
	public List<Pays> listePays() {
		List<Pays> listPays = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				
				PreparedStatement statement = c.prepareStatement("SELECT * FROM pays");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					listPays.add(new Pays(r.getInt("num_pays"),r.getString("nom_pays"), r.getInt("nombre_habitant")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listPays;
	}

}
