import java.util.Scanner;


public class Command {
	private int x;
	private int y;
	private int z;
	private int[][] map;
	private String output;
	private String answer;
	private Scanner input;
	
	
	public Command(int a, int b, int[][] newMap) {
		x = a;
		y = b;
		map = newMap;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int turn() {
		int i = 0;
		z = map[x][y];
		
		switch (z) {
			case 1: i = move(); break;
			case 2: i = object(); break;
			case 3: i = monster(); break;
			case 4: i = exit(); break;
		}
		//System.out.println("i = " + i);
		return i;
	}
	
	public int move() {
		input = new Scanner(System.in);
		output = " ";
		
		//check direction options
		try {
			if (x-1 < 0)
				throw new MazeException();
			if (map[x - 1][y] != 0) {
				output += "north ";
			}
		}
		catch (MazeException ex) {
			
		}
		
		try {
			if (x + 1 > 9)
				throw new MazeException();
			if (map[x + 1][y] != 0) {
				output += "south ";
			}
		}
		catch (MazeException ex) {
			
		}
		try {
			if (y + 1 > 9)
				throw new MazeException();
			if (map[x][y + 1] != 0) {
				output += "east ";
			}
		}
		catch (MazeException ex) {
			
		}
		try {
			if (y - 1 < 0)
				throw new MazeException();
			if (map[x][y - 1] != 0) {
				output += "west ";
			}
		}
		catch (MazeException ex) {
			
		}
		
		
		
		//tell player their potions, record answer
		System.out.println("You can move \n" + output);
		System.out.println("Which way?");

		answer = input.next();
		
		//evaluate choice
		if (answer.equalsIgnoreCase("north")) {
			if ((x - 1 < 0) || map[x - 1][y] == 0) {
				System.out.println("that is a wall...");
				move();
			}
			z = 1;
			//System.out.println("z = " + z);
		}
		else if (answer.equalsIgnoreCase("south")) {
			if ((x + 1 > 9) || (map[x + 1][y] == 0)) {
				System.out.println("that is a wall...");
				move();
			}
			z = 2;
			//System.out.println("z = " +z);
		}
		else if (answer.equalsIgnoreCase("east")) {
			if ((y + 1 > 9) || map[x][y + 1] == 0) {
				System.out.println("that is a wall...");
				move();
			}
			z = 3;
			//System.out.println("z = " +z);
		}
		else if (answer.equalsIgnoreCase("west")) {
			if (y - 1 < 0 || map[x][y - 1] == 0) {
				System.out.println("that is a wall...");
				move();
			}
			z = 4;
			//System.out.println("z = " +z);
		}
		else if (answer.equalsIgnoreCase("help")) {
			z = 5;
		}
		else {
			System.out.println("That is not a direction");
			move();
		}
		//System.out.println("return z = " +z);
		return z;
	}

	public int object() {
		z = move();
		return z;
	}	
	public int monster() {
		z = move();
		return z;
	}
	public int exit() {
		System.out.println("You win!");
		z = 0;
		return z;
	}
}
