import java.util.Scanner;

public class Open {
	private Scanner input;
	private int z;

	public Open() throws InterruptedException {
		
	}
	
	public void splash() throws InterruptedException {
		System.out.println("Welcome to...\n");
		Thread.sleep(1000);
		System.out.println("M     M      A       ZZZZ    EEEEE");
		Thread.sleep(100);
		System.out.println("M M M M     A A        Z     E    ");
		Thread.sleep(100);
		System.out.println("M  M  M    AAAAA      Z      EEE  ");
		Thread.sleep(100);
		System.out.println("M     M   A     A    Z       E    ");
		Thread.sleep(100);
		System.out.println("M     M  A       A  ZZZZZ    EEEEE\n");
		Thread.sleep(500);
	}
	
	public int list() {
		input = new Scanner(System.in);
		System.out.println("What would you like to do: ");
		System.out.println("1. Instructions");
		System.out.println("2. Play");
		System.out.println("3. Create your own");
		System.out.println("4. Exit");
		
		z = input.nextInt();
		
		return z;
	}
	
	
	
	public void instructions() {
		try {
		TutorialMaze tutorial1 = new TutorialMaze();
		}
		catch(InterruptedException ex) {
			
		}
	}
	
	public void build()  {
		try {
		//System.out.println("Build your own maze will appear here");
		Builder build1 = new Builder();
		}
		catch(InterruptedException ex) {
			
		}
	}
	
	public void play() {
		try {
			//System.out.println("Build your own maze will appear here");
			Builder build1 = new Builder(5, 5);
			}
			catch(InterruptedException ex) {
				
			}
	}
}
