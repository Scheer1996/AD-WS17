package aufgabenblatt_01.test;


import aufgabenblatt_01.ArrayList;
import aufgabenblatt_01.Elem;
import aufgabenblatt_01.Key;

public class TestArrayList {

    public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
    	testAdd(set);
		set.showall();
		set.deletePos(10);
		
		Key key = new Key(115);
		int index = set.find(key);
		System.out.println(index);
		set.deletePos(index);
		set.showall();
		
    }
	
    
    
    
    
	public static void testAdd(ArrayList<Integer> set) {
		for(int i = 0; i < 50; i++) {
			Key k = new Key(i+100);
			Elem<Integer> e = new Elem<Integer>(i, k);
			set.add(e);
		}
		
	}
}
