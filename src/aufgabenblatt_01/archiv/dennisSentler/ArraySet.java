package aufgabenblatt_01.archiv.dennisSentler;

/**
 * Interface for diffrent Implentations
 * 
 * @author Philip Scheer
 * @version 1.0 - 28.09.2017
 *
 */
public class ArraySet<T extends Elem>
{
	private Container[] _ContainerArray;
	private int _indx;
	private int _setSize;

	ArraySet()
	{
		_ContainerArray = new Container[5];
		_indx = 1;
		_setSize = 0;
	}

	/**
	 * Adds a new element to the list
	 * 
	 * @param elem
	 * @return index where the element is stored
	 */
	public int add(T element)
	{
		if(contains(element.getKey()))
		{
			return find(element.getKey());
			
		} else
		{
			if(_indx + 1 < _ContainerArray.length)
			{
				_ContainerArray[_indx] = new Container(element, _indx - 1, _indx + 1);
				_indx++;
				_setSize++;
			} else
			{
				Container[] temp = new Container[_ContainerArray.length * 2];
				System.arraycopy(_ContainerArray, 0, temp, 0, _ContainerArray.length);
				_ContainerArray = temp;

				_ContainerArray[_indx] = new Container(element, _indx - 1, _indx + 1);

				_indx++;
				_setSize++;
			}
			return _indx - 1;
		}
	}
	

	/**
	 * Delete a element at a specific index
	 * 
	 * @param index
	 */
	public void delete(int index)
	{
		int naechster = _ContainerArray[index].getNextIndx();
		int vorheriger = _ContainerArray[index].getPrevIndx();
		if(_ContainerArray[naechster] != null)
			_ContainerArray[naechster].setPrevIndx(vorheriger);
		if(_ContainerArray[vorheriger] != null)
			_ContainerArray[vorheriger].setNextIndx(naechster);

		_ContainerArray[index] = null;
		_setSize--;
	}

	/**
	 * Deleted a element with a specific key
	 * 
	 * @param key
	 */
	public void delete(Key key)
	{
		if(contains(key))
			delete(find(key));

	}

	private boolean contains(Key key)
	{
		boolean result = false;
		if(find(key) != 0)
			result = true;
		return result;
	}

	/**
	 * Find a value in the list
	 * 
	 * @param key
	 * @return return index of the the element or zero if no element was found
	 */
	public int find(Key key)
	{
		for(int i = 0; i < _ContainerArray.length; i++)
		{
			if(_ContainerArray[i] != null && _ContainerArray[i].getElem().getKey().equals(key))
			{
				return i;
			}
		}
		return 0;
	}

	/**
	 * Retrieves a value from the list
	 * 
	 * @param index
	 * @return the element
	 */
	public T retrieve(int index)
	{
		if(_ContainerArray[index] == null)
			return null;
		else
		{
			return (T) _ContainerArray[index].getElem();
		}
	}

	/**
	 * Puts out all data of the list in the console
	 */
	public void showall()
	{

	}

	/**
	 * 
	 * @return the number of elements
	 */
	public int size()
	{
		return _setSize;
	}

	/**
	 * Unify two lists together
	 * 
	 * @param s
	 *            one list
	 * @param t
	 *            another list
	 * @return the new complete List
	 */
	public ArraySet<T> unify(ArraySet<T> s, ArraySet<T> t)
	{
		ArraySet<T> unified = new ArraySet<T>();
		for(int i = 0; i < _ContainerArray.length; i++)
		{
			if(s.retrieve(i) != null)
			{
				unified.add(s.retrieve(i));
			}
		}
		for(int j = 0; j < _ContainerArray.length; j++)
		{
			if(!(unified.contains(_ContainerArray[j].getElem().getKey()) && t.retrieve(j) != null))
			{
				unified.add(t.retrieve(j));
			}
		}
		return unified;
	}

}
