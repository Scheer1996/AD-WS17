package aufgabe_01.b;

public class Key
{
	private final int _KEY;
	
	Key(int key)
	{
		_KEY = key;
	}
	
	public int getIntKey()
	{
		return _KEY;
	}
	
	@Override
	public int hashCode()
	{
		return _KEY;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false;
		if (obj instanceof Key && obj.hashCode() == this.hashCode())
			result = true;
		return result;
	}
}
