public class IdConst extends Ident {
	protected int val;

	public int getVal() {
		return val;
	}	
	
	public IdConst (int t, int v){
		super();
		val = v;
		type = t;
	}

	public String toString() {
		return "( type : " + type + " ; val : " + val + ")";
	}
	
	public void yvm() {
		Yaka.yvm.iconst(val);
	}
	
	public int getOffset (){
		return 2;	
	}
	
}
