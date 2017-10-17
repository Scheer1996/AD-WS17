package aufgabenblatt_01.archiv.philipScheer;

/**
 * Interface for diffrent Implentations
 * @author Philip Scheer
 * @version 1.0 - 28.09.2017
 *
 */
public interface Set {

	/**
	 * Adds a new element to the list
	 * @param elem
	 * @return index where the element is stored
	 */
	public int add(Elem elem);
	
	/**
	 * Delete a element at a specific index
	 * @param index
	 */
	public void delete(int index);
	
	/**
	 * Deleted a element with a specific key
	 * @param key
	 */
	public void delete(Key key);
	
	/**
	 * Find a value in the list
	 * @param key
	 * @return return index of the the element or zero if no element was found
	 */
	public int find(Key key);
	
	/**
	 * Retrieves a value from the list
	 * @param index
	 * @return the element
	 */
	public Elem retrieve(int index);

	/**
	 * Puts out all data of the list in the console
	 */
	public void showall();
	
	/**
	 * 
	 * @return the number of elements
	 */
	public int size();
	
	
	/**
	 * Unify two lists together
	 * @param other another list
	 * @return the new complete List
	 */
	public Set unify(Set other);
	
}
