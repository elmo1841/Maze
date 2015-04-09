import java.util.Scanner;


public class Goblin extends Monster{
	private String answer;
	private Scanner input;
	private int z;
	
	public Goblin (int a, int b) {
		super(a, b);
	}
	
	@Override
	public int play(Character e) throws InterruptedException {
		input = new Scanner(System.in);
		answer = " ";
		System.out.println("A goblin is blocking your way..."); Thread.sleep(500);
		System.out.println("Do you want to go around it..."); Thread.sleep(100);
		System.out.println("or try to talk to it?"); Thread.sleep(500);
		System.out.println("talk/move ?");
		
		answer = input.next();
		
		if (answer.equalsIgnoreCase("talk")) {
			z = talk(e);
		}
		else if (answer.equalsIgnoreCase("move")) {
			z = move(e);
		}
		else {
			System.out.println("That is not an answer...");
			play(e);
		}
		
		return z;
	}
	
	public int move(Character e) throws InterruptedException {
		System.out.print("You try to go around"); Thread.sleep(200);
		System.out.print("and...");
		return 1;
	}
	
	public int talk(Character e) throws InterruptedException {
		answer = " ";
		input = new Scanner(System.in);
		System.out.println("'You have to pay if you want to pass.'"); Thread.sleep(300);
		System.out.println("Should we pay?"); Thread.sleep(200);
		System.out.println("yes/no");
		answer = input.next();
		if (answer.equalsIgnoreCase("yes")) {
			z = e.checkPocket("Gold Coin", this);
			if (z == 0) {
				return 0;
			}
			if (z == 1) {
				System.out.println("'Thank you very much'"); Thread.sleep(300);
				System.out.println("It takes your money and goes away."); Thread.sleep(300);
				e.setF(1);
				return 0;
			}
			if (z == 2) {
				System.out.println("'You have nothing of value'"); Thread.sleep(300);
				return 1;
			}
		}
		if (answer.equalsIgnoreCase("no")) {
			System.out.println("'That wasn't nice...'"); Thread.sleep(300);
			return 1;
		}
		return 0;
	}
	
	public boolean compatible(FoundObject i) {
		if (i.getObject().equalsIgnoreCase("Gold Coin")) {
			return true;
		}
		return false;
	}
	

}



