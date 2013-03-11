import java.util.* ;

public class TabIdent implements YakaConstants{
	private HashMap<String,Ident> table;
	
	public TabIdent(){
		table = new HashMap<String,Ident>();
	}
	
	/*Si Ident la clef n'est pas presente dans la Map on renvoit 
	 * un ident ayant pour type erreur.
	 *
	 */
	public Ident chercheIdent (String clef){
		Ident id;
		if (!this.existeIdent(clef)) {
			id = new IdConst(ERREUR, 0);
		} else {
			id = table.get(clef); 
		}
		return id;
	}
	
	public boolean existeIdent (String clef) {
		return table.containsKey(clef);
	}
	public void rangeIdent (String clef, Ident id)
	{
		table.put(clef,id);
	}
	
	
	
	public String toString() {
		return "TabIdent : " + table.toString();
	}
	
}
