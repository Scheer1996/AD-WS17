package src.aufgabenblatt_01;

import java.util.Arrays;

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
 *         09.10.2017
 *
 */
public class DoubleLinkedSet<T> implements Set {
	// refers to the actual free position
	private int actualPosition;

	/*
	 * start size of the array
	 */
	private final int START_SIZE = 3;

	/*
	 * extension factor
	 */
	private final int EXTENSION_FACTOR = 2;

	/*
	 * array for storing the data
	 */
	private ElemPrevNext[] data;

	/*
	 * Number of elements stored
	 */
	protected int setSize = 0;

	private int arrayLength;

	/**
	 * constructor
	 */
	public DoubleLinkedSet() {
		setSize = 0;
		actualPosition = 1;
		data = new ElemPrevNext[START_SIZE];
		arrayLength = data.length;

	}

	@Override
	public Pos<?> add(Elem<?> e) {
		if (contains(e.getKey())) {
			return find(e.getKey());
		} else {
			ElemPrevNext<?> eNext = new ElemPrevNext(e.getElement(), e.getKey());
			
			if (actualPosition < data.length - 1) {
				data[actualPosition] = (ElemPrevNext<?>) eNext;
				data[actualPosition].setPreviousIndex(actualPosition - 1);
				data[actualPosition].setNextIndex(++actualPosition);
				setSize++;

			} else {
				Elem<?>[] neuesArray;
				neuesArray = Arrays.copyOf(data, data.length * EXTENSION_FACTOR);
				data = (ElemPrevNext[]) neuesArray;
				data[actualPosition] = (ElemPrevNext<?>) eNext;
				data[actualPosition].setPreviousIndex(actualPosition - 1);
				data[actualPosition].setNextIndex(++actualPosition);
				setSize++;

			}
			return new Pos<Integer>(actualPosition - 1, true);
		}
	}

	private boolean contains(Key key) {
		return find(key).isvalid();
	}

	@Override
	public void deletePos(Pos<?> pos) {
		int index = (int)pos.getPointer();
		assert data[index] != null : "Vorbedingung verletzt data[index] != null";
		assert (index >= 1) : "Vorbedingung verletzt index >= 1";

		if (data[index - 1] != null) {
			data[index - 1].setNextIndex(index);
		}

		if (data[index + 1] != null) {
			data[index + 1].setPreviousIndex(index - 1);
		}
		data[index].setElement(null);
		data[index] = null;
		setSize--;

	}

	@Override
	public void deleteKey(Key key) {
		deletePos(find(key));
	}

	@Override
	public Pos find(Key key) {
		int index = actualPosition - 1;
		data[0] = new ElemPrevNext<String>("stopper", key);
		data[data.length - 1] = new ElemPrevNext<String>("stopper", new Key(key.getKey() + 1));
		while (data[index] == null || !(data[index].getKey().equals(key))) {
			index--;
		}
		boolean validity = index != 0;
		return new Pos<Integer>(index, validity);
	}

	@Override
	public Elem<?> retrieve(Pos pos) {
		int index = (int)pos.getPointer();
		Elem<?> retrieve = null;
		if (isValidIndex(index)) {
			retrieve = data[index];
		}
		return retrieve;
	}

	@Override
	public void showall() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return setSize;
	}

	@Override
	public Set unify(Set s, Set t) {
		Set unified = new DoubleLinkedSet<T>();

		for (int i = 0; i < s.size(); i++) {
			unified.add(s.retrieve(new Pos<Integer>(i, true)));
		}

		for (int i = 0; i < t.size(); i++) {
			unified.add(t.retrieve(new Pos<Integer>(i, true)));
		}

		return unified;
	}

	/**
	 * 
	 * @return actualPosition
	 */
	private int getActualPos() {
		return actualPosition;
	}

	/**
	 * checks if the index is a valid position
	 * 
	 * @return true when the index is a valid position, otherwise false.
	 */
	private boolean isValidIndex(int index) {
		return index >= 0 && index < actualPosition;
	}

}
