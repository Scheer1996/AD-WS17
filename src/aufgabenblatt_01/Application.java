package aufgabenblatt_01;

public class Application {

	
	/**
	 * 10^k testfälle k= 1-5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Counter counter = new Counter();
		ArrayList<Elem<Integer>> arrayList = new ArrayList<Elem<Integer>>(counter);
		
		for(int i = 0; i < 100; i++) {
			arrayList.add(new Elem<Integer>(30, new Key(i)));
		}
		
		System.out.println("Count: "+counter.getCount());
	}

}
