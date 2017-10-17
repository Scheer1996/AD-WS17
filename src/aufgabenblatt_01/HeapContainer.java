package src.aufgabenblatt_01;

import src.aufgabenblatt_01.Elem;
import src.aufgabenblatt_01.HeapContainer;

/**
 * Heap Container
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 2c
 * 
 * @author Philip Scheer - philip.scheer@haw-hamburg.de
 * @author Dennis Sentler - dennis.sentler@haw-hamburg.de
 * @author Paul Mathia - paul.mathia@haw-hamburg.de
 * @author Stefan Subotin - stefan.subotin@haw-hamburg.de
 * 
 * 09.10.2017
 *
 */
public class HeapContainer {
	private Elem<?> element;
	private HeapContainer next;
	
	public HeapContainer (Elem<?> element, HeapContainer container) {
		this.element = element;
		this.next = container;
	}

	public Elem<?> getElement() {
		return element;
	}

	public void setElement(Elem<?> element) {
		this.element = element;
	}

	public HeapContainer getNext() {
		return next;
	}

	public void setNext(HeapContainer next) {
		this.next = next;
	}
}
