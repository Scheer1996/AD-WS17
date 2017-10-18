package aufgabenblatt_01;

/**
 * Saving Elements in an Array whichs size gets doubled when there is no more
 * space in the current Array
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 1a
 * 
 * @author Philip Scheer - philip.scheer@haw-hamburg.de
 * @author Dennis Sentler - dennis.sentler@haw-hamburg.de
 * @author Paul Mathia - paul.mathia@haw-hamburg.de
 * @author Stefan Subotin - stefan.subotin@haw-hamburg.de
 * 
 *         09.10.2017
 *
 */
public class ArrayList<T> implements Set {

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

    /**
     * the counter to collect data about operations
     */
    public Counter counter;

    public ArrayList() {
        this(new Counter());
    }

    public ArrayList(Counter counter) {
        this.counter = counter;
    }
    
	@Override
	public Pos<?> add(Elem<?> elem) {
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		// new array
		if (contains(elem)) {
			if (count == data.length) {
				// create new array
				Object[] tmp = new Object[(int) data.length * GROWTH_FACTOR];

				// copy all existing elements to new array
				System.arraycopy(data, 0, tmp, 0, data.length);

				
		        // PERFORMANCE COUNTER
		        counter.incrementBy(2 * count);
		        // PERFORMANCE COUNTER
				data = tmp;
			}

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
	        
			// add new element to data
			data[count] = elem;

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
	        
			// increase count
			count++;
			return new Pos<Integer>(count-1, true);
		} else
			return find(elem.getKey());
	}

	@Override
	public void deletePos(Pos<?> pos) {

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		// checking if index is out of bounds
		int index = (int) pos.getPointer();

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		if (index < 0 || index >= count || !pos.isvalid()) {
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}


        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		// decrease count
		count--;


        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		// item is on last position nothing todo
		if (index == count) {
			/**
			 * TODO check if array could be decreased
			 */
		} else {
			/**
			 * TODO check if array could be decreased
			 */

			// foreach element after pos.index -> move one forward
			for (int i = index; i < count; i++) {

		        // PERFORMANCE COUNTER
		        counter.increment();
		        // PERFORMANCE COUNTER
		        
				data[i] = data[i + 1];
			}
		}
	}

	@Override
	public void deleteKey(Key key) {

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		Pos<?> pos = find(key);

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		deletePos(pos);
	}

	@Override
	public Pos<?> find(Key key) {
		for (int i = 0; i < count; i++) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
	        
			// check if elem key is equals to key
			if (((Elem<?>) data[i]).getKey().equals(key)) {

		        // PERFORMANCE COUNTER
		        counter.increment();
		        // PERFORMANCE COUNTER
		        
				Pos<Integer> output = new Pos<Integer>(i, true);
				return output;
				// need to return position
			}
		}

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		Pos<Integer> output = new Pos<Integer>(0, false);
		return output;
	}

	@Override
	public Elem<?> retrieve(Pos<?> pos) {

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		int index = (int) pos.getPointer();

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		// checking if index is out of bounds
		if (index < 0 || index >= count || !pos.isvalid()) {
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}

		/**
		 * unchecked cast is safe -> knowing that only Elements of type T exists
		 * in this array
		 */
		return (Elem<?>) data[index];
	}

	@Override
	public void showall() {
		for (int i = 0; i < count; i++) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
	        
			Elem<?> elem = (Elem<?>) retrieve(new Pos<Integer>(i, true));
			System.out.println(i + "\t- " + elem.getKey().toString());
		}
	}

	@Override
	public int size() {

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		return count;
	}

	@Override
	public Set unify(Set s, Set t) {

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		Set unified = new ArrayList<T>();

		for (int i = 0; i < s.size(); i++) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
	        
			unified.add(s.retrieve(new Pos<Integer>(i, true)));
		}

		for (int i = 0; i < t.size(); i++) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
	        
			unified.add(t.retrieve(new Pos<Integer>(i, true)));
		}

		return unified;
	}

	private boolean contains(Elem<?> elem) {

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        
		return !(find(elem.getKey()).isvalid());
	}
}
