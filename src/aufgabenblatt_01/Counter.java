package aufgabenblatt_01;


public class Counter {

	/**
	 * the total count
	 */
	private long count;
	
	public Counter(){
		count = 0;
	}
	
	/**
	 * increments the counter by 1
	 */
	public void increment(){
		count++;
	}
	
	public void incrementBy(int amount) {
		count += amount;
	}
	
	/**
	 * resets the counter to 0
	 */
	public void reset(){
		count = 0;
	}
	
	public long getCount(){
		return count;
	}
	
}
