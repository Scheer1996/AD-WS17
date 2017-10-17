package aufgabenblatt_01;

public class Application {

	private static double[] listSize = {10e1, 10e2, 10e3, 10e4, 10e5};
	/**
	 * 10^k testfälle k= 1-5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		performanceArrayTest10powX(1);
		performanceArrayTest10powX(2);
		performanceArrayTest10powX(3);
		performanceArrayTest10powX(4);
		performanceArrayTest10powX(5);
		
	}
	
	public static void performanceArrayTest10powX(int pow)
	{
		int testrange = (int)Math.pow(10, pow);
		
		//INIT
		ArrayList<Elem<Integer>> arrayList = newArray(testrange);
		arrayList.deleteKey(new Key(0));
		System.out.println("Erstes Element"+arrayList.counter.getCount());

		arrayList = newArray(testrange);
		arrayList.deleteKey(new Key(testrange/2));
		System.out.println("Mittleres Element"+arrayList.counter.getCount());
		
		arrayList = newArray(testrange);
		arrayList.deleteKey(new Key(testrange-1));
		System.out.println("Letztes Element"+arrayList.counter.getCount());
	}

	private static ArrayList<Elem<Integer>> newArray(int size) {
		Counter counter = new Counter();
		ArrayList<Elem<Integer>> arrayList = new ArrayList<Elem<Integer>>(counter);
		
		
		for(int h = 0; h < size; h++) {
			arrayList.add(new Elem<Integer>(1, new Key(h)));
		}
		counter.reset();
		return arrayList;
	}
	
	public static void dataArrayList() {

		for(int i = 0; i < listSize.length; i++) {
			int bestCase = Integer.MAX_VALUE;
			int worstCase = 0;
			
			for(int j = 0; j < listSize[i]; j++) {
				Counter counter = new Counter();
				ArrayList<Elem<Integer>> arrayList = new ArrayList<Elem<Integer>>(counter);
				
				for(int h = 0; h < listSize[i]; h++) {
					arrayList.add(new Elem<Integer>(1, new Key(h)));
				}
				
				counter.reset();
				arrayList.deleteKey(new Key(j));
				if(counter.getCount() < bestCase) {
					bestCase = (int) counter.getCount();
				}
				
				if(counter.getCount() > worstCase) {
					worstCase = (int) counter.getCount();
				}
				
				
			}
			System.out.println(listSize[i]+" - BEST: "+bestCase);
			System.out.println(listSize[i]+" - WORST: "+worstCase);
			
		}
		
	}

}
