package aufgabenblatt_01;

public class Pos<T> {

	private T pointer;
	private boolean isValid;
	
	public Pos(T pointer, boolean validity) {
		this.pointer = pointer;
		this.isValid = validity;
	}
	
	public T getPointer() {
		return pointer;
	}
	
	public boolean isvalid() {
		return isValid;
	}
	
	public boolean equals(Object obj) {
        if (!(obj instanceof Pos)) 
        {
            return false;
        }

        Pos otherPos = (Pos) obj;
        
        if (!otherPos.isvalid() && !this.isvalid()) {
        	return true;
        }
        
        if (otherPos.isvalid() != this.isvalid()) {
        	return false;
        }
        
        if (otherPos.getPointer().getClass() != this.getPointer().getClass()) {
        	return false;
        }
        
        
        return otherPos.getPointer() == this.getPointer();
	}
}
