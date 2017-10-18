package aufgabenblatt_01;

public class Application {

	private static double[] listSize = {10e1, 10e2, 10e3, 10e4, 10e5};
	/**
	 * 10^k testfälle k= 1-5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ArrayList");
		performanceCompareArrayList();
		System.out.println("DoubleLinkedSet");
		performanceCompareDoubleLinkedSet();
		
		
		
	}

	private static void performanceCompareArrayList() {
		System.out.println("DeleteKey:");
		System.out.println("10e1");
		performanceArrayTestDeleteKey10powX(1);
		System.out.println("10e2");
		performanceArrayTestDeleteKey10powX(2);
		System.out.println("10e3");
		performanceArrayTestDeleteKey10powX(3);
		System.out.println("10e4");
		performanceArrayTestDeleteKey10powX(4);
		System.out.println("10e5");
		performanceArrayTestDeleteKey10powX(5);
		
		System.out.println("DeletePos:");
		System.out.println("10e1");
		performanceArrayTestDeletePos10powX(1);
		System.out.println("10e2");
		performanceArrayTestDeletePos10powX(2);
		System.out.println("10e3");
		performanceArrayTestDeletePos10powX(3);
		System.out.println("10e4");
		performanceArrayTestDeletePos10powX(4);
		System.out.println("10e5");
		performanceArrayTestDeletePos10powX(5);
	}
	
	public static void performanceArrayTestDeleteKey10powX(int pow)
	{
		int testrange = (int)Math.pow(10, pow);
		
		ArrayList<Elem<Integer>> arrayList = newArray(testrange);
		arrayList.deleteKey(new Key(0));
		System.out.println("  Erstes Element: "+arrayList.counter.getCount());

		arrayList = newArray(testrange);
		arrayList.deleteKey(new Key(testrange/2));
		System.out.println("  Mittleres Element: "+arrayList.counter.getCount());
		
		arrayList = newArray(testrange);
		arrayList.deleteKey(new Key(testrange-1));
		System.out.println("  Letztes Element: "+arrayList.counter.getCount());
	}

	public static void performanceArrayTestDeletePos10powX(int pow)
	{
		int testrange = (int)Math.pow(10, pow);

		ArrayList<Elem<Integer>> arrayList = newArray(testrange);
		arrayList.deletePos(new Pos<Integer>(0, true));
		System.out.println("  Erstes Element: "+arrayList.counter.getCount());

		arrayList = newArray(testrange);
		arrayList.deletePos(new Pos<Integer>(testrange/2, true));
		System.out.println("  Mittleres Element: "+arrayList.counter.getCount());
		
		arrayList = newArray(testrange);
		arrayList.deletePos(new Pos<Integer>(testrange-1, true));
		System.out.println("  Letztes Element: "+arrayList.counter.getCount());
	}
	
	private static void performanceCompareDoubleLinkedSet() {
		System.out.println("DeleteKey:");
		System.out.println("10e1");
		performanceDLTestDeleteKey10powX(1);
		System.out.println("10e2");
		performanceDLTestDeleteKey10powX(2);
		System.out.println("10e3");
		performanceDLTestDeleteKey10powX(3);
		System.out.println("10e4");
		performanceDLTestDeleteKey10powX(4);
		System.out.println("10e5");
		performanceDLTestDeleteKey10powX(5);
		
		System.out.println("DeletePos:");
		System.out.println("10e1");
		performanceDLTestDeletePos10powX(1);
		System.out.println("10e2");
		performanceDLTestDeletePos10powX(2);
		System.out.println("10e3");
		performanceDLTestDeletePos10powX(3);
		System.out.println("10e4");
		performanceDLTestDeletePos10powX(4);
		System.out.println("10e5");
		performanceDLTestDeletePos10powX(5);
	}
	
	public static void performanceDLTestDeleteKey10powX(int pow)
	{
		int testrange = (int)Math.pow(10, pow);
		
		DoubleLinkedSet<Elem<Integer>> dlSet = newDoubleLinkedSet(testrange);
		dlSet.deleteKey(new Key(0));
		System.out.println("  Erstes Element: "+dlSet.counter.getCount());

		dlSet = newDoubleLinkedSet(testrange);
		dlSet.deleteKey(new Key(testrange/2));
		System.out.println("  Mittleres Element: "+dlSet.counter.getCount());
		
		dlSet = newDoubleLinkedSet(testrange);
		dlSet.deleteKey(new Key(testrange-1));
		System.out.println("  Letztes Element: "+dlSet.counter.getCount());
	}

	public static void performanceDLTestDeletePos10powX(int pow)
	{
		int testrange = (int)Math.pow(10, pow);

		DoubleLinkedSet<Elem<Integer>> dlSet = newDoubleLinkedSet(testrange);
		dlSet.deletePos(new Pos<Integer>(1, true));
		System.out.println("  Erstes Element: "+dlSet.counter.getCount());

		dlSet = newDoubleLinkedSet(testrange);
		dlSet.deletePos(new Pos<Integer>(testrange/2, true));
		System.out.println("  Mittleres Element: "+dlSet.counter.getCount());
		
		dlSet = newDoubleLinkedSet(testrange);
		dlSet.deletePos(new Pos<Integer>(testrange, true));
		System.out.println("  Letztes Element: "+dlSet.counter.getCount());
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
	
	private static DoubleLinkedSet<Elem<Integer>> newDoubleLinkedSet(int size) {
		Counter counter = new Counter();
		DoubleLinkedSet<Elem<Integer>> dlSet = new DoubleLinkedSet<Elem<Integer>>(counter);
		
		
		for(int h = 0; h < size; h++) {
			dlSet.add(new Elem<Integer>(1, new Key(h)));
		}
		counter.reset();
		return dlSet;
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
