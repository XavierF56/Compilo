import java.util.Stack;


public class Expression implements YakaConstants {
	private Stack<Integer> pileOperandes;
	private Stack<Integer> pileOperateurs ;
	private int affectation = 0;
	int affoff = 0;
	
	public Expression(){
		pileOperandes = new Stack<Integer>();
		pileOperateurs =  new Stack<Integer>();
		
	}
	
	public boolean controleType(){
		int a,b, op = 0;
		System.out.println(pileOperandes);
		//System.out.println(pileOperateurs);

		//1ere cas : fin
		if((pileOperandes.size() == 1) && (pileOperateurs.size() == 0)) {
			a = pileOperandes.pop();
			if (a == ERREUR){
				System.out.println("ERREUR d'evaluation de l'expression / ligne : " + Yaka.ligne);
				return false;
				}
			else return true ;
		}

		//3eme cas autres operation
		b = pileOperandes.pop();
		op = pileOperateurs.pop();
		a = pileOperandes.pop();
		
		
		if ((a == BOOLEEN) &&( b == BOOLEEN)) { 
			
			if (estOperateurEg(op) || estOperateurLogique(op)){
					pileOperandes.push(BOOLEEN);
					return true;
			}
			else {
					pileOperandes.push(ERREUR);
					return false;
			}	
		} else if ((a == ENTIER) && (b == ENTIER)) {
			if (estOperateurCalcul(op)){
				pileOperandes.push(ENTIER);
				//System.out.println(pileOperandes);
				return true ;
			}
			if (estOperateurComp(op) || estOperateurEg(op))
			{
				pileOperandes.push(BOOLEEN);
				return true;
			}
			else {
				pileOperandes.push(ERREUR);
				return false;
			}
		} else {
			pileOperandes.push(ERREUR);
			return false;
		}
	}
	
	public boolean controleTypeNEG(){
		int a = pileOperandes.pop();
		int op = pileOperateurs.pop();
			if ((op == NEG) && (a == ENTIER)){
				pileOperandes.push(ENTIER);
				return true;
			}else if ((op == NON) && (a == BOOLEEN)){
				pileOperandes.push(BOOLEEN);
				return true;
			} else {
				pileOperandes.push(ERREUR);
				return false;
			}
	}

	// Indique si notre operateur est "+ ou - ou * ou / 
	public boolean estOperateurCalcul(int op) {
		return (op == PLUS || op == MOINS || op == MULT || op == DIV);
	}
	public boolean estOperateurComp (int op) {
		return (op == INF ||op == SUP || op == INFOUEG || op == SUPOUEG );
	}
	public boolean estOperateurEg (int op) {
		return (op == EGAL || op == DIFFERENT);
	}
	public boolean estOperateurLogique (int op) {
		return (op == ET || op == OU);
	}
	
	// Empiler : Permet d'orienter sur les Piles les valeurs ou les opérateurs.
	public void empiler(int i){
		switch (i)  {
		case PLUS :  pileOperateurs.add(i);
			break;
		case MOINS : pileOperateurs.add(i);
			break;
		case DIV : pileOperateurs.add(i);
			break;
		case MULT : pileOperateurs.add(i);
			break;
		case INF : pileOperateurs.add(i);
			break;
		case SUP : pileOperateurs.add(i);
			break;
		case INFOUEG : pileOperateurs.add(i);
			break;
		case SUPOUEG : pileOperateurs.add(i);
			break;
		case EGAL : pileOperateurs.add(i);
			break;
		case DIFFERENT : pileOperateurs.add(i);
			break;
		case NON : pileOperateurs.add(i);
			break;
		case NEG : pileOperateurs.add(i);
			break;
		case ET : pileOperateurs.add(i);
			break;
		case OU : pileOperateurs.add(i);
			break;
		case VRAI : pileOperandes.add(BOOLEEN);
			break;
		case FAUX : pileOperandes.add(BOOLEEN);
			break;
		case ENTIER : pileOperandes.add(ENTIER);
			break;
		case BOOLEEN : pileOperandes.add(BOOLEEN);
			break;
		default : pileOperandes.add(ERREUR);
			break;
		}
	}
	
	public void clotureExpression(){
		int last = pileOperandes.pop();
		//System.out.println("affoff = " + affoff);

		if (last == ERREUR){
			System.out.println("================---> ERREUR d'evaluation de l'expression lors de laffectation / ligne : " + Yaka.ligne);
		} else if (affoff == 2) {
			System.out.println("================---> ERREUR nest pas une variable / ligne : " + Yaka.ligne);
		}else if (affectation > 0) {
			if(!(affectation == last)){
				System.out.println("================---> ERREUR d'affectation de l'expression / ligne : " + Yaka.ligne);
			}else{
				Yaka.yvm.istore(affoff);
			}
		} else {
			if (last == BOOLEEN) Yaka.yvm.ecrireBool();
			else if (last == ENTIER) Yaka.yvm.ecrireEnt();
			else{}
		}
		
		affectation = 0;
		affoff = 4;
	}
	
	public void setAffectation(int a){affectation = a;}
	
	public void setAffOff(int a){affoff = a;}
	
	
	
	

}
