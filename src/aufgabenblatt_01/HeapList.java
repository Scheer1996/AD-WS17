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
 * 09.10.2017
 *
 */
public class HeapList<T> implements Set {
	private HeapContainer start;
	private HeapContainer end;
	private int size;
	
	public HeapList () {
		end = new HeapContainer(null, null);
		start = new HeapContainer(null, end);
		size = 0;
	}

	@Override
	public int add(Elem<?> elem) {
		end.setNext(null);
		//Endcontainer praepariert für das Ende der Suche
		
		HeapContainer temp = start;
		int index = 1;
		
		// Bedingung ist erfüllt, wenn der naechste Container end ist
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
			index++;
		}
		
		HeapContainer newContainer = new HeapContainer(elem, temp.getNext());
		temp.setNext(newContainer);
		size++;
		return index;
	}

	@Override
	public void deletePos(int index) {
		end.setNext(end);
		//end so vorbereitet, dass beliebiger index eingegeben werden kann, auch wenn die Liste kleiner ist, da Kreisverweis bei end
		
		int counter = 1;
		// counter startet bei 1, damit temp beim Container vor dem zu loeschenden endet
		HeapContainer temp = start;
		
		while (counter < index) {
			counter++;
			temp = temp.getNext();
		}
		// temp ist nun der Container vor dem zu loeschenden Container
		temp.setNext(temp.getNext().getNext());
		size--;
		end.setNext(null);
		// Entfernen des Kreisverweises bei end
	}

	@Override
	public void deleteKey(Key key) {
		end.setNext(end);
		end.setElement(new Elem<String>("stopper", key));
		// end so vorbereitet, dass Suche definitiv erfolg hat und schlussendlich dann nichts veraendert
		
		HeapContainer temp = start;
		
		// Bedingung ist erfüllt, wenn der Key des folgenden Containers der zu loeschende ist
		while (!temp.getNext().getElement().getKey().equals(key)) {
			temp = temp.getNext();
		}
		
		temp.setNext(temp.getNext().getNext());
		size--;
		
		end.setNext(null);
		end.setElement(null);
		// end auf ausgangszustand zurücksetzen
	}

	@Override
	public int find(Key key) {
		end.setNext(null);
		end.setElement(new Elem<String>("stopper", key));
		// end so vorbereitet, dass Suche definitiv erfolg hat
		
		HeapContainer temp = start;
		int counter = 1;
		// Start bei 1, da immer der naechste Container geprueft wird und nicht der Aktuelle
		
		while (!temp.getNext().getElement().getKey().equals(key)) {
			temp = temp.getNext();
			counter++;
		}
		
		// Prüfung, ob der gefundene Index der des end-Containers ist, d.h. kein Ergebnis gefunden wurde
		if (temp.getNext().getNext() == null) {
			counter = 0;
		}
		
		end.setNext(null);
		end.setElement(null);
		// end auf ausgangszustand zurücksetzen
		
		return counter;
	}

	@Override
	public Elem<?> retrieve(int index) {
		// Index out of bounds check
		if (index > size) {
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}
		
		int counter = 1;
		// Start bei 1 da immer der folgende Container getestet wird
		HeapContainer temp = start;
		
		while (counter < index) {
			temp = temp.getNext();
		}
		
		return temp.getNext().getElement();
	}

	@Override
	public void showall() {
		end.setNext(null);
		// end vorberietet als stopelement
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getActualPos() {
		// TODO Auto-generated method stub
		return 0;
	}

}
