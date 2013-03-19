public class IdVar extends Ident {
	private static int prochain_offset;
	private boolean affecte;
	
	public IdVar (int t){
		super();
		super.type = t;
		prochain_offset -= 2;
		super.offset = prochain_offset;
		affecte = false;
	}
	
	public void setAffecte(boolean affecte) {
		this.affecte = affecte;
	}
	
	/**
	 * Methode utilise pour afficher ouvrePrinc
	 * @return
	 */
	public static int getPrinc(){return  prochain_offset;}
	
	public static void raz(){prochain_offset = 0;}
	
	public static int getNbVarL(){return  -prochain_offset;}
	/**
	 * Methode d'appel a la fonction iload de YVM
	 */
	public void yvm() {
		if (!affecte) {
			System.out.println("ERREUR ligne " + Yaka.ligne + " : une des variables utilisee dans l'expression n'a pas ete initialisee");
		}
		Yaka.yvm.iload(offset);
	}
	
	public String toString() {
		return "( type : " + type + " ; offset : " + offset + ")";
	}
}
