package src.aufgabenblatt_01;

/**
 * Interface for diffrent Implentations
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 1
 * 
 * @author Philip Scheer - philip.scheer@haw-hamburg.de
 * @author Dennis Sentler - dennis.sentler@haw-hamburg.de
 * @author Paul Mathia - paul.mathia@haw-hamburg.de
 * @author Stefan Subotin - stefan.subotin@haw-hamburg.de
 * 
 * 09.10.2017
 *
 */
public interface Set {

	/**
	 * Adds a new element to the list
	 * @param elem
	 * @return index where the element is stored
	 */
	public Pos add(Elem<?> elem);
	
	/**
	 * Delete a element at a specific index
	 * @param index
	 */
	public void deletePos(Pos<?> pos);

	/**
	 * Deleted a element with a specific key
	 * @param key Key of the Elment which should be deleted
	 */
	public void deleteKey(Key key);
	
	/**
	 * Find a value in the list
	 * @param key
	 * @return return index of the the element or zero if no element was found
	 */
	public Pos<?> find(Key key);
	
	/**
	 * Retrieves a value from the list
	 * @param index
	 * @return the element
	 */
	public Elem<?> retrieve(Pos<?> pos);

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
	 * @param s one list
	 * @param t another list
	 * @return the new complete List
	 */
	public Set unify(Set s, Set t);
}