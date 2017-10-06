package aufgabe_01;

public class ArrayList implements Set {

	/**
	 * start Size
	 */
	private static final int START_SIZE = 10;
	
	
	/**
	 * growth factor
	 */
	private static final int GROWTH_FACTOR = 2;
	
	/**
	 * array for storing the data
	 */
	protected Object[] data = new Object[START_SIZE];
	
	/**
	 * Number of elements stored
	 */
	protected int count = 0;
	
	@Override
	public int add(Elem elem) {
		// new array
		if(count == data.length) {
			// create new array
			Object[] tmp = new Object[(int) data.length * GROWTH_FACTOR];
			
			//copy all existing elements to new array
			System.arraycopy(data, 0, tmp, 0, data.length);
			
			data = tmp;
		}
		
		// add new element to data
		data[count] = elem;
		
		// increase count
		count++;
		
		return count;
	}

	@Override
	public void delete(int index) {
		// checking if index is out of bounds
		if(index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}
		
		// decrease count
		count--;
		
		// item is on last position nothing todo
		if(index == count) {
			/**
			 * TODO check if array could be decreased
			 */
		} else {
			/**
			 * TODO check if array could be decreased 
			 */
			
			// foreach element after pos.index -> move one forward
			for(int i = index; i < count; i++) {
				data[i] = data[i + 1];
			}
		}
	}

	@Override
	public void delete(Key key) {
		int index = find(key);
		delete(index);
	}

	@Override
	public int find(Key key) {
		for(int i = 0; i < count; i++) {
			// check if elem key is equals to key
			if(((Elem) data[i]).key.equals(key)) {
				return i;
				//need to return position
			}
		}
		
		return 0;
	}

	@Override
	public Elem retrieve(int index) {
		// checking if index is out of bounds
		if(index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}
		
		/**
		 * unchecked cast is safe -> knowing that only Elements of type T exists in this array
		 */
		return (Elem) data[index];
	}

	@Override
	public void showall() {
		for(int i = 0; i < count; i++) {
			Elem elem = (Elem) retrieve(i);
			System.out.println(i+"\t- "+elem.key.toString()+"\t DATA: "+elem.data);
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Set unify(Set other) {
		for(int i = 0; i < other.size(); i++) {
			add(other.retrieve(i));
		}
		
		return this;
	}

}
