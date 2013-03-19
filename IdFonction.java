import java.util.ArrayList;

public class IdFonction extends Ident {

	private int resultat;
	private ArrayList<Integer> parametre = new ArrayList();
	
	public void setResultat (int res) {
		resultat = res;
	}
	
	public int getResultat() {
		return resultat;
	}
	
	public void addParam (int type) {
		parametre.add(type);
	}
	
	public int getParam(int index){
		if (index > parametre.size()) {
			System.out.println("ERREUR ligne " + Yaka.ligne + " : Le nombre d'arguments de la fonction " +"?" + " est de " + parametre.size()); );
			return ERREUR;
		}
		return parametre.get(index);
	}
	
	public int getTaille() {
		return parametre.size();
	}
	
	

	public String toString() {
		return ("resultat : " + resultat + "les parametres : " + parametre);
	}
		
}
