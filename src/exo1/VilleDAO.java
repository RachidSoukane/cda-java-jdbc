package exo1;

import java.util.List;

public interface VilleDAO {
	
	Ville creationVille(Ville ville);
	
	boolean suppressionVille(String nom);
	
	List<Ville> listeVille();

}
