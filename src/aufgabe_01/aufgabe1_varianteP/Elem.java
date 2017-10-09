package aufgabe1;

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