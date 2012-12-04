
public class LinkedListHazards {
		
	private FlyingHazard head;
	
	//creats the list of Hazards
	public LinkedListHazards(){
		head = null;
	}
	
	//adds another Hazard
	public void addtoStart(int difficulty){
		head = new FlyingHazard(difficulty, head);
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
}

