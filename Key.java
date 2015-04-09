
public class Key extends FoundObject {
	
	private int combination;
	
	
	public Key(int a, int b, int c) {
		super(a, b);
		combination = c;
	}

	public int getCombination() {
		return combination;
	}
	
	@Override
	public String getObject() {
		return "Key";
	}

}
