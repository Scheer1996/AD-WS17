package aufgabenblatt_01.archiv.dennisSentler;

public class Container
{
	
	
	private int _nextIndx;
	private int _prevIndx;
	private Elem _elem;
	
	Container(Elem elem, int prev, int next)
	{
		_elem = elem;
		_nextIndx = next;
		_prevIndx = prev;
	}
	
	public int getNextIndx()
	{
		return _nextIndx;
	}
	
	public int getPrevIndx()
	{
		return _prevIndx;
	}
	
	public void setNextIndx(int newIndx)
	{
		_nextIndx = newIndx;
	}
	
	public void setPrevIndx(int newIndx)
	{
		_prevIndx = newIndx;
	}
	
	public Elem getElem()
	{
		return _elem;
	}
	

}
