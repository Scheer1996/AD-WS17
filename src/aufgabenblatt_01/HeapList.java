package aufgabenblatt_01;

/**
 * Heap List
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 2c
 * 
 * @author Philip Scheer - philip.scheer@haw-hamburg.de
 * @author Dennis Sentler - dennis.sentler@haw-hamburg.de
 * @author Paul Mathia - paul.mathia@haw-hamburg.de
 * @author Stefan Subotin - stefan.subotin@haw-hamburg.de
 * 
 *         09.10.2017
 *
 */
public class HeapList<T> implements Set {
	public HeapContainer start;
	private HeapContainer end;
	private int size;
	
    /**
     * the counter to collect data about operations
     */
    public Counter counter;

    
	public HeapList(Counter counter) {
		this.counter = counter;
		end = new HeapContainer(null, null);
		start = new HeapContainer(null, end);
		size = 0;
	}
    
	public HeapList() {
		end = new HeapContainer(null, null);
		start = new HeapContainer(null, end);
		size = 0;
		counter = new Counter();
	}

	@Override
	public Pos add(Elem<?> elem) {
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		if (!find(elem.getKey()).isvalid()) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			end.setNext(null);
			// Endcontainer praepariert für das Ende der Suche

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			HeapContainer temp = start;

			// Bedingung ist erfüllt, wenn der naechste Container end ist
			while (temp.getNext().getNext() != null) {
		        // PERFORMANCE COUNTER
		        counter.increment();
		        // PERFORMANCE COUNTER
				temp = temp.getNext();
			}

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			HeapContainer newContainer = new HeapContainer(elem, temp.getNext());
			
	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			temp.setNext(newContainer);

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			size++;
			return new Pos<HeapContainer>(temp, true);
		} else {
			return find(elem.getKey());
		}
	}

	@Override
	public void deletePos(Pos pos) {
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		if (pos.isvalid()) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			HeapContainer temp = (HeapContainer) pos.getPointer();

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			temp.setNext(temp.getNext().getNext());

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			size--;
		}
	}

	@Override
	public void deleteKey(Key key) {
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		deletePos(find(key));
	}

	@Override
	public Pos find(Key key) {
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		end.setNext(null);

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		end.setElement(new Elem<String>("stopper", key));
		// end so vorbereitet, dass Suche definitiv erfolg hat

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		HeapContainer temp = start;

		while (!temp.getNext().getElement().getKey().equals(key)) {
	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			temp = temp.getNext();
		}

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		boolean validity = temp.getNext().getNext() != null;

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		end.setNext(null);

        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		end.setElement(null);
		// end auf ausgangszustand zurücksetzen

		return new Pos<HeapContainer>(temp, validity);
	}

	@Override
	public Elem<?> retrieve(Pos pos) {
		
        // PERFORMANCE COUNTER
        counter.increment();
        // PERFORMANCE COUNTER
		// Index out of bounds check
		if (pos.isvalid()) {

	        // PERFORMANCE COUNTER
	        counter.increment();
	        // PERFORMANCE COUNTER
			if (pos.getPointer() instanceof Integer) {
				
				int counter_heap = 1;
				// Start bei 1 da immer der folgende Container getestet wird
				HeapContainer temp = start;

		        // PERFORMANCE COUNTER
				counter.increment();
		        // PERFORMANCE COUNTER
				while (counter_heap < (int)pos.getPointer()) {
			        // PERFORMANCE COUNTER
					counter.increment();
			        // PERFORMANCE COUNTER
					temp = temp.getNext();
					
			        // PERFORMANCE COUNTER
					counter.increment();
			        // PERFORMANCE COUNTER
					counter_heap++;
				}

				return temp.getNext().getElement();
			}
			else {
				return ((HeapContainer)pos.getPointer()).getNext().getElement();
			}
			
		}
		
		return null;
	}

	@Override
	public void showall() {
        // PERFORMANCE COUNTER
		counter.increment();
        // PERFORMANCE COUNTER
		end.setNext(null);
		// end vorbereitet als stopelement

        // PERFORMANCE COUNTER
		counter.increment();
        // PERFORMANCE COUNTER
		HeapContainer temp = start;
		
        // PERFORMANCE COUNTER
		counter.increment();
        // PERFORMANCE COUNTER
		int index = 1;

		while (temp.getNext().getNext() != null) {
	        // PERFORMANCE COUNTER
			counter.increment();
	        // PERFORMANCE COUNTER
			System.out.println(index + "\t " + temp.getNext().getElement().getKey().toString());
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Set unify(Set s, Set t) {
        // PERFORMANCE COUNTER
		counter.increment();
        // PERFORMANCE COUNTER
		Set unified = new HeapList<T>();

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
}
