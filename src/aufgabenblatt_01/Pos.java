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
}
