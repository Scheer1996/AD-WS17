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
    private Counter counter;

    public ArrayList() {
        this(new Counter());
    }

    public ArrayList(Counter counter) {
		
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        count = 0;
		
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
        data = new Object[START_SIZE];
        this.counter = counter;
    }
    
	@Override
	public Pos<?> add(Elem<?> elem) {
		// new array
		if (contains(elem)) {
			if (count == data.length) {
				// create new array
				Object[] tmp = new Object[(int) data.length * GROWTH_FACTOR];

				// copy all existing elements to new array
				System.arraycopy(data, 0, tmp, 0, data.length);

				data = tmp;
			}

			// add new element to data
			data[count] = elem;

			// increase count
			count++;
			return new Pos<Integer>(count, true);
		} else
			return find(elem.getKey());
	}

	@Override
	public void deletePos(Pos<?> pos) {
		// checking if index is out of bounds
		int index = (int) pos.getPointer();
		if (index < 0 || index >= count || !pos.isvalid()) {
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}

		// decrease count
		count--;

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
				data[i] = data[i + 1];
			}
		}
	}

	@Override
	public void deleteKey(Key key) {
		Pos<?> pos = find(key);
		deletePos(pos);
	}

	@Override
	public Pos<?> find(Key key) {
		for (int i = 0; i < count; i++) {
			// check if elem key is equals to key
			if (((Elem<?>) data[i]).getKey().equals(key)) {
				Pos<Integer> output = new Pos<Integer>(i, true);
				return output;
				// need to return position
			}
		}
		Pos<Integer> output = new Pos<Integer>(0, false);
		return output;
	}

	@Override
	public Elem<?> retrieve(Pos<?> pos) {
		int index = (int) pos.getPointer();
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
			Elem<?> elem = (Elem<?>) retrieve(new Pos<Integer>(i, true));
			System.out.println(i + "\t- " + elem.getKey().toString());
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Set unify(Set s, Set t) {
		Set unified = new ArrayList<T>();

		for (int i = 0; i < s.size(); i++) {
			unified.add(s.retrieve(new Pos<Integer>(i, true)));
		}

		for (int i = 0; i < t.size(); i++) {
			unified.add(t.retrieve(new Pos<Integer>(i, true)));
		}

		return unified;
	}

	private boolean contains(Elem<?> elem) {
		return !(find(elem.getKey()).isvalid());
	}
}
