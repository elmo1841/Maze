
public class Maze {
	private int[][] map;
	private int x;
	private int y;
	private int z;
	private Character hero;
	private Command command;
	
	public Maze() {
		map = setCoordinates();
		hero = new Character(5, 5);
		z = 1;
	}
	
	public void runMaze() {
		commandCreate();
	}
	
	public void commandCreate() {
		while (z != 0) {
			x = hero.getX();
			y = hero.getY();
			command = new Command(x, y, map);
			z = command.turn();
			hero.movement(z);
		}
	}
	
	

	
	
	
	
	//sets the default maze if a no arg constructor is called
	public int[][] setCoordinates() {		
		map = new int[][] {
			{0, 0, 0, 0, 0, 0, 3, 0, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{2, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
			{0, 0, 1, 0, 1, 0, 1, 1, 0, 1},
			{1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
			{1, 1, 1, 1, 2, 1, 1, 0, 1, 1},
			{1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
			{4, 0, 1, 1, 1, 1, 1, 0, 3, 0}};		
		return map;
	}
}
