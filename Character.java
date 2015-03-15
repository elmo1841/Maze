
public class Character {
	private int x;
	private int y;
	
	public Character(int a, int b) {
		x = a;
		y = b;		
	}

	public int getX() {
		return x;
	}

	public void setX(int a) {
		x = a;
	}

	public int getY() {
		return y;
	}

	public void setY(int b) {
		y = b;
	}
	
	public void getLocation() {
		System.out.println(x);
		System.out.println(y);
	}
	
	public void movement(int c) {
		//System.out.println("c = " +c);
		switch (c) {
		case 0: break;
		case 1: x -= 1; break;
		case 2: x += 1; break;
		case 3: y += 1; break;
		case 4: y -= 1; break;
		case 5: toString();
		}
	}

	@Override
	public String toString() {
		String message = "Help I am stuck in a maze!";
		System.out.println(message);
		return message;
	}

}
