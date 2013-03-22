public class IdConst extends Ident {
	protected int val;

	
	
	public IdConst (int t, int v){
		super();
		val = v;
		type = t;
		compteur++;

	}

	public int getVal() {
		return val;
	}	
	
	/**
	 * Methode d'appel a la fonction iconst de YVM
	 */
	public void yvm() {
		Yaka.yvm.iconst(val);
	}
	
	public String toString() {
		return "( type : " + type + " ; val : " + val + ")";
	}
	
	public void setAffecte(boolean affecte) {
		System.out.println("ERREUR ligne " + Yaka.ligne + " : '" + YakaTokenManager.identLu + "' n'est pas une variable");
	}
}
