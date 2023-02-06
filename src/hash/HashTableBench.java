package hash;

public class HashTableBench {

	public static void main(String[] args) {
	


//		int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
		String[] stringNumbers = { "111 15", "994 99" };
		Integer[] integerNumbers = { 11115, 99499};
		Integer[] integerNumbers2 = { 11115, 99499, 12652, 46197 };
		int runs = 10000;
		double min;
//		HashTable.Node nod = new HashTable.Node(10, "hej", 10);

		System.out.println("# Binary search vs Linear search with a csv file (code as String)");
		System.out.printf("#%7s\t%9s\t%9s\t\n", "looking for", "Linear", "Binary");

		Zip file1 = new Zip("postnummer.csv");

		for (String n : stringNumbers) {
			System.out.printf("%8s" + " & " + "\t", n);

			min = Double.POSITIVE_INFINITY;

			for (int i = 0; i < runs; i++) {

				long t0 = System.nanoTime();
				file1.linearLookUp(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f" + " & " + "\t", min);

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < runs; i++) {
				long t0 = System.nanoTime();
				file1.binarySearch(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f\t" + " \\" + "\\" + "\n", min);
		}
		System.out.println(" ");

		System.out.println("# Binary search vs Linear search with a csv file (code as Integer)");
		System.out.printf("#%7s\t%9s\t%9s\t\n", "looking for", "Linear", "Binary");

		IntegerZip file2 = new IntegerZip("postnummer.csv");

		for (Integer n : integerNumbers) {
			System.out.printf("%8d" + " & " + "\t", n);

			min = Double.POSITIVE_INFINITY;

			for (int i = 0; i < runs; i++) {

				long t0 = System.nanoTime();
				file2.linearLookUp(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f" + " & " + "\t", min);

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < runs; i++) {
				long t0 = System.nanoTime();
				file2.binarySearch(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f\t" + " \\" + "\\" + "\n", min);
		}

		System.out.println(" ");

		System.out.println(
				"# Lookup with key as index");
		System.out.printf("#%7s\t%9s\t\n", "looking for", "Linear");

		IndexKeyZip file3 = new IndexKeyZip("postnummer.csv");

		for (Integer n : integerNumbers2) {
			System.out.printf("%8d" + " & " + "\t", n);

			min = Double.POSITIVE_INFINITY;

			for (int i = 0; i < runs; i++) {

				long t0 = System.nanoTime();
				file3.linearLookUp(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f\t" + " \\" + "\\" + "\n", min);

		}
		System.out.println(" ");
		
		System.out.println("LookUp with hashing vs without");
		System.out.printf("#%7s\t%9s\t%9s\t\n", "Looking for", "With", "Without");

		HashTable hash = new HashTable("postnummer.csv");

		for (Integer n : integerNumbers2) {
			System.out.printf("%8d" + " & " + "\t", n);

			min = Double.POSITIVE_INFINITY;

			for (int i = 0; i < runs; i++) {

				long t0 = System.nanoTime();
				hash.linearLookUp(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f" + " & " + "\t", min);

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < runs; i++) {
				long t0 = System.nanoTime();
				file3.linearLookUp(n);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%9.0f\t" + " \\" + "\\" + "\n", min);
		}

	}

//	public static LinkedList filledList(int numberOfCells) {
//		Random rnd = new Random();
//		LinkedList listToFill = new LinkedList();
//		for (int i = 0; i <= numberOfCells; i++) {
//			listToFill.add(arrayWithRandomNumbers[i]);
//		}
//
//		return listToFill;
//	}
//
//	public static int[] filledArray(int numberOfElements) {
//		Random rnd = new Random();
//		int[] arrayToFill = new int[numberOfElements];
//		for (int i = 0; i < numberOfElements; i++)
//			arrayToFill[i] = arrayWithRandomNumbers[i];
//		return arrayToFill;
//	}
}
