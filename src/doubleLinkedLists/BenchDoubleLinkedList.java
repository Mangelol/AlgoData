package doubleLinkedLists;

import java.util.Random;

public class BenchDoubleLinkedList {
	public static void main(String[] args) {

		int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
		int runs = 10000;
		int k = 100;
		double min, min2;
		int[] sequence = new int[k];
		Random rnd = new Random();
	


		System.out.println("# Linked vs doubly linked with reference");
		System.out.printf("#%7s\t%9s\t%9s\t%9s\t%9s\n", "n", "Remove linked", "Add linked", "Remove doubly",
				"Add doubly");

		for (int n : sizes) {
			System.out.printf("%8d\t", n);
			
			for (int i = 0; i < k; i++) {
				sequence[i] = rnd.nextInt(n);
				}
			
			LinkedList[] ref = new LinkedList[n];
			DoubleLinkedList[] ref2 = new DoubleLinkedList[n];
			
			DoubleLinkedList doubleFill = new DoubleLinkedList(0, null, null);
			for (int i = 0; i < n; i++) {
				DoubleLinkedList fill = new DoubleLinkedList(rnd.nextInt(n),null,null);
				doubleFill.add(fill);
				ref2[i] = fill;
			}
			
			LinkedList singleFill = new LinkedList(0, null);
			for (int i = 0; i < n; i++) {
				LinkedList fill = new LinkedList(rnd.nextInt(n),null);
				singleFill.add(fill);
				ref[i] = fill;
			}

			min = Double.POSITIVE_INFINITY;
			min2 = Double.POSITIVE_INFINITY;
			int randomNumber = sequence[rnd.nextInt(k -1)];
			for (int i = 0; i < runs; i++) {
				LinkedList single = singleList(n);
				long t0 = System.nanoTime();
				single.delete(ref[rnd.nextInt(n)]);
				long t1 = System.nanoTime();
				
				long t2 = System.nanoTime();
				single.add(ref[rnd.nextInt(n)]);
				long t3 = System.nanoTime();
				long t = (t1 - t0);
				long tAdd = (t3 - t2);
				if (t < min)
					min = t;
				if (tAdd < min2)
					min2 = t;
			}
			System.out.printf("%9.0f\t", min);
			System.out.printf("%9.0f\t", min2);

			min = Double.POSITIVE_INFINITY;
			min2 = Double.POSITIVE_INFINITY;
			for (int i = 0; i < runs; i++) {
				DoubleLinkedList doubly = doubleList(n);
				long t0 = System.nanoTime();
				doubly.delete(ref2[rnd.nextInt(n)]);
				long t1 = System.nanoTime();
				
				long t2 = System.nanoTime();
				doubly.add(ref2[rnd.nextInt(n)]);
				long t3 = System.nanoTime();
				long t = (t1 - t0);
				long tAdd = (t3 - t2);
				if (t < min)
					min = t;
				if (tAdd < min2)
					min2 = t;
			}
			System.out.printf("%9.0f\t", min);
			System.out.printf("%9.0f\t\n", min2);
		}
	}
	
	public static LinkedList singleList(int noOfCells) {
		Random rnd = new Random();
		LinkedList listFill = new LinkedList(0, null);
		for (int i = 1; i <= noOfCells; i++) {
			listFill.add(new LinkedList(rnd.nextInt(noOfCells), null));
		}

		return listFill;
	}

	public static DoubleLinkedList doubleList(int noOfCells) {
		Random rnd = new Random();
		DoubleLinkedList listFill = new DoubleLinkedList(0, null, null);
		for (int i = 1; i <= noOfCells; i++) {
			listFill.add(new DoubleLinkedList(rnd.nextInt(noOfCells),null,null));
		}

		return listFill;
	}
}
