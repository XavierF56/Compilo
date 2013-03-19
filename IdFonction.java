import java.util.ArrayList;

public class IdFonction extends Ident {

	private int resultat;
	private ArrayList<Integer> parametre = new ArrayList();
	
	public IdFonction (int t){
		super();
		super.type = t;
	}
	
	
	public void setResultat (int res) {
		resultat = res;
	}
	
	public void addParam (int type) {
		parametre.add(type);
	}
	public int taille (){
		return (parametre.size() * 2 );
	}
	
	public String toString() {
		return ("resultat : " + resultat + "les parametres : " + parametre);
	}
		
}
