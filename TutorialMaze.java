import java.util.ArrayList;
import java.util.Scanner;


public class TutorialMaze {
	
	private int[][] tempMap;
	private Map map;
	private Hero hero;
	private GoldCoin gold;
	private Key key;
	private Goblin goblin;
	private Lock lock;
	private String answer;
	private Scanner input;
	
	public TutorialMaze() throws InterruptedException {
		hero = new Hero(3, 5, "Student Hero");
		TutorialMap();
		gold = new GoldCoin(1, 3);
		key = new Key(1, 2, 123);
		goblin = new Goblin(1, 2);
		lock = new Lock(2, 1, 123);
		step1();
			
	}
	
	public void TutorialMap() {
		tempMap = new int[][] {
			{0, 5, 0, 0, 0, 0},
			{1, 2, 3, 2, 1, 1},
			{0, 3, 0, 0, 4, 0},
			{0, 0, 0, 0, 1, 1}};
		
	map = new Map(tempMap);		
	}

	public void step1() throws InterruptedException {
		System.out.println("Welcome to the tutorial " + hero.getName()); Thread.sleep(500);
		System.out.println("This program is going to teach you how to run 'The Maze'"); Thread.sleep(500);
		System.out.println("Every maze has an exit that you must find by traveling through it"); Thread.sleep(500);
		System.out.println("Most mazes have monsters that will hurt you,\nand objects that will help you"); Thread.sleep(500);
		System.out.println("Let's get started."); Thread.sleep(1000);
		System.out.println(" ");
		
		step2();
	}

	public void step2() throws InterruptedException {
		input = new Scanner(System.in);
		
		System.out.println("At each step I will tell you what direction you can move..."); Thread.sleep(500);
		System.out.println("Ready to start?  Y/N"); 
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes"))) {
			System.out.println("Really... Y/N");
			answer = input.next();
		}
		System.out.println("From this spot you can only go west"); Thread.sleep(500);
		System.out.println("You can type in west or w to move"); Thread.sleep(500);
		
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("west") || answer.equalsIgnoreCase("w"))) {
			System.out.println("Something went wrong there..."); Thread.sleep(500);
			System.out.println("Let's try again");
			System.out.println("You can move west");
			answer = input.next();
		}
		
		step3();
	}
	
	public void step3() throws InterruptedException {
		System.out.println("Very good"); Thread.sleep(500);
		System.out.println("From here you can go north"); Thread.sleep(500);
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("north") || answer.equalsIgnoreCase("n"))) {
			System.out.println("Something went wrong there..."); Thread.sleep(500);
			System.out.println("Let's try again");
			System.out.println("You can move north");
			answer = input.next();
		}
		
		step4();
	}
	
	public void step4() throws InterruptedException {
		System.out.println("You have found your first object!!"); Thread.sleep(500);
		System.out.println("You found a map"); Thread.sleep(500);
		System.out.println("Whenever you find an object..."); Thread.sleep(500);
		System.out.println("I will ask you if you want to pick it up."); Thread.sleep(500);
		step5();
		
	}
	
	public void step5() throws InterruptedException {
		System.out.println("Would you like to pick up the map?  Y/N");
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))) {
			if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				System.out.println("You should pick it up"); Thread.sleep(500);
			}
			else {
				System.out.println("huh?"); Thread.sleep(500);
			}
			System.out.println("Would you like to pick up the map? Y/N");
			answer = input.next();
		}
		
		step6();
	}
	
	
	public void step6() throws InterruptedException {
		map.printMap(2, 4);
		System.out.println("Maps are useful"); Thread.sleep(500);
		System.out.println("From here you should go north again"); Thread.sleep(500);
		
		answer = input.next();
		step7();
	}
	
	public void step7() throws InterruptedException {
		
		while (!(answer.equalsIgnoreCase("north") || answer.equalsIgnoreCase("n"))) {
			System.out.println("Something went wrong there..."); Thread.sleep(500);
			System.out.println("Let's try again");
			System.out.println("You can move north");
			answer = input.next();
		}
		
		step8();
	}
	public void step8() throws InterruptedException {
		hero.setX(1);
		hero.setY(4);
		map.printMap(hero.getX(), hero.getY());
		System.out.println("From here you have a choice");
		System.out.println("You can go east or west");
		System.out.println("I will let you choose");
		
		answer = input.next();
		
		if  (answer.equalsIgnoreCase("east") || answer.equalsIgnoreCase("e")){
			hero.setX(1);
			hero.setY(5);
			map.setPiece(hero);
			step9();
		}
		if  (answer.equalsIgnoreCase("west") || answer.equalsIgnoreCase("w")){
			hero.setX(1);
			hero.setY(3);
			map.setPiece(hero);
			step10();
		}
	}
	
	public void step9() throws InterruptedException {
		map.printMap(hero.getX(), hero.getY());
		System.out.println("That is a dead end..."); Thread.sleep(500);
		System.out.println("You should go west"); Thread.sleep(500);
		System.out.println("Which way would you like to go?");
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("west") || answer.equalsIgnoreCase("w"))) {
			System.out.println("try again...");
			answer = input.next();
		}
		
		System.out.println("Lets try again"); Thread.sleep(500);
		hero.setX(1);
		hero.setY(4);
		step8();
	}
	
	public void step10() throws InterruptedException {
		hero.setX(1);
		hero.setY(3);
		map.printMap(hero.getX(), hero.getY());
		System.out.println("Nicely done"); Thread.sleep(500);
		System.out.println("You also found another object..."); Thread.sleep(500);
		System.out.println("a gold coin."); Thread.sleep(500);
		System.out.println("Would you like to pick it up?  Y/N");
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))) {
			System.out.println("Why wouldn't you pick up a gold coin?");Thread.sleep(500);
			System.out.println("Do you want to pick it up? Y/N");
			answer = input.next();
		}
		
		step11();
	}
	
	public void step11() throws InterruptedException {
		System.out.println("Shall we continue?"); Thread.sleep(500);
		System.out.println("You can go east or west");
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("west") || answer.equalsIgnoreCase("w"))) {
			System.out.println("there is nothing for you that way");
			answer = input.next();
		}
		
		step12();
		
	}
	
	public void step12() throws InterruptedException {
		hero.setX(1);
		hero.setY(2);
		map.printMap(hero.getX(), hero.getY());
		
		System.out.println("That brings us to our first monster!!"); Thread.sleep(500);
		System.out.println("Goblins won't hurt you, "); Thread.sleep(500);
		System.out.println("but they will send you back to the begining of the maze..."); Thread.sleep(500);
		System.out.println("If you don't have what they want."); Thread.sleep(500);
		
		goblin();
		
		System.out.println("And then the goblin goes away..."); Thread.sleep(500);
		System.out.println("We are almost done"); Thread.sleep(500);
		System.out.println("Where do you think you should go from here?");
		answer = input.next();
		
		while (!(answer.equalsIgnoreCase("west") || answer.equalsIgnoreCase("w"))) {
			System.out.println("Stop playing..."); Thread.sleep(500);
			System.out.println("Which way really?");
			answer = input.next();
		}
		
		step13();
	}
	
	public void step13() throws InterruptedException {
		hero.setX(1);
		hero.setY(1);
		map.printMap(hero.getX(), hero.getY());
		
		System.out.println("That brings us to our final object..."); Thread.sleep(500);
		System.out.println("the key"); Thread.sleep(500);
		System.out.println("Most mazes have locks, and until you find their keys..."); Thread.sleep(500);
		System.out.println("The exit will not open."); Thread.sleep(500);
		step14();
	}
	
	public void step14() throws InterruptedException {
		System.out.println("Well that's all I have for you..."); Thread.sleep(500);
		System.out.println("You have the key and you know how to move around."); Thread.sleep(500);
		System.out.println("Are you ready to finish on your own?"); 
		answer = input.next();
		
		if (answer.equalsIgnoreCase("y")) {
			System.out.println("Great!");
			step15();
		}
		
		else {
			System.out.println("Well that's too bad becuase I'm leaving..."); Thread.sleep(500);
			System.out.println("and you are on your own."); Thread.sleep(500);
			System.out.println("I think you will be fine.");
			step15();
		}
	}
	
	public void step15() throws InterruptedException {
		System.out.println("When you find your way out you can go to the default maze\n"
				+ "by selecting play, or you can create your own maze.  Good luck"); Thread.sleep(2000); 
		System.out.println("oh I forgot to tell you..."); Thread.sleep(500);
		System.out.println("Some mazes have minotaurs in them that will eat you..."); Thread.sleep(500);
		System.out.println("have fun");
		
		hero.putInPocket(key);
		hero.setIsMapping(true);
		ArrayList<Character> characters = new ArrayList<>();
		characters.add(hero);
		ArrayList<Monster> monsters = new ArrayList<>();
		monsters.add(lock);
		ArrayList<Lock> mazelocks = new ArrayList<>();
		mazelocks.add(lock);
		ArrayList<FoundObject> objects = new ArrayList<>();
		Maze finishMaze = new Maze (1, 1, map, characters, monsters, objects, mazelocks);
		finishMaze.runMaze();
	}
	
	public void goblin() throws InterruptedException {
		System.out.println("A goblin is blocking your way..."); Thread.sleep(500);
		System.out.println("Do you want to go around it..."); Thread.sleep(100);
		System.out.println("or try to talk to it?"); Thread.sleep(500);
		System.out.println("talk/move ?");
		
		answer = input.next();
		
		if (!answer.equalsIgnoreCase("talk")) {
			System.out.println("If you try to go around a goblin it will send you to the start."); Thread.sleep(500);
			System.out.println("Try again");
			
			answer = input.next();
		}
		
		while (!answer.equalsIgnoreCase("talk")) {
			System.out.println("try again...");
			answer = input.next();
		}
		
		System.out.println("It turns out that all goblins want is gold..."); Thread.sleep(500);
		System.out.println("and you have some."); Thread.sleep(500);
		System.out.println("Should we pay it? Y/N");
		answer = input.next();
		
		while(!answer.equalsIgnoreCase("Y")) {
			System.out.println("That isn't a good idea..."); Thread.sleep(500);
			System.out.println("try again.  Y/N");
			answer = input.next();
		}
		
		
	}

}
