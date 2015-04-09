
public abstract class FoundObject {
	private int x;
	private int y;
	private String answer;
	
	protected FoundObject(int a, int b) {
		x = a;
		y = b;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public abstract String getObject() ;
}
