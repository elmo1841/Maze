import java.util.ArrayList;
import java.util.Scanner;


public class Builder {
	private Map map;
	private Scanner input;
	private ArrayList<Character> characters;		//list of characters you create
	private ArrayList<Monster> monsters;			//list of monsters (goblins and locks)
	private ArrayList<Lock> mazelocks;
	private ArrayList<FoundObject> objects;				//list of objects (gold and keys)
	private int monsterCount;						//number of monsters you put in
	private int objectCount;						//number of objects you put in
	private int playerCount;						//number of players
	private int minCount;							//number of minotaurs
	private final int exitCount = 1;				//there can only be one exit
	private int tempMonster;						//keeps track of monsters as you create them
	private int tempObject;							//keeps track of objects as you create them
	private int tempExit;							//tracks when you create an exit
	private int a;									//map X number
	private int b;									//map Y number
	private int[][] tempMap;						//map coordinates
	private int c;									//Xstart
	private int d;									//Ystart
	private int e;									//variable for placing objects and monsters X Locale
	private int f;									//variable for placing objects and monsters Y Locale
	private int g;
	private int h;
	private int v;
	private int w;									//variable for adding more objects/monsters
	private int z;									//variable for adding more objects/monsters
	private String add;
	private String name;
	private boolean release;
	private int combination;
	private String answer;
	
	public Builder() throws InterruptedException {
		newBuild();
	}
	
	public Builder(int a, int b) throws InterruptedException {
		this.a = a;
		this.b = b;
		defaultMap(); 										//generates the map
		characters = new ArrayList<>(); 						//generates the list
		objects = new ArrayList<>();
		monsters = new ArrayList<>();
		Hero hero = new Hero(a, b, "Hero");						//new hero with starting location
		characters.add(hero); 									//add hero to list
		Minotaur minotaur = new Minotaur(0, 9); 				//new bad guy with starting location
		characters.add(minotaur); 								//add bad guy to list
		z = 1; 													//set initial variable at 1
		GoldCoin gold = new GoldCoin(2, 0);
		objects.add(gold);
		Goblin goblin = new Goblin(7, 4);
		monsters.add(goblin);
		Key keyA = new Key(6, 6, 49378);
		objects.add(keyA);
		Lock lockA = new Lock(9, 8, 49378);
		monsters.add(lockA);
		mazelocks = new ArrayList<>();
		mazelocks.add(lockA);
		
		Maze maze1 = new Maze(a, b, map, characters, monsters, objects, mazelocks);
		maze1.runMaze();
						
	}
	
	public void newBuild() throws InterruptedException {
		input = new Scanner(System.in);
		System.out.println("How many Players?");
		playerCount = input.nextInt();
		System.out.println("How many Minotaurs?");
		minCount = input.nextInt();
		System.out.println("How many Monster? (Goblins and Locks)");
		monsterCount = input.nextInt();
		System.out.println("How many Objects? (Keys and Gold)");
		objectCount = input.nextInt();
		
		map();
		startLoc();
		heros();
		minotaurs();
		monsters();
		objects();
		
		Maze maze1 = new Maze(a, b, map, characters, monsters, objects, mazelocks);
		maze1.runMaze();
	}
	
 	public void map() {
		System.out.println("This map is 0 based");
		System.out.println("ie: 4 X 4 map will have coordinates 0, 0 to 3, 3 ");
		System.out.println("Enter size of your map: (X by Y)");
		System.out.println("X coordinates: ");
		a = input.nextInt();
		System.out.println("Y coordinates: ");
		b = input.nextInt();
		tempMap = new int[a][b];
		System.out.println("Starting in the top left hand corner...");
		System.out.println("enter coordinates in your map");
		System.out.print("0 = wall \n1 = open space \n2 = object (key or gold)\n3 = monster (goblin or lock)\n4 = exit \n");
		for (int X = 0; X < a; X ++) {
			if (X == 0) {
				System.out.println("First row...");
			}
			else if (X == (a - 1)) {
				System.out.println("Last row...");
			}
			else {
				System.out.println("Next row...");
			}
			for (int Y = 0; Y < b; Y++) {
				System.out.println(X + ", " + Y + " = ");
				int Z = input.nextInt();
				if (Z < 0 || Z > 4) {
					System.out.println("That is not a valid number");
					Y--;
				}
				else if (checkInput(Z)) {
					tempMap[X][Y] = Z;
				}
				else {
					Y--;
				}
			}
		}
		checkNumbers();
	}
	
	private boolean checkInput(int Z) {
		switch (Z) {
		case 0: return true;
		case 1: return true;
		case 2: if (tempObject == objectCount) {
			System.out.println(" you have already placed " + objectCount + "objects.");
			return false;
			}
		else {
			tempObject++;
			return true;
		}
		case 3: if (tempMonster == monsterCount) {
			System.out.println(" you have already placed " + monsterCount + "objects.");
			return false;
			}
		else {
			tempMonster++;
			return true;
		}
		case 4: if (tempExit == exitCount) {
			System.out.println("You can only have 1 exit...");
			return false;
		}
		else {
			tempExit++;
			return true;
		}
		}
		return false;
	}
	
	public void startLoc() {
		System.out.println("Enetr and X and Y coordinates for starting location: ");
		System.out.println("X = ");
		c = input.nextInt();
		if (c < 0 || c > a - 1) {
			System.out.println("You have to start inside the maze...");
			startLoc();
		}
		System.out.println("Y = ");
		d = input.nextInt();
		if (d < 0 || d > b - 1) {
			System.out.println("You have to start inside the maze...");
			startLoc();
		}
		
	}

	public void heros() {
		for (int i = 1; i < playerCount +1; i++) {
			System.out.println("Player " + i + ", enter name: ");
			name = input.next();
			buildHero(i, name);
		}
	}
	
	public void buildHero(int i, String name) {
		switch (i) {
		case 1: Hero hero1 = new Hero(a, b, name);	characters.add(hero1); break;
		case 2: Hero hero2 = new Hero(a, b, name);	characters.add(hero2); break;
		case 3: Hero hero3 = new Hero(a, b, name);	characters.add(hero3); break;
		case 4: Hero hero4 = new Hero(a, b, name);	characters.add(hero4); break;
		case 5: Hero hero5 = new Hero(a, b, name);	characters.add(hero5); break;
		case 6: Hero hero6 = new Hero(a, b, name);	characters.add(hero6); break;
		case 7: Hero hero7 = new Hero(a, b, name);	characters.add(hero7); break;
		case 8: Hero hero8 = new Hero(a, b, name);	characters.add(hero8); break;
		case 9: Hero hero9 = new Hero(a, b, name);	characters.add(hero9); break;
		case 10: Hero hero10 = new Hero(a, b, name);characters.add(hero10); break;
		}
	}

	public void minotaurs() {
		for (int i = 1; i < minCount + 1; i ++) {
			System.out.println("Place Minotaur " + i);
			release = getEF();
			if (release) {
				buildMinotaur(e, f, i);
			}
			else {
				i--;
			}
		}
	}
	
	public void buildMinotaur(int e, int f, int i) {
		switch (i) {
		case 1: Minotaur minotaur1 = new Minotaur(e, f); characters.add(minotaur1); break;
		case 2: Minotaur minotaur2 = new Minotaur(e, f); characters.add(minotaur2); break;
		case 3: Minotaur minotaur3 = new Minotaur(e, f); characters.add(minotaur3); break;
		case 4: Minotaur minotaur4 = new Minotaur(e, f); characters.add(minotaur4); break;
		case 5: Minotaur minotaur5 = new Minotaur(e, f); characters.add(minotaur5); break;
		case 6: Minotaur minotaur6 = new Minotaur(e, f); characters.add(minotaur6); break;
		case 7: Minotaur minotaur7 = new Minotaur(e, f); characters.add(minotaur7); break;
		case 8: Minotaur minotaur8 = new Minotaur(e, f); characters.add(minotaur8); break;
		case 9: Minotaur minotaur9 = new Minotaur(e, f); characters.add(minotaur9); break;
		case 10: Minotaur minotaur10 = new Minotaur(e, f); characters.add(minotaur10); break;
		}
	}

	public void monsters() {
		System.out.println("How many goblins in your maze? ");
		g = input.nextInt();
		System.out.println("How many Locks in your maze? ");
		h = input.nextInt();
		if (g+h > monsterCount) {
			System.out.println("You have too many monsters");
			System.out.println("You placed spots for " + monsterCount + " monsters.");
			monsters();
		}
		for(int i = 1; i < g + 1; i ++) {
			System.out.println("Place goblin " + i);
			release = getEF();
			if (release) {
				buildGoblin(e, f, i);
			}
			else {
				i--;
			}
		}
		
		for (int i = 1; i < h + 1; i ++) {
			System.out.println("Place lock " + i);
			release = getEF();
			if (release) {
				buildLock(e, f, i);
			}
			else {
				i--;
			}
		}
	}

	public void buildGoblin(int e, int f, int i) {
		switch (i) {
		case 1: Goblin goblin1 = new Goblin(e, f); monsters.add(goblin1); break;
		case 2: Goblin goblin2 = new Goblin(e, f); monsters.add(goblin2); break;
		case 3: Goblin goblin3 = new Goblin(e, f); monsters.add(goblin3); break;
		case 4: Goblin goblin4 = new Goblin(e, f); monsters.add(goblin4); break;
		case 5: Goblin goblin5 = new Goblin(e, f); monsters.add(goblin5); break;
		case 6: Goblin goblin6 = new Goblin(e, f); monsters.add(goblin6); break;
		case 7: Goblin goblin7 = new Goblin(e, f); monsters.add(goblin7); break;
		case 8: Goblin goblin8 = new Goblin(e, f); monsters.add(goblin8); break;
		case 9: Goblin goblin9 = new Goblin(e, f); monsters.add(goblin9); break;
		case 10: Goblin goblin10 = new Goblin(e, f); monsters.add(goblin10); break;
		}
	}
	
	public void buildLock(int e, int f, int i) {
		System.out.println("What is the combination of this lock? ");
		System.out.println("Coresponding keys must have same combo to unlock locks.");
		System.out.println("Exit will not open until all Maze Locks have been unlocked.");
		combination = input.nextInt();
		
		switch (i) {
		case 1: Lock lock1 = new Lock(e, f, combination); monsters.add(lock1); mazelocks.add(lock1); break;
		case 2: Lock lock2 = new Lock(e, f, combination); monsters.add(lock2); mazelocks.add(lock2);break;
		case 3: Lock lock3 = new Lock(e, f, combination); monsters.add(lock3); mazelocks.add(lock3);break;
		case 4: Lock lock4 = new Lock(e, f, combination); monsters.add(lock4); mazelocks.add(lock4);break;
		case 5: Lock lock5 = new Lock(e, f, combination); monsters.add(lock5); mazelocks.add(lock5);break;
		case 6: Lock lock6 = new Lock(e, f, combination); monsters.add(lock6); mazelocks.add(lock6);break;
		case 7: Lock lock7 = new Lock(e, f, combination); monsters.add(lock7); mazelocks.add(lock7);break;
		case 8: Lock lock8 = new Lock(e, f, combination); monsters.add(lock8); mazelocks.add(lock8);break;
		case 9: Lock lock9 = new Lock(e, f, combination); monsters.add(lock9); mazelocks.add(lock9);break;
		case 10: Lock lock10 = new Lock(e, f, combination); monsters.add(lock10); mazelocks.add(lock10);break;
		}
	}

	public void objects() {
		System.out.println("How many gold coins in your maze? ");
		g = input.nextInt();
		System.out.println("How many keys in your maze? ");
		h = input.nextInt();
		if (g+h > objectCount) {
			System.out.println("You have too many objects");
			System.out.println("You placed spots for " + objectCount + " objects.");
			objects();
		}
		for(int i = 1; i < g + 1; i ++) {
			System.out.println("Place gold coin " + i);
			release = getEF();
			if (release) {
				buildGold(e, f, i);
			}
			else {
				i--;
			}
		}
		
		for (int i = 1; i < h + 1; i ++) {
			System.out.println("Place key " + i);
			release = getEF();
			if (release) {
				buildKey(e, f, i);
			}
			else {
				i--;
			}
		}
	}
	
	public void buildGold(int e, int f, int i) {
		switch (i) {
		case 1: GoldCoin gold1 = new GoldCoin(e, f); objects.add(gold1);	break;
		case 2: GoldCoin gold2 = new GoldCoin(e, f); objects.add(gold2);	break;
		case 3: GoldCoin gold3 = new GoldCoin(e, f); objects.add(gold3);	break;
		case 4: GoldCoin gold4 = new GoldCoin(e, f); objects.add(gold4);	break;
		case 5: GoldCoin gold5 = new GoldCoin(e, f); objects.add(gold5);	break;
		case 6: GoldCoin gold6 = new GoldCoin(e, f); objects.add(gold6);	break;
		case 7: GoldCoin gold7 = new GoldCoin(e, f); objects.add(gold7);	break;
		case 8: GoldCoin gold8 = new GoldCoin(e, f); objects.add(gold8);	break;
		case 9: GoldCoin gold9 = new GoldCoin(e, f); objects.add(gold9);	break;
		case 10: GoldCoin gold10 = new GoldCoin(e, f); objects.add(gold10);	break;
		}
	}
	
	public void buildKey(int e, int f, int i) {
		System.out.println("What is the combination of this key? ");
		System.out.println("Coresponding locks must have same combo to be unlocked.");
		System.out.println("Exit will not open until all Maze Locks have been unlocked.");
		combination = input.nextInt();
		
		switch (i) {
		case 1: Key key1 = new Key(e, f, combination); objects.add(key1); break;
		case 2: Key key2 = new Key(e, f, combination); objects.add(key2); break;
		case 3: Key key3 = new Key(e, f, combination); objects.add(key3); break;
		case 4: Key key4 = new Key(e, f, combination); objects.add(key4); break;
		case 5: Key key5 = new Key(e, f, combination); objects.add(key5); break;
		case 6: Key key6 = new Key(e, f, combination); objects.add(key6); break;
		case 7: Key key7 = new Key(e, f, combination); objects.add(key7); break;
		case 8: Key key8 = new Key(e, f, combination); objects.add(key8); break;
		case 9: Key key9 = new Key(e, f, combination); objects.add(key9); break;
		case 10: Key key10 = new Key(e, f, combination); objects.add(key10); break;
		}
	}
	
	public boolean getEF() {
		System.out.println("X = ");
		e = input.nextInt();
		System.out.println("Y = ");
		f = input.nextInt();
		if (f < 0 || f > b - 1 || e < 0 || e > a - 1) {
			System.out.println("It has to start inside the maze...");
			release = false;
		}
		else {
			release = true;
		}
		return release;
		
	}

	public void checkNumbers() {
		if (tempMonster == monsterCount && tempObject == objectCount && tempExit == 1) {
			System.out.println("Great looking maze!"); 
			System.out.println("Lets populate it.");
			map = new Map(tempMap);
			return;
		}
		if (tempMonster != monsterCount) {
			add = "monster";
			w = monsterCount - tempMonster;
			z = 3;
			tempMonster = adder(add, w, z, tempMonster);			
		}
		
		if (tempObject != objectCount) {
			add = "object";
			w = objectCount - tempObject;
			z = 2;
			tempObject = adder(add, w, z, tempObject);
		}
		if (tempExit != 1) {
			add = "exit";
			w = 1;
			z = 4;
			tempExit = adder(add, w, z, tempExit);
		}
		checkNumbers();
	}
	
	public int adder(String add, int w, int z, int k) {
		System.out.println("You haven't added enough " + add + " spots...");
		System.out.println("Would you like to add " + add + "s ...");
		System.out.println("or start over?");
		System.out.println("add/new");
		answer = input.next();
		
		if (answer.equalsIgnoreCase("new")) {
			startOver();			
		}
		
		System.out.println("You need to add " + w + " " + add);
		for (int i = 0; i < w; i ++) {
			System.out.println("Add " + add + " " + w);
			
			if (getEF() && checkAdd()) {
				tempMap[e][f] = z;
				k++;
			}
		}
		return k;
	}
	
	public void startOver() {
		System.out.println("WARNING!!!");
		System.out.println("You have chosen to start over.");
		System.out.println("All progress to this point will be discarded.  Are you sure?");
		System.out.println("y/n");
		answer = input.next();
		
		if (answer.equalsIgnoreCase("y")) {
			characters.clear();
			monsters.clear();
			objects.clear();
			
			map();
		}
		
		else {
			return;
		}
	}

	public boolean checkAdd() {
		v = tempMap[e][f];
		
		if (v == 0 || v == 1) {
			return true;
		}
		else if (v == 2) {
			System.out.println("You already placed an object there.");
			return false;
		}
		else if (v == 3) {
			System.out.println("You already placed a monster there.");
			return false;
		}
		else if (v == 4) {
			System.out.println("That is the exit");
			return false;
		}
		else {
			return false;
		}
		
	}

	public void defaultMap() {		
		tempMap = new int[][] {
			{0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{2, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
			{0, 0, 1, 0, 1, 0, 1, 1, 0, 1},
			{1, 1, 1, 0, 4, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 1, 0, 2, 1, 1, 1},
			{1, 1, 1, 1, 3, 1, 1, 0, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
			{5, 0, 1, 1, 1, 1, 1, 0, 3, 0}};	
		
		map = new Map(tempMap);
	}

}
