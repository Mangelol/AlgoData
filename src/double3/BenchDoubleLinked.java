package double3;

import java.util.Random;

public class BenchDoubleLinked {
	public static void main(String[] args) {

		int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
		int runs = 500;
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
			DoublyLinked[] ref2 = new DoublyLinked[n];
			
			DoublyLinked doublyToFill = new DoublyLinked(0, null, null);
			for (int i = 0; i < n; i++) {
				DoublyLinked fill = new DoublyLinked(rnd.nextInt(n),null,null);
				doublyToFill.add(fill);
				ref2[i] = fill;
			}
			
			LinkedList singleToFill = new LinkedList(0, null);
			LinkedList fill = new LinkedList(rnd.nextInt(n),null);
			for (int i = 0; i < n; i++) {
				fill = new LinkedList(rnd.nextInt(n),null);
				singleToFill.add(fill);
				ref[i] = fill;
			}
			int randomNumber = sequence[rnd.nextInt(k -1)];

			min = Double.POSITIVE_INFINITY;
			min2 = Double.POSITIVE_INFINITY;
			
			for (int i = 0; i < runs; i++) {
				LinkedList single = singleList(n);
				long t0 = System.nanoTime();
				single.remove(ref[randomNumber]);
				long t1 = System.nanoTime();
		
				long t2 = System.nanoTime();
				single.add(ref[randomNumber]);
				long t3 = System.nanoTime();
				double t = (t1 - t0);
				double tAdd = (t3 - t2);
				if (t < min)
					min = t;
				if (tAdd < min2)
					min2 = tAdd;
			}
			System.out.printf("%9.0f\t", min);
			System.out.printf("%9.0f\t", min2);


			min = Double.POSITIVE_INFINITY;
			min2 = Double.POSITIVE_INFINITY;
			for (int i = 0; i < runs; i++) {
				DoublyLinked doubly = doublyList(n);
				long t0 = System.nanoTime();
				doubly.remove(ref2[randomNumber]);
				long t1 = System.nanoTime();
				
				long t2 = System.nanoTime();
				doubly.add(ref2[randomNumber]);
				long t3 = System.nanoTime();
				double t = (t1 - t0);
				double tAdd = (t3 - t2);
				if (t < min)
					min = t;
				if (tAdd < min2)
					min2 = tAdd;
			}
			System.out.printf("%9.0f\t", min);
			System.out.printf("%9.0f\t\n", min2);
		}
	}
	
	public static LinkedList singleList(int numberOfCells) {
		Random rnd = new Random();
		LinkedList listToFill = new LinkedList(0, null);
		for (int i = 1; i <= numberOfCells; i++) {
			listToFill.add(new LinkedList(rnd.nextInt(numberOfCells), null));
			
		}

		return listToFill;
	}

	public static DoublyLinked doublyList(int numberOfCells) {
		Random rnd = new Random();
		DoublyLinked listToFill = new DoublyLinked(0, null, null);
		for (int i = 1; i <= numberOfCells; i++) {
			listToFill.add(new DoublyLinked(rnd.nextInt(numberOfCells),null,null));
		}

		return listToFill;
	}
}
