
public class Minotaur extends Character{
	private int z; //variable
	private int m; //x position on last turn
	private int n; //y position on last turn
	private int count; //used for moving
	private boolean wall; //used for moving
	private static final int me = 15; //specific identifier for this character
	
	public Minotaur() {
		super(0, 9);
	}
	
	public Minotaur(int a, int b) {
		super(a, b);
	}
	
	public void setM(int c) {
		this.m = c;
	}

	public void setN(int d) {
		this.n = d;
	}
	
	@Override
	public int getMe() {
		return me;
	}
	
	@Override
	public void chooseMove(int a, int b, Map map) {
		String[] choice = super.evaluateChoice(a, b, map);
		wall = true;
		count = 0;
		//if minotaur only has one direction he automatically goes that way
		for (int i = 0; i < choice.length; i++) {
			if (choice[i] != null) { //anything not a null is a way he can go
				count++;
				z = i;
			}
			
		}
		// if count only went up once, one direction he chooses that
		//this stops minotaur from getting stuck in dead ends
		if (count == 1) {
			wall = false;
		}
		// this while loop makes sure that he doesn't go in circles
		//by not allowing him to move to the space he was just on
		while (wall) {
			z = (int)(Math.random() * 4); //random 0-3 for choice array
			//System.out.println(z);
			if ((choice[z] != null) && (changeLocation(a, b, z))) {
				//if the number is a null (wall) or the direction it came from
				//wall remains true and it picks another number
				wall = false;			
			}
		}
		
		m = a;
		n = b;
		super.changeLocation(z);
	}
	
	//this method checks proposed new location against last location
	public boolean changeLocation(int a, int b, int c) {
		//System.out.println("c = " +c);
		switch (c) {
		case 0: if ((a-1) == m && (b == n)) {
			return false;
		} return true;
		case 1: if ((a+1) == m && (b == n)) {
			return false;
		} return true;
		case 2: if ((a == m) && (b - 1) == n){
			return false;
		} return true;
		case 3: if ((a == m) && (b + 1) == n){
			return false;
		} return true;

		}
		return true;
	}

	@Override
	public int checkPocket(String h, Monster m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
