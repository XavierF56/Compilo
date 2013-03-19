import java.util.ArrayList;

public class IdFonction extends Ident implements YakaConstants{
	private String nom = "";
	private int resultat;
	private ArrayList<Integer> parametre = new ArrayList<Integer>();
	

	public IdFonction (int type, String nom){
		super();
		this.nom = nom;
		this.resultat = type;
	}
	
	public void setResultat (int res) {
		resultat = res;
	}
	
	public int getResultat() {
		return resultat;
	}
	
	public void addParam (int type) {
		parametre.add(type);
	}

	public int taille (){
		return (parametre.size() * 2 );
	}
	
	public int getParam(int index){
		if (index > parametre.size()) {
			System.out.println("ERREUR ligne " + Yaka.ligne + " : Le nombre d'arguments de la fonction " + nom + " est de " + parametre.size());
			return ERREUR;
		}
		return parametre.get(index);
	}
	
	public int getTaille() {
		return parametre.size();
	}
	
	public String getNom() {
		return nom;
	}

	public String toString() {
		return ("resultat : " + resultat + "/parametres : " + parametre);
	}
}
