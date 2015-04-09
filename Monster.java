
public abstract class Monster {
	
	private int x;
	private int y;
	private int f;
	
	protected Monster(int a, int b) {
		x = a;
		y = b;
		f = 3;
	}
	
	public int getF() {
		return f;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public abstract int play(Character e) throws InterruptedException;
	
	public abstract boolean compatible(FoundObject i);
}
