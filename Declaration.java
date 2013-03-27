public class Declaration implements YakaConstants{
	//private int constVar;
	private int type;
	private String nom;
	private int valeur;
	private String nomFonction;
	
	/*public void setConst(){ constVar = CONST;}
	public void setVar(){ constVar = VAR;}*/
	
	/**
	 * Setter du paramètre nom
     * @param String : nom
     * @return ne retourne rien (void)
     */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter du paramètre nomFonction
	 * @param aucun
	 * @return String : nom de la fonction
	 */
	public String getNomFonction(){
		return this.nomFonction;
	}
	
	/**
	 * Setter du type à la constante ENTIER
     * @param aucun
     * @return ne retourne rien (void)
     */
	public void setTypeEntier() {
		this.type = ENTIER;
	}
	/**
	 * Setter du type à la constante BOOLEEN
     * @param aucun
     * @return ne retourne rien (void)
     */
	public void setTypeBool() {
		this.type = BOOLEEN;
	}
	/**
	 * Setter d'une valeur entière
     * @param int : val (valeur stockée)
     * @return ne retourne rien (void)
     */
	public void setValEntier(int val) {
		valeur = val;
		type = ENTIER;
	}
	/**
	 * Setter d'une valeur booléenne à FAUX
     * @param aucun
     * @return ne retourne rien (void)
     */
	public void setValFAUX() {
		valeur = 0;
		type = BOOLEEN;
	}
	/**
	 * Setter d'une valeur booléenne à VRAI
     * @param aucun
     * @return ne retourne rien (void)
     */
	public void setValVRAI() {
		valeur = -1;
		type = BOOLEEN;
	}
	/**
	 * Setter d'une valeur à partir d'un Ident
     * @param int : val (valeur stockée)
     * @return ne retourne rien (void)
     */
	public void setValIdent(String val){
		Ident id = Yaka.tabIdent.chercheIdent(val);
		type = id.getType();
		valeur = ((IdConst) id).getVal();
	}
	/**
	 * Methode qui rajoute un Identconst à tabIdent
	 * @param aucun
	 * @return ne retourne rien (void)
	 */
	void ajoutIdentConst(){
		Yaka.tabIdent.rangeIdent(nom, new IdConst(type, valeur));
	}
	/**
	 * Methode qui rajoute un IdentVar à tabIdent
	 * @param aucun
	 * @return ne retourne rien (void)
	 */
	void ajoutIdentVar(String nom){
		Yaka.tabIdent.rangeIdent(nom, new IdVar(type));
	}
	/**
	 * Methode qui rajoute un IdentFonction à tabIdent
	 * @param aucun
	 * @return ne retourne rien (void)
	 */
	void ajoutIdentFonc(String nom){
		Yaka.tabIdent.rangeIdentGlob(nom, new IdFonction(type, nom));
		nomFonction = nom;
	}
	/**
	 * Methode qui rajoute un IdentParam à tabIdent
	 * @param aucun
	 * @return ne retourne rien (void)
	 */
	void ajoutIdentParam(String nom){
		Yaka.tabIdent.chercheIdentGlob(nomFonction).addParam(type);
		Yaka.tabIdent.rangeIdent(nom, new IdParam(type));
		//System.out.println(Yaka.tabIdent.toString());
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
