package exo1;

import java.util.List;

public interface PaysDAO {

	public Pays creationPays(Pays pays);
	
	public void suppressionPays(Pays pays);
	
	public List<Pays> listePays();

}
