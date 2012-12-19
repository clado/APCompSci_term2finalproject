import java.io.IOException;


public class LinkedListHazards {
		
	private FlyingHazard head;
	
	//creats the list of Hazards
	public LinkedListHazards(){
		head = null;
	}
	
	//adds another Hazard
	public void addtoStart(int difficulty){
		try {
			head = new FlyingHazard(difficulty, head);
		} catch (IOException e) {
			System.out.println("Hazard img not found.");
			e.printStackTrace();
		}
	}
	
	/**
	 * calculates the amount of Hazards, possibly obsolete
	 * think about deleting this
	 */
	public int size(){
		int count = 0;
		FlyingHazard position = head;
		while (position != null){
			count ++;
			position = position.getLink();
		}
		return count;
	}
	
	public void incObjects(){
		
	}
}

