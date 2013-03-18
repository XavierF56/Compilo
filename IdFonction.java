import java.util.ArrayList;

public class IdFonction extends Ident {

	private int resultat;
	private ArrayList<Integer> parametre = new ArrayList();
	
	public void setResultat (int res) {
		resultat = res;
	}
	
	public void addParam (int type) {
		parametre.add(type);
	}

	public String toString() {
		return ("resultat : " + resultat + "les parametres : " + parametre);
	}
		
}
