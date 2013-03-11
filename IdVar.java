public class IdVar extends Ident {
	private int offset;
	private static int last_offset;
	
	public IdVar (int t){
		super();
		super.type = t;
		last_offset -= 2;
		offset = last_offset;
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset (int o){
		offset = o;
	}
	
	public void setType(int type) {
		super.type = type;
	}
	
	public static int getLastOffset(){return last_offset;}
	
	public void yvm() {
		Yaka.yvm.iload(offset);
	}
	
	public String toString() {
		return "( type : " + type + " ; offset : " + offset + ")";
	}
}
