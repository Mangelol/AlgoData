package tree;
import java.util.Random;

public class BenchTree {

	private static void binary(int[] array, int[] indx) {
		for (int i = 0; i < indx.length; i++) {
			binary_search(array, indx[i]);
		}
	}
	
	public static int[] arrayToTree(int N) {
		Random rnd = new Random();
		// Step 1
		
		int[] array = new int[N];

		// Step 2
		for(int i=0; i < N; i++)
		   array[i] = i;

		// Step 3
		for(int i=0; i < N; i++) {
		   int randIndex = rnd.nextInt(N);
		   int tmp = array[i];
		   array[i] = array[randIndex];
		   array[randIndex] = tmp;
		}
		
		return array;
	}

	private static void lookup(BinaryTree tree, int[] indx) {
		for (int i = 0; i < indx.length; i++) {
			tree.lookup(indx[i]);
		}
	}

	private static int[] keys(int loop, int n) {
		Random rnd = new Random();
		int[] indx = new int[loop];
		for (int i = 0; i < loop; i++) {
			indx[i] = rnd.nextInt(n * 5);
		}
		return indx;
	}

	private static int[] sorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = rnd.nextInt(10);

		for (int i = 0; i < n; i++) {
			array[i] = nxt;
			nxt += rnd.nextInt(10) + 1;
		}
		return array;
	}

	public static BinaryTree tree(int n) {
		BinaryTree tree = new BinaryTree();
		tree.add(n/2, 5);
//		Random rnd = new Random();
//		int nxt = rnd.nextInt(n);
		int[] arrayToTree = arrayToTree(n);
		
		for (int i = 0; i < n; i++) {
			tree.add(arrayToTree[i], i);
//			nxt += rnd.nextInt(n) + 1;
		}
		return tree;
	}



	public static void main(String[] arg) {

		int[] sizes = { 100,200, 400, 800, 1600, 3200 };

		System.out.printf("# searching through an array of length n, time in ns\n");
		System.out.printf("#%7s%8s%8s\n", "n", "Array", "Tree");
		for (int n : sizes) {
			int loop = 10000;
			int k = 10000;

			int[] array = sorted(n);
			int[] indx = keys(loop, n);
			BinaryTree tree = tree(n);

			System.out.printf("%8d", n);

			double min = Double.POSITIVE_INFINITY;
			
			double sum = 0;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				binary(array, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			//	sum += t;
			}

			System.out.printf("%8.0f", min);

			min = Double.POSITIVE_INFINITY;
			double sum2 = 0;

			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				lookup(tree, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
				//sum2 += t;
			}
			

			System.out.printf("%8.0f\n", min );
		}
	}

	public static boolean binary_search(int[] array, int key) {

		int first = 0;
		int last = array.length - 1;
		while (true) {
			// jump to the middle
			int index = (first + last) / 2;
			if (array[index] == key) {
//			System.out.println(System.nanoTime() - t0 + "ns");
				return true;
			}
			if (array[index] < key && index < last) {
				// The index position holds something that is less than
				// what we're looking for, what is the first possible page?
				first = index + 1;
				continue;
			}
			if (array[index] > key && index > first) {
				// The index position holds something that is larger than
				// what we're looking for, what is the last possible page?
				last = index - 1;
				continue;
			}
			// item does not exist in target array.
			break;
		}
		return false;
	}

}