package aufgabe_01;

import aufgabe_01.Elem;
import aufgabe_01.HeapContainer;

/**
 * Aufgabe 2.c)
 * @author Subotin
 *
 */
public class HeapContainer {
	private Elem element;
	private HeapContainer next;
	
	public HeapContainer (Elem element, HeapContainer container) {
		this.element = element;
		this.next = container;
	}

	public Elem getElement() {
		return element;
	}

	public void setElement(Elem element) {
		this.element = element;
	}

	public HeapContainer getNext() {
		return next;
	}

	public void setNext(HeapContainer next) {
		this.next = next;
	}
}
