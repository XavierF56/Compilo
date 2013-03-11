import java.io.*;
import java.util.Stack;  

public class YVM implements YakaConstants{
   
   OutputStream file;
   private Stack<Integer> stop = new Stack<Integer>();

   
   public YVM (String nomFichier){
           file = Ecriture.ouvrir(nomFichier);
   }
   
   public void ecrire (String string){
	   Ecriture.ecrireString(file, string);
   }
       
   public void iadd(){
       Ecriture.ecrireString(file, "iadd\n");
   }
   
   public void isub(){
       Ecriture.ecrireString(file, "isub\n");
   }
   
   public void imul (){
       Ecriture.ecrireString(file, "imul\n");
   }
   
   public void idiv (){
       Ecriture.ecrireString(file, "idiv\n");
   }
   
   public void inot (){
       Ecriture.ecrireString(file, "inot\n");
   }
   
   public void ineg (){
       Ecriture.ecrireString(file, "ineg\n");
   }
   
   public void ior (){
       Ecriture.ecrireString(file, "ior\n");
   }
   
   public void iand() {
       Ecriture.ecrireString(file, "iand\n");
   }
   
   public void iinf (){
       Ecriture.ecrireString(file, "iinf\n");
   }
   
   public void isup (){
       Ecriture.ecrireString(file, "isup\n");
   }
   
   public void iinfegal (){
       Ecriture.ecrireString(file, "iinfegal\n");
   }
   
   public void isupegal (){
       Ecriture.ecrireString(file, "isupegal\n");
   }
   
   public void iegal (){
       Ecriture.ecrireString(file, "iegal\n");
   }
   
   public void idiff (){
       Ecriture.ecrireString(file, "idiff\n");
   }
   
   public void iload (int offset){
       Ecriture.ecrireString(file, "iload " + offset + "\n");
   }
   
   public void istore (int offset){
       Ecriture.ecrireString(file, "istore " + offset + "\n");
   }
   
   public void iconst (int offset){
       Ecriture.ecrireString(file, "iconst " + offset + "\n");
   }
   
   public void ifeq (String etiq){
       Ecriture.ecrireString(file, "ifeq " + etiq + "\n");
   }
   
   public void goTo (String etiq){
       Ecriture.ecrireString(file, "goto " + etiq + "\n");
   }
   
   public void entete(){
       Ecriture.ecrireString(file, "entete\n");  
   }
   
   public void ouvrePrinc (int nb){
       Ecriture.ecrireString(file, "ouvrePrinc " + nb + "\n");
   }
   
   /* Fonctions d'affectation, entrees, sorties */
   
   public void ecrireEnt(){
	   Ecriture.ecrireString(file, "ecrireEnt\n");
   }
   
   public void ecrireChaine(String chaine){
	   Ecriture.ecrireString(file, "ecrireChaine " + chaine +"\n");
   }

   public void ecrireBool(){
	   Ecriture.ecrireString(file, "ecrireBool\n");
   }
   
   public void lireEnt(int offset){
	   Ecriture.ecrireString(file, "lireEnt " + offset + "\n");
   }
   
   public void aLaLigne(){
	   Ecriture.ecrireString(file, "aLaLigne\n");
   }
   
   public void queue(){
	   Ecriture.ecrireString(file, "queue\n");
   }
   
   /* Categories d'operateurs */
   
	public void opNeg(){
		int op = stop.pop();
		
		switch (op) {
			case NEG : ineg();
			break;
			case NON : inot();
			break;
			default : System.out.println("erreur dans opNEG YVM");
			}
	}

	public void opMul(){
		int op = stop.pop();
		
		switch (op) {
			case MULT : imul();
			break;
			case DIV : idiv();
			break;
			case ET : iand();
			break;
			default : System.out.println("erreur dans opMUl YVM");
			}
	}

	public void opAdd(){
		int op = stop.pop();
		
		switch (op) {
			case OU : ior();
			break;
			case PLUS : iadd();
			break;
			case MOINS : isub();
			break;
			default : System.out.println("erreur dans opADdd YVM");
			}
	}

	public void opRel(){
		int op = stop.pop();
		
		switch (op) {
			case EGAL : iegal();
			break;
			case DIFFERENT : idiff();
			break;
			case INF : iinf();
			break;
			case INFOUEG : iinfegal();
			break;
			case SUP : isup();
			break;
			case SUPOUEG : isupegal();
			break;
			default : System.out.println("erreur dans opREL YVM");
			}
	}

	public void push(int i){
		stop.push(i);
	}

	
}
