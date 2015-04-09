import java.util.Scanner;


public class Lock extends Monster {

	private int z;
	private int combination;
	private boolean lock;
	private String answer;
	private Scanner input;
	
	public Lock(int a, int b, int c) {
		super(a, b);
		combination = c;
		lock = false;
	}

	public int getCombination() {
		return combination;
	}
	
	public boolean getLock() {
		return lock;
	}
	
	public int play(Character e) throws InterruptedException {
		input = new Scanner(System.in);
		
		System.out.println("There is something here in the wall"); Thread.sleep(500);
		System.out.println("It looks like a keyhole"); Thread.sleep(500);
		System.out.println("Do you have anything that would work here?  y/n");
		answer = input.next();
		
		if (answer.equalsIgnoreCase("n")) {
			return 0;
		}
		if (answer.equalsIgnoreCase("y")) {
			z = e.checkPocket("Key", this);
			if (z == 1) {
				System.out.println("This key seems to fit."); Thread.sleep(200);
				lock = true;
				return 0;
			}
			if (z == 2) {
				System.out.println("You don't seem to have a key that fits this lock."); Thread.sleep(200);
				return 0;
			}
		}
		return 0;
		
	}
	public boolean compatible(FoundObject i) {
		if (i.getObject().equalsIgnoreCase("Key") && ((Key) i).getCombination() == combination) {
			return true;
		}
		return false;
	}

}
