package quickSort;

public class QuickSortBench {

	public static void main(String[] args) {

		int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
		int[] array;
		int runs = 5000;
		double min, max, sum;

		System.out.println("# Quicksort with different data structures");
		System.out.printf("#%7s\t%9s\t%9s\t\n", "n", "Linked list", "Array");

		for (int n : sizes) {
			System.out.printf("%8d\t", n);

			min = Double.POSITIVE_INFINITY;
			max = 0;
			sum = 0;

			for (int i = 0; i < runs; i++) {
				LinkedList listToSort = filledList(n);
				
				long t0 = System.nanoTime();
				sortLinked(listToSort.head, listToSort.last);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
				sum += t;
			}
			System.out.printf("%9.0f\t", min);

			min = Double.POSITIVE_INFINITY;
			max = 0;
			sum = 0;
			for (int i = 0; i < runs; i++) {
				int[] arrayToSort = filledArray(n);
				long t0 = System.nanoTime();
				sort(arrayToSort, 0, n - 1);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
				else if (t > max)
					max = t;
				sum += t;
			}
			System.out.printf("%9.0f\t\n", min);
		}

	}

	public static LinkedList filledList(int numberOfCells) {
		Random rnd = new Random();
		LinkedList listToFill = new LinkedList();
		for (int i = 0; i <= numberOfCells; i++) {
			listToFill.add(rnd.nextInt(numberOfCells));
		}

		return listToFill;
	}

	public static int[] filledArray(int numberOfElements) {
		Random rnd = new Random();
		int[] arrayToFill = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++)
			arrayToFill[i] = rnd.nextInt(numberOfElements);
		return arrayToFill;
	}


	public static void sort(int[] array, int first, int last) {
		if (first >= last)
			return;

		int middle = partition(array, first, last);

		sort(array, first, middle - 1);
		sort(array, middle + 1, last);
	}

	public static int partition(int[] array, int first, int last) {
		int i = last + 1;
		int pivot = array[first];

		for (int j = last; j >= 0; j--) {
			if (array[j] > pivot) {
				i--;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		i--;
		int temp = array[i];
		array[i] = array[first];
		array[first] = temp;

		return i;

	}

	public static void sortLinked(LinkedList.Node first, LinkedList.Node last) {
		if (first == null || last == null || first == last)
			return;

		LinkedList.Node middle = partitionLinked(first, last);

		sortLinked(first, middle);
		sortLinked(middle.next, last);
	}

	public static LinkedList.Node partitionLinked(LinkedList.Node first, LinkedList.Node last) {
		if (first == null || last == null || first == last)
			return null;

		LinkedList.Node prev = first;
		LinkedList.Node current = first;
		int pivot = last.value;

		while (first != last) {
			if (first.value < pivot) {
				prev = current;
				int temp = current.value;
				current.value = first.value;
				first.value = temp;
				current = current.next;
			}
			first = first.next;
		}
		int temp = current.value;
		current.value = pivot;
		last.value = temp;

		return prev;
	}

}
