package exo1;

public class Pays {
	
	private String nomPays;
	private int nombreVille;
	private int nombreHabitant;
	
	
	public Pays(String nomPays, int nombreVille, int nombreHabitant) {
		this.nomPays = nomPays;
		this.nombreVille = nombreVille;
		this.nombreHabitant = nombreHabitant;
	}


	public String getNomPays() {
		return nomPays;
	}


	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}


	public int getNombreVille() {
		return nombreVille;
	}


	public void setNombreVille(int nombreVille) {
		this.nombreVille = nombreVille;
	}


	public int getNombreHabitant() {
		return nombreHabitant;
	}


	public void setNombreHabitant(int nombreHabitant) {
		this.nombreHabitant = nombreHabitant;
	}
}
	
	
	
	
	

//private static String request;
//private static PreparedStatement ps;
//private static ResultSet resultat;
//private static int crea;
////private static int num;
//
//// var pays
//private static String nomPays;
//private static int nombreVille;
//private static int nombreHabitant;
//
//static Scanner scannerPays = new Scanner(System.in);
//
//static void creationPays() {
//	
//	try {
//		MyConnection.connexion.beginRequest();
//		
//		try {
//			request = "INSERT INTO pays (nom_pays,nombre_habitant,nombre_ville) VALUES(?,?,0);";
//			ps = MyConnection.connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//			
//			System.out.print("Entrez le nom du pays :");
//			nomPays = scannerPays.next().toLowerCase();
//			System.out.print("Entrez le nombre d'habitant :");
//			nombreHabitant = scannerPays.nextInt();
//			ps.setString(1, nomPays);
//			ps.setInt(2, nombreHabitant);
//			crea = ps.executeUpdate();
//
//			if (crea == 0) {
//				System.out.println("Erreur");
//				MyConnection.connexion.rollback();
//
//			} else {
//				resultat = ps.getGeneratedKeys();
//				resultat.next();
//				System.out.println("Création Ok !");
//				System.out.println("id:" + resultat.getInt(1));
//				System.out.println("pays : " + nomPays);
//				System.out.println("nombre d'habitant : " + nombreHabitant);
//				MyConnection.connexion.commit();
//				
//			}
//
//		} catch (SQLIntegrityConstraintViolationException e) {
//			System.out.println("Impossible de créer, ce pays existe dèja");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	} catch (SQLException e1) {
//		e1.printStackTrace();
//	} 
//	
//	
//	
//	
//
//}


