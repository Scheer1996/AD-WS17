package aufgabenblatt_01;
/**
 * Represenation of an Unique Key for Elem 
 * 
 * <br>
 * Aufgabenblatt 1 - Aufgabe 1
 * 
 * @author Philip Scheer - philip.scheer@haw-hamburg.de
 * @author Dennis Sentler - dennis.sentler@haw-hamburg.de
 * @author Paul Mathia - paul.mathia@haw-hamburg.de
 * @author Stefan Subotin - stefan.subotin@haw-hamburg.de
 * 
 * 09.10.2017
 *
 */
public class Key {
	
	private int key;
	
	public Key(int key)
	{
		this.setKey(key); 
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean equals(Object obj) 
	{
        if (!(obj instanceof Key)) 
        {
            return false;
        }

        Key otherKey = (Key) obj;
        return (key == otherKey.getKey());
	}
	
	public String toString() 
	{
		return "KEY: "+key;
	}

}
