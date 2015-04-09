import java.util.ArrayList;
import java.util.Scanner;


public class Maze {
	private Scanner input;
	private String answer;
	private Map map; 										//holds coordinates
	private ArrayList<Character> players; 					//carries list of all characters in the game
										  					//character is any thing that changes location
	private ArrayList<FoundObject> objects; 				//list of all objects that can be found
	private ArrayList<Monster> monsters; 					//list of all monsters you can meet
	private ArrayList<Lock> MazeLocks;
	private int xStart;
	private int yStart;
	private int z; 											//variable for controlling game play (used in turn() )
	private boolean[] objectsFound; 						//used to store index of found objects for removal
	private boolean game;
	
	
	public Maze(int a, int b, Map newMap, 
			ArrayList<Character> characters, ArrayList<Monster> monsters, ArrayList<FoundObject> objects, ArrayList<Lock> mazelocks) {
		xStart = a;
		yStart = b;
		this.map = newMap;
		this.players = characters;
		this.monsters = monsters;
		this.objects = objects;
		this.MazeLocks = mazelocks;
		input = new Scanner(System.in);
		game = true;
	}
	
	public void runMaze() {
		
		
															//each character gets a turn		
		while (game) {
			
			try {
			for (Character e: players) {	 				//runs through Array List of characters each gets a turn				
				
				map.setMapCoordinate(e.getX(), e.getY(), e.getF()); 		// restores previous F coordinate			
				e.chooseMove(e.getX(), e.getY(), map); 		//each character goes through potential moves										
				map.setPiece(e);								//piece is set on the board			
				//System.out.println(e.getName()); e.getLocation();
				evaluateLoc(e);								//decide what needs to be done
				if (e.isMapping) {
					map.printMap(e.getX(), e.getY());
				}
			}
			}
			catch (InterruptedException ex) {
				
			}
			 												//after all characters have gone, turns start again
		}		
	}
	

	public void evaluateLoc(Character e) throws InterruptedException {							  									// this was at the player location
		if (e.getMe() == 10) { 							//me(10) is hero 
			switch (e.getF()) { 						//switch takes them to object or monster interaction
			case 1: return;
			case 2: object(e);	break;
			case 3: monster(e); break;
			case 4: map.found(e); break;
			case 5: exit(e); 	break;
			case 15: eaten(e); 	break;
			}
		}
		if (e.getMe() == 15 && e.getF() == 10) {		//minotaur
			for (Character f: players) {
				if (e.getX() == f.getX() && e.getY() == f.getY() && e.getMe() != f.getF()) {
					eaten(f);									//the only thing it cares about is eating the hero
				}
			}
				
		}
	}
	
	
	public void object(Character e) throws InterruptedException {					//found object interaction
		objectsFound = new boolean[10];
		for (FoundObject h: objects) {
			if (e.getX() == h.getX() && 
					e.getY() == h.getY()) {
				z = objects.indexOf(h);
				objectsFound[z] = true;
				answer = h.getObject();
				System.out.println(e.getName() + " found a " + answer); Thread.sleep(500);
				System.out.println("Do you want to pick it up? Y/N");
				answer = input.next();
				if (answer.equalsIgnoreCase("Y")) {
					((Hero) e).putInPocket(h);
					e.setF(1);
				}
			}
		}
		for (z = 9; z >= 0; z--) {						//remove object from list of objects in Maze
			if (objectsFound[z] == true) {
				objects.remove(z);
			}
		}
		
	}
	
	public void monster(Character e) throws InterruptedException {					//monster interaction (not minotaur)
		z = 0;
		for (Monster h: monsters) {
			if (e.getX() == h.getX() && e.getY() == h.getY()) {
				z = h.play(e);
			}
		}
		switch (z) {
		case 0: break;
		case 1: backToStart(e);
		}
		
	}
	//player finds the exit
	public void exit(Character e) throws InterruptedException {
		
		if (MazeLocks.size() > 0) {
			for (Lock l: MazeLocks) {
				if (!l.getLock()) {
					return;
				}
			}
		}
		System.out.println(e.getName() + " wins!"); Thread.sleep(1000);
		game = false;
	}
	//player gets eaten
	public void eaten(Character e) throws InterruptedException {
		System.out.println(e.getName() + " has been eaten by the minotaur."); Thread.sleep(1000);
		game = false;
	}
	
	public void backToStart(Character e) throws InterruptedException {
		map.setMapCoordinate(e.getX(), e.getY(), e.getF());
		e.setX(xStart);
		e.setY(yStart);
		map.setPiece(e);
		System.out.println("This spot looks familiar..."); Thread.sleep(1000);
		
	}
}
