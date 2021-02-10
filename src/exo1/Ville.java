package exo1;

public class Ville {
	
	private int num;
	private String nomVille;
	private int superficie;
	private String pays;
	
	public Ville() {
		super();
	}

	public Ville(int num, String nomVille, int superficie, String pays) {
		super();
		this.num = num;
		this.nomVille = nomVille;
		this.superficie = superficie;
		this.pays = pays;
	}

	public Ville(String nomVille, int superficie, String pays) {
		super();
		this.nomVille = nomVille;
		this.superficie = superficie;
		this.pays = pays;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Ville [num=" + num + ", nomVille=" + nomVille + ", superficie=" + superficie + ", pays=" + pays + "]";
	}

	
}
