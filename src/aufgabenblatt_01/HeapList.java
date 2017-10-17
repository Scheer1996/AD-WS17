package src.aufgabenblatt_01;

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

	public HeapList() {
		end = new HeapContainer(null, null);
		start = new HeapContainer(null, end);
		size = 0;
	}

	@Override
	public Pos add(Elem<?> elem) {
		if (!find(elem.getKey()).isvalid()) {

			end.setNext(null);
			// Endcontainer praepariert für das Ende der Suche

			HeapContainer temp = start;

			// Bedingung ist erfüllt, wenn der naechste Container end ist
			while (temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}

			HeapContainer newContainer = new HeapContainer(elem, temp.getNext());
			temp.setNext(newContainer);
			size++;
			return new Pos<HeapContainer>(temp, true);
		} else {
			return find(elem.getKey());
		}
	}

	@Override
	public void deletePos(Pos pos) {
		if (pos.isvalid()) {
			HeapContainer temp = (HeapContainer) pos.getPointer();
			temp.setNext(temp.getNext().getNext());
			size--;
		}
	}

	@Override
	public void deleteKey(Key key) {
		deletePos(find(key));
	}

	@Override
	public Pos find(Key key) {
		end.setNext(null);
		end.setElement(new Elem<String>("stopper", key));
		// end so vorbereitet, dass Suche definitiv erfolg hat

		HeapContainer temp = start;

		while (!temp.getNext().getElement().getKey().equals(key)) {
			temp = temp.getNext();
		}

		boolean validity = temp.getNext().getNext() != null;
		end.setNext(null);
		end.setElement(null);
		// end auf ausgangszustand zurücksetzen

		return new Pos<HeapContainer>(temp, validity);
	}

	@Override
	public Elem<?> retrieve(Pos pos) {
		// Index out of bounds check
		if (pos.isvalid()) {
			if (pos.getPointer() instanceof Integer) {
				int counter = 1;
				// Start bei 1 da immer der folgende Container getestet wird
				HeapContainer temp = start;

				while (counter < (int)pos.getPointer()) {
					temp = temp.getNext();
					counter++;
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
		end.setNext(null);
		// end vorbereitet als stopelement

		HeapContainer temp = start;
		int index = 1;

		while (temp.getNext().getNext() != null) {
			System.out.println(index + "\t " + temp.getNext().getElement().getKey().toString());
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Set unify(Set s, Set t) {
		Set unified = new HeapList<T>();

		for (int i = 0; i < s.size(); i++) {
			unified.add(s.retrieve(new Pos<Integer>(i, true)));
		}

		for (int i = 0; i < t.size(); i++) {
			unified.add(t.retrieve(new Pos<Integer>(i, true)));
		}

		return unified;
	}
}
