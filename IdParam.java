
public class IdParam extends Ident{
	private static int prochain_offset = 0;
	private boolean affecte;
	
	public IdParam (int t){
		super();
		super.type = t;
		super.offset = prochain_offset;
		prochain_offset += 2;
		affecte = false;
	}
	
	public void setAffecte(boolean affecte) {
		this.affecte = affecte;
	}
	
	public void raz(){prochain_offset = 0;}
	
	public String toString() {
		return "( Parametre : type : " + type + " ; offset : " + offset + ")";
	}
}