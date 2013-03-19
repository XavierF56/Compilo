public class Declaration implements YakaConstants{
	//private int constVar;
	private int type;
	private String nom;
	private int valeur;
	private String nomFonction;
	
	/*public void setConst(){ constVar = CONST;}
	public void setVar(){ constVar = VAR;}*/
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNomFonction(){
		return this.nomFonction;
	}
	
	public void setTypeEntier() {
		this.type = ENTIER;
	}
	
	public void setTypeBool() {
		this.type = BOOLEEN;
	}
	
	public void setValEntier(int val) {
		valeur = val;
		type = ENTIER;
	}
	
	public void setValFAUX() {
		valeur = 0;
		type = BOOLEEN;
	}
	
	public void setValVRAI() {
		valeur = -1;
		type = BOOLEEN;
	}
	
	public void setValIdent(String val){
		Ident id = Yaka.tabIdent.chercheIdent(val);
		type = id.getType();
		valeur = ((IdConst) id).getVal();
	}

	void ajoutIdentConst(){
		Yaka.tabIdent.rangeIdent(nom, new IdConst(type, valeur));
	}
	
	void ajoutIdentVar(String nom){
		Yaka.tabIdent.rangeIdent(nom, new IdVar(type));
	}
	
	void ajoutIdentFonc(String nom){
		Yaka.tabIdent.rangeIdentGlob(nom, new IdFonction(type, nom));
		nomFonction = nom;
	}
	
	void ajoutIdentParam(String nom){
		Yaka.tabIdent.chercheIdentGlob(nomFonction).addParam(type);
		Yaka.tabIdent.rangeIdent(nom, new IdParam(type));
		System.out.println(Yaka.tabIdent.toString());
	}
	
	/*void ajoutIdent(){
		Ident id;
		if (constVar == CONST){
			id = new IdConst(type, val);
		}
		else if ( constVar == VAR){
			id = new IdVar(type);
		}
		else{
			System.out.println("erreur dans declaration sur le type");
		}
		
	
		Yaka.tabIdent.rangeIdent(nom, id);
	}*/
	
	
}
