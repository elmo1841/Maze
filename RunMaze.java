
public class RunMaze {
	public static void main(String[] arguments) throws InterruptedException {
	
		int z = 0;
		
	Open open = new Open();
	open.splash();
	
	while (z != 4) {
		z = open.list();
	
		switch (z) {
		case 1: open.instructions();	break;
		case 2: open.play();			break;
		case 3: open.build();			break;
		case 4: z = 4;
		}
	
	}	
	System.out.println("Goodbye");
	}
}
