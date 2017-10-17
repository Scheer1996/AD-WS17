package src.aufgabenblatt_01;
/**
 * Generic class Elem with a Key and an Element with extra Prev and Next methods
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 2b
 * 
 * @author Philip Scheer - philip.scheer@haw-hamburg.de
 * @author Dennis Sentler - dennis.sentler@haw-hamburg.de
 * @author Paul Mathia - paul.mathia@haw-hamburg.de
 * @author Stefan Subotin - stefan.subotin@haw-hamburg.de
 * 
 * 09.10.2017
 *
 */

public class ElemPrevNext<T> extends Elem<T>{
	
	/**
	 * the index of the Element before this one
	 */
	private int previousElement;

	/**
	 * the index of Element after this one
	 */
	private int nextElement;
	
	
	/*
	 * Constructor
	 * after creating a ElemPrevNext object the reference of the indices of this object 
	 * is pointing to -1 
	 */
	public ElemPrevNext(T element, Key key) {
		super(element, key);
		this.previousElement = -1;
		this.nextElement = -1; 
		
	}
	
	public void setPreviousIndex(int previousIndex) 
	{
		this.previousElement = previousIndex;
	}
	
	public void setNextIndex(int nextIndex)
	{
		this.nextElement = nextIndex;
	}
	

	public int getPreviousIndex() {
		return previousElement;
	}
	
	public int getNextIndex()
	{
		return nextElement;
	}
	

}
