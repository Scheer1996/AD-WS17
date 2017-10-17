package aufgabenblatt_01.archiv.philipScheer;


public class Key {
	
	public int key;
	
	
	public Key(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
	public boolean equals(Object obj) {
        if (!(obj instanceof Key)) {
            return false;
        }

        Key otherKey = (Key) obj;
        return (key == otherKey.getKey());
	}
	
	public String toString() {
		return "KEY: "+key;
	}
}
