package aufgabe1;

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
