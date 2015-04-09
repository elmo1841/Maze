import java.util.Scanner;


public class Map {
	private int[][] map;
	private String[][] writeMap;
	private boolean[][] readMap;
	private Scanner input;

	public Map(int[][] map) {
		this.map = map;
		this.writeMap = makeMap(map);
		readMap = new boolean[map.length][map[0].length];
	}
	
	public int getMapCoordinate(int a, int b) {
		return map[a][b];
	}
	
	public String getWrite(int a, int b) {
		return writeMap[a][b];
	}
	
	public boolean getRead(int a, int b) {
		return readMap[a][b];
	}
	
	public void setMapCoordinate(int a, int b, int c) {
		map[a][b] = c;
	}
	
	
	public void setRead(int a, int b) {
		readMap[a][b] = true;
	}
	
	public void setPiece(Character e) {									 																
		e.setF(map[e.getX()][e.getY()]);				//character "me" gets placed on new location,										
		map[e.getX()][e.getY()] = e.getMe();			//F gets stored to be replaced later
	}
	
	public String[][] makeMap(int[][] coordinateMap) {
		writeMap = new String[coordinateMap.length][coordinateMap[0].length];
		
		for(int i = 0; i < writeMap.length; i ++) {
			for(int j = 0; j < writeMap[i].length; j++) {
				if (coordinateMap[i][j] == 0) {
					writeMap[i][j] = "[]";
				}
				else {
					writeMap[i][j] = "  ";
				}
			}
		}
		
		
		return writeMap;
	}

	public void printMap(int a, int b) {
		//System.out.println("called");
		writeMap(a, b);
		for (int k = 0; k < map[0].length + 2; k ++) {
			System.out.print("[]");

		}
		System.out.print("\n");
		for (int i = 0; i < map.length; i ++) {
			System.out.print("[]");
			for (int j = 0; j < map[i].length; j++) {
				if (a == i && b == j) {
					System.out.print(" X");
				}
				else if (readMap[i][j]) {
					System.out.print(writeMap[i][j]);
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.print("[]\n");
		}
		for (int k = 0; k < map[0].length + 2; k ++) {
			System.out.print("[]");
		}	
		System.out.print("\n");
	}
	
	public void writeMap(int a, int b) {
		
		for (int i = -1; i < 2; i ++) {
			for (int k = -1; k < 2; k ++) {
				try {
					if ((a + i) < 0 || (a + i) > (map.length - 1) 
						|| (b+k < 0) || (b + k > (map[0].length - 1))) { //check north south
						throw new MazeException(); 
					}	//maze exception is for player at edge of map
					
					setRead(a+i, b+k);
			
					
					}
				catch (MazeException ex) {	
					}
			}
		}
	}

	public void found(Character e) throws InterruptedException {
		input = new Scanner(System.in);
		System.out.println(e.getName() + " found a map..."); Thread.sleep(500);
		System.out.println("Do you want to pick it up? Y/N");
		if (input.next().equals("y")) {
			e.setIsMapping(true);
			e.setF(1);
		}
		
	}

}