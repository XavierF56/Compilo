import java.util.* ;

public class TabIdent implements YakaConstants{
	private HashMap<String,IdFonction> globaux;
	private HashMap<String,Ident> locaux;
	private Stack<IdParam> pileParams;
	
	public TabIdent(){
		globaux = new HashMap<String,IdFonction>();
		locaux = new HashMap<String,Ident>();
		pileParams = new Stack<IdParam>();
	}
	
	/**
	 * Si Ident la clef n'est pas presente dans la Map on renvoit 
	 * un ident ayant pour type erreur.
	 */
	public Ident chercheIdent (String clef){
		Ident id;
		if (!locaux.containsKey(clef)) {
			id = new IdConst(ERREUR, 0);
			System.out.println("ERREUR ligne " + Yaka.ligne + " : l'element '" + clef + "' n'est pas declare");
			this.rangeIdent(clef, id);
		} else {
			id = locaux.get(clef); 
		}
		return id;
	}
	
	public IdFonction chercheIdentGlob (String clef){
		if (!globaux.containsKey(clef)) {
			System.out.println("ERREUR ligne " + Yaka.ligne + " : la fonction '" + clef + "' n'existe pas");
			return null;
		} else {
			return globaux.get(clef); 
		}
	}
	
	public void rangeIdent (String clef, Ident id)
	{
		if (locaux.containsKey(clef)) {
			System.out.println("ERREUR ligne " + Yaka.ligne + " : l'element '" + clef + "' est deja declare");
		} else {
			if(id instanceof IdParam){
				pileParams.push((IdParam)id);
			}
			locaux.put(clef,id);
		}
	}
	
	public void rangeIdentGlob (String clef, IdFonction id)
	{
		if (globaux.containsKey(clef)) {
			System.out.println("ERREUR ligne " + Yaka.ligne + " : la fonction '" + clef + "' est deja declaree");
		} else {
			globaux.put(clef,id);
		}
	}
	
	public boolean isIdFonction(String cle) {
		return globaux.containsKey(cle);
	}
	
	
	
	public String toString() {
		return "locaux : " + locaux.toString() + "\nGlobaux : " + globaux.toString()+"\n";
	}
	
	public void raz() {
		locaux.clear();
		IdParam.raz();
		IdVar.raz();
		Ident.razCompteur();
		IdParam.razCompteur();
	}
	
	public void setOffsets(){
		while(!(pileParams.isEmpty())){
			pileParams.pop().setOffset();
		}
	}
	
}
