public class Ident {
	protected int offset = 0;
	protected int type;	
	protected static int compteur = 0;	
	
	public int getType() {
		return type;
	}
	
	public void yvm() {
		
	}
	
	/**
	 * Methode pour obtenir l'offset de l'ident
	 * Si l'ident est un IdConst, retourne 2
	 */
	public int getOffset() {
		return offset;
	}
	
	public void setAffecte(boolean affecte) {
	}
	
	public static int getCompteur() {
		return compteur;
	}
	public static void razCompteur() {
		compteur = 0;
	}
}
