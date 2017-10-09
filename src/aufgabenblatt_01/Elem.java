package aufgabenblatt_01;
/**
 * Generic class Elem with a Key and an Element <T>
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 1
 * 
 * 
 * @author Philip Scheer <philip.scheer@haw-hamburg.de>
 * @author Dennis Sentler <dennis.sentler@haw-hamburg.de>
 * @author Paul Mathia <paul.mathia@haw-hamburg.de>
 * @author Stefan Subotin <stefan.subotin@haw-hamburg.de>
 * 
 * @date 09.10.2017
 *
 */
public class Elem<T> {


	// primary key which clearly identifies this object. 
	private Key key;
	//generic data element 
	private T element;
	
	/*
	 * Constructor
	 */
	public Elem(T element, Key key)
	{
		this.element = element;
		// creates a unique key using the hashcode method of the class "integer"
		this.key = key;
	}
	
	/**
	 * getter
	 * @return key 
	 */
	public Key getKey()
	{
		return key;
	}
	/**
	 * setter
	 * @param key
	 */
	public void setKey(Key key)
	{
		this.key = key;
	}

	/** getter
	 * @return element
	 */
	public T getElement()
	{
		return element;
	}
	
	public void setElement(T elem)
	{
		this.element = elem; 
	}
}