package exo1;

import java.util.List;

public interface PaysDAO {

	Pays creationPays(Pays pays);
	
	 
	
	boolean suppressionPays(String nom);
	
	List<Pays> listePays();

}
