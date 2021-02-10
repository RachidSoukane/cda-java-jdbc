package exo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class VilleDAOImp implements VilleDAO {

	@Override
	public Ville creationVille(Ville ville) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {

				PreparedStatement ps = c.prepareStatement(
						"insert into ville (nom_ville,superficie,pays) values (?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				try {
					ps.setString(1, ville.getNomVille());
					ps.setInt(2, ville.getSuperficie());
					ps.setString(3, ville.getPays());
					ps.executeUpdate();

					ResultSet resultat = ps.getGeneratedKeys();
					if (resultat.next()) {

						return ville;
					}

				} catch (SQLIntegrityConstraintViolationException e) {
					System.out.println("Cette ville existe dèja");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public boolean suppressionVille(String nom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {

				PreparedStatement ps = c.prepareStatement("DELETE FROM VILLE WHERE NOM_VILLE=?");

				ps.setString(1, nom);
				ps.executeUpdate();
//					System.out.println("suppression OK !");
				return true;
			} catch (SQLException e) {
//					System.out.println("erreur");
			}
		}
		return false;
	}

	@Override
	public List<Ville> listeVille() {
		List<Ville> listVille = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {

				PreparedStatement statement = c.prepareStatement("SELECT * FROM ville");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					listVille.add(new Ville(r.getInt("num"), r.getString("nom_ville"), r.getInt("superficie"),
							r.getString("pays")));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listVille;
	}

}
