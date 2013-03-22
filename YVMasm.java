
public class YVMasm extends YVM {

	private static int nbMess = 0;
	
	@Override
	public void ecrire(String string) {
		// TODO Auto-generated method stub
		super.ecrire(string);
	}

	@Override
	public void iadd() {
		Ecriture.ecrireString(file,"\n\n;");
		super.iadd();
		Ecriture.ecrireString(file,"pop bx \npop ax \nadd ax,bx\npush ax\n");
	}

	@Override
	public void isub() {
		Ecriture.ecrireString(file,"\n\n;");
		super.isub();
		Ecriture.ecrireString(file,"pop bx \npop ax \nsub ax,bx\npush ax\n");
	}

	@Override
	public void imul() {
		Ecriture.ecrireString(file,"\n\n;");
		super.imul();
		Ecriture.ecrireString(file,"pop bx \npop ax \nimul bx\npush ax\n");
	}

	@Override
	public void idiv() {
		Ecriture.ecrireString(file,"\n\n;");
		super.idiv();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncwd \nidiv bx \npush ax\n");
	}

	@Override
	public void inot() {
		Ecriture.ecrireString(file,"\n\n");
		Ecriture.ecrireString(file,"pop ax \n xor ax,-1 \n push ax\n");
		//----------------------------------------------------------------------> ERREUR ???
	}

	@Override
	public void ineg() {
		Ecriture.ecrireString(file,"\n\n;");
		super.ineg();
		Ecriture.ecrireString(file,"pop bx \nmov ax,0 \nsub ax,bx\npush ax\n");
	}

	@Override
	public void ior() {
		Ecriture.ecrireString(file,"\n\n;");
		super.ior();
		Ecriture.ecrireString(file,"pop bx \npop ax \nor ax,bx\npush ax\n");
	}

	@Override
	public void iand() {
		Ecriture.ecrireString(file,"\n\n;");
		super.iand();
		Ecriture.ecrireString(file,"pop bx \npop ax \nand ax,bx\npush ax\n");
	}

	@Override
	public void iinf() {
		Ecriture.ecrireString(file,"\n\n;");
		super.iinf();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncmp ax,bx \njge $+6 \npush -1 \njmp $+4 \npush 0 \n");
	}

	@Override
	public void isup() {
		Ecriture.ecrireString(file,"\n\n;");
		super.isup();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncmp ax,bx \njle $+6 \npush -1 \njmp $+4 \npush 0 \n");
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireString(file,"\n\n;");
		super.iinfegal();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncmp ax,bx \njg $+6 \npush -1 \njmp $+4 \npush 0 \n");
	}

	@Override
	public void isupegal() {
		Ecriture.ecrireString(file,"\n\n;");
		super.isupegal();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncmp ax,bx \njl $+6 \npush -1 \njmp $+4 \npush 0 \n");
	}

	@Override
	public void iegal() {
		Ecriture.ecrireString(file,"\n\n;");
		super.iegal();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncmp ax,bx \njne $+6 \npush -1 \njmp $+4 \npush 0 \n");
	}

	@Override
	public void idiff() {
		Ecriture.ecrireString(file,"\n\n;");
		super.idiff();
		Ecriture.ecrireString(file,"pop bx \npop ax \ncmp ax,bx \nje $+6 \npush -1 \njmp $+4 \npush 0 \n");
	}

	@Override
	public void iload(int offset) {
		Ecriture.ecrireString(file,"\n\n;");
		super.iload(offset);
		Ecriture.ecrireString(file,"push word ptr [bp" + offset +"]\n");
	}

	@Override
	public void istore(int offset) {
		Ecriture.ecrireString(file,"\n\n;");
		super.istore(offset);
		Ecriture.ecrireString(file,"pop ax \nmov word ptr [bp" + offset + "], ax\n");
}

	@Override
	public void iconst(int offset) {
		Ecriture.ecrireString(file,"\n\n;");
		super.iconst(offset);
		Ecriture.ecrireString(file,"push word ptr " + offset + "\n");
	}

	@Override
	public void ifeq(String etiq) {
		//TODO LATER
	}

	@Override
	public void goTo(String etiq) {
		// TODO LATER
	}
	
	public void entete() {
		Ecriture.ecrireString(file,";");
		super.entete();
		Ecriture.ecrireString(file,"extrn lirent:proc, ecrent:proc\nextrn ecrbool:proc\nextrn ecrch:proc, ligsuiv:proc\n");
		Ecriture.ecrireString(file,".model SMALL\n.586\n\n.CODE\ndebut:\nSTARTUPCODE\n\n");
	}
	
	@Override
	public void ouvrePrinc(int nb) {
		Ecriture.ecrireString(file,"\n\n;");
		super.ouvrePrinc(nb);
		Ecriture.ecrireString(file,"mov bp,sp\nsub sp,"+nb+"\n");
	}

	@Override
	public void ecrireEnt() {
		Ecriture.ecrireString(file,"\n\n;");
		super.ecrireEnt();
		Ecriture.ecrireString(file,"call ecrent\n");
	}

	@Override
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireString(file,"\n\n;");
		super.ecrireChaine(chaine);
		Ecriture.ecrireString(file,".DATA\nmess"+nbMess+ " DB "+chaine.substring(0, chaine.length()-1) +"$\"\n");
		Ecriture.ecrireString(file,".CODE\nlea dx, mess"+nbMess+"\npush dx\ncall ecrch\n");
		nbMess++;
	}

	@Override
	public void ecrireBool() {
		Ecriture.ecrireString(file,"\n\n;");
		super.ecrireBool();
		Ecriture.ecrireString(file,"call ecrbool\n");
	}

	@Override
	public void lireEnt(int offset) {
		Ecriture.ecrireString(file,"\n\n;");
		super.lireEnt(offset);
		Ecriture.ecrireString(file,"lea dx,[bp"+offset+"]\npush dx\ncall lirent\n");
	}

	@Override
	public void aLaLigne() {
		Ecriture.ecrireString(file,"\n\n;");
		super.aLaLigne();
		Ecriture.ecrireString(file,"call ligsuiv\n");
	}
	
	public void queue(){
			Ecriture.ecrireString(file,"\n\n;");
			super.queue();
		   Ecriture.ecrireString(file, "nop\nEXITCODE\nEnd debut\n");
	   }

	@Override
	public void opNeg() {
		// TODO Auto-generated method stub
		super.opNeg();
	}

	@Override
	public void opMul() {
		// TODO Auto-generated method stub
		super.opMul();
	}

	@Override
	public void opAdd() {
		// TODO Auto-generated method stub
		super.opAdd();
	}

	@Override
	public void opRel() {
		// TODO Auto-generated method stub
		super.opRel();
	}

	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		super.push(i);
	}

	public YVMasm(String nomFichier) {
		super(nomFichier);
		// TODO Auto-generated constructor stub
	}
	
	/* Iteration */
	public void tantQue() {
		Ecriture.ecrireString(file,"\n\n");
		Ecriture.ecrireString(file, "FAIRE"+index+":\n");
	}
	public void faire() {
		Ecriture.ecrireString(file,"\n\n;");
		super.faire();
		Ecriture.ecrireString(file, "pop ax\ncmp ax,0\nje FAIT" +super.index + "\n");
	}
	public void goTo() {
		Ecriture.ecrireString(file,"\n\n;");
		super.goTo();
		Ecriture.ecrireString(file, "jmp FAIRE"+index+"\n");
	}
	public void fait() {
		Ecriture.ecrireString(file,"\n\n");
		Ecriture.ecrireString(file, "FAIT"+index+":\n");
	}

	/* Conditionnelle */
	public void alors() {
		Ecriture.ecrireString(file,"\n\n;");
		super.alors();
		Ecriture.ecrireString(file, "pop ax\ncmp ax,0\nje SINON"+indexCondi+"\n");
	}
	
	public void goToCond() {
		Ecriture.ecrireString(file,"\n\n;");
		super.goToCond();
		Ecriture.ecrireString(file, "jmp FSI"+indexCondi+"\n");
	}
	
	public void sinon() {
		Ecriture.ecrireString(file,"\n\n");
		Ecriture.ecrireString(file, "SINON"+indexCondi+":\n");
	}
	
	public void fsi() {
		Ecriture.ecrireString(file,"\n\n");
		Ecriture.ecrireString(file, "FSI"+indexCondi+":\n");
		indexCondi++;
	}
	
	
	/* Fonctions */
	public void nomFonc( String nom){
		Ecriture.ecrireString (file, nom + ": \n");
	}
	
	public void ouvreBloc(int taille){
		Ecriture.ecrireString(file,"\n\n;");
		super.ouvreBloc(taille);
		Ecriture.ecrireString(file, "enter " + taille+",0");
	}
	
	public void fermeBloc(int taille){
		Ecriture.ecrireString(file,"\n\n;");
		super.fermeBloc(taille);
		Ecriture.ecrireString(file, "leave\nret " + taille+"\n");
	}
	
	public void call(String nom){
		Ecriture.ecrireString(file,"\n\n;");
		super.call(nom);
		Ecriture.ecrireString(file, "call " + nom +"\n");
	}
	
	public void reserveRetour(){
		Ecriture.ecrireString(file,"\n\n;");
		super.reserveRetour();
		Ecriture.ecrireString(file, "sub sp,2\n");
	}
	
	public void ireturn(int taille){
		Ecriture.ecrireString(file,"\n\n;");
		super.ireturn(taille);
		Ecriture.ecrireString(file, "pop ax\nmov [bp+"+taille+"], ax\n");
	}
	
	public void main() {
		Ecriture.ecrireString(file, "main:\n");
	}

}
