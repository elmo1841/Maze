import java.util.ArrayList;


public class Pocket {
	private ArrayList<FoundObject> pocket;

	public Pocket() {
		pocket = new ArrayList<>();
	}
	
	public void add(FoundObject e) {
		pocket.add(e);
	}
	
	public void remove(FoundObject e) {
		pocket.remove(e);
	}
	
	public void getPocket() {
		System.out.println(pocket);
	}
	
	public int checkPocket(String h, Monster m) {
		int z = 0;
		int w = 0;
		boolean hadIt = false;
		if (pocket.size() == 0) {
			return 2;
		}
		for (FoundObject i: pocket) {
			String j = i.getObject();
			if (j == h && m.compatible(i)) {
				w = pocket.indexOf(i);
				z = 1;
				hadIt = true;
			}
		}
		if (hadIt) {
			pocket.remove(w);
		}
		else {
			z = 2;
		}
		
		return z;
		
	}
	
	
}
