package aufgabe1;

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
