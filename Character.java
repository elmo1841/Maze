
public abstract class Character { //basic charcater constructor
	protected int x; 				//character location x
	protected int y; 				//character location y
	private int f; 				//stores map coordinate character is occupying
	private int me; 			//specific identifier for each character
	private String[] choice;	//holds direction choices character can make
	private String answer;
	protected boolean isMapping;
	
	protected Character(int a, int b) {
		x = a;
		y = b;	
		f = 1;
		isMapping = false;
	}
	
	public int getMe() { //returns unique identifier
		return me;
	}

	public int getF() { 
		return f;
	}

	public void setF(int f) {
		this.f = f;
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
	
	public boolean getIsMapping() {
		return isMapping;
	}
	
	public void setIsMapping(boolean map) {
		isMapping = map;
	}
	
	public abstract int checkPocket(String h, Monster m);
	
	public void getLocation() { //this is only used in debugging
		System.out.println(x + ", " + y);
	}
	
	public String[] evaluateChoice(int a, int b, Map map) {
		//each character uses this to evaluate four boxes around them
		//it returns a String[] with cardinal directions
		
		//check direction options
		int count = -1;
		choice = new String[4];
		for (int i = -1; i < 2; i +=2) {
			count++;

			try {
				if ((a + i) < 0 || (a + i) > 9) { //check north south
					throw new MazeException(); 
				}	//maze exception is for player at edge of map
				
				if (map.getMapCoordinate(a + i, b) != 0) {					
					choice[count] = direction(count);
				}
			}
			catch (MazeException ex) {	
			}
		}			
		for (int j = 1; j > -2; j -=2) {
			count++;			
			try {
				if ((b + j) < 0 || (b + j) > 9) { //check east west
					throw new MazeException();
				}
				//System.out.println("f= " + map[a][b + j]);
				
				if (map.getMapCoordinate(a, b + j) != 0) {					
					choice[count] = direction(count);
				}
			}
			catch (MazeException ex) {	
			}		
		}	
		return choice;
	}
	
	public String direction(int c) {
		answer = " ";
		switch (c) { //this switch populates directions based on "count"
		case 0: answer = "north "; break;
		case 1: answer = "south "; break;
		case 2: answer = "east "; break;
		case 3: answer = "west "; break;
		}			
		return answer;
	}
	
	public void changeLocation(int c) {
		switch (c) { //depending on what a character returns from their choice
		case 0: x -= 1; break;
		case 1: x += 1; break;
		case 2: y += 1; break;
		case 3: y -= 1; break;
		case 4: toString();
			}
		
		}	
	
	@Override
	public String toString() {
		String message = "Help I am stuck in a maze!";
		System.out.println(message);
		return message;
	}

	public abstract void chooseMove(int x2, int y2, Map map) throws InterruptedException ;
	public abstract String getName();
	

}
