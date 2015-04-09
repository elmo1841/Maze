
import java.util.Scanner;


public class Hero extends Character {
	private String output; //used to supply player with options
	private String answer; //holds players response
	//private KeyStore keystore;
	private int c;
	private Scanner input; 
	private int z; //variable
	private static final int me = 10; //specific marker for this character
	private Pocket pocket;
	private String name;
	
	public Hero(int a, int b, String c) {
		super(a, b);
		name = c;
		pocket = new Pocket();
	}
	
	@Override
	public int getMe() {
		return me;
	}
	
	public void putInPocket(FoundObject e) {
		pocket.add(e);
	}
	
	public void takeOutOfPocket(FoundObject e) {
		pocket.remove(e);
	}
	
	public void getPocket() {
		pocket.getPocket();
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int checkPocket(String h, Monster m) {
		z = pocket.checkPocket(h, m);
		return z;
	}
	
	@Override //tells player which way they can go prints it out
 	public void chooseMove(int a, int b, Map map) throws InterruptedException {
		String[] choice = super.evaluateChoice(a, b, map);
		input = new Scanner(System.in);
		output = " "; //runs through choice and populates output with all non-nulls
		c = 0;
		for (String e: choice) { 
			if (e != null) {
				output += e;
			}
		}
		System.out.println("You can move"); Thread.sleep(500);
		System.out.println(output); Thread.sleep(500);
		System.out.println("Which way?"); //tells player which way they can go
		answer = " ";
		answer = input.next();
		//System.out.println(c + c);
		//keystore = new KeyStore();
		//while (c == 0) {
						
			//c = keystore.getC();
			//System.out.println(c);
		//}
		
		//evaluate choice
		try {
			if (answer.equalsIgnoreCase("north") || answer.equalsIgnoreCase("n")) {
			
				if ((a - 1 < 0) || map.getMapCoordinate(a -1, b) == 0) {
					throw new MazeException();
				}
				
			
				z = 0;
			//System.out.println("z = " + z);
			}
			else if (answer.equalsIgnoreCase("south") || answer.equalsIgnoreCase("s")) {
				if ((a + 1 > 9) || (map.getMapCoordinate(a + 1, b) == 0)) {
					throw new MazeException();
				}
				z = 1;
			//System.out.println("z = " +z);
			}
			else if (answer.equalsIgnoreCase("east") || answer.equalsIgnoreCase("e")) {
				if ((b + 1 > 9) || map.getMapCoordinate(a, b + 1) == 0) {
					throw new MazeException();
				}
				z = 2;
			//System.out.println("z = " +z);
			}
			else if (answer.equalsIgnoreCase("west") || answer.equalsIgnoreCase("w")) {
				if (b - 1 < 0 || map.getMapCoordinate(a, b - 1) == 0) {
					throw new MazeException();
				}
				z = 3;
			//System.out.println("z = " +z);
			}
			else if (answer.equalsIgnoreCase("help")) {
				z = 4;
			}
			else {
				System.out.println("That is not a direction");
				chooseMove(a, b, map);
			}
		//System.out.println("return z = " +z);
		
		
			super.changeLocation(z);

		}
		catch (MazeException ex) {
			System.out.println("that is a wall...");
			chooseMove(a, b, map);
		}
	}		

}
