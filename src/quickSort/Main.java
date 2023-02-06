package quickSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 23, 11, 2, 74, 35, 50, 2};
		int n = array.length;
		
		System.out.println("before sorting ");
		Main s1 = new Main();
		s1.print(array, n);
		s1.sort(array, 0, n - 1);
		System.out.println();
		System.out.println("After sorting ");
		s1.print(array, n);
		System.out.println();
		
	}
	
	public static void sort(int[] array, int first, int last) {
		if(first < last) {
			int part = partition(array, first, last);
			sort(array, first, part - 1);
			sort(array, part + 1, last);
		}
	}
	
	public static int partition(int[] array, int first, int last) {
		int pivot = array[last];
		int i = first - 1;
		
		for(int j = first; j <= last - 1; j++) {
			if(array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		int temp = array[i + 1];
		array[i + 1] = array[last];
		array[last] = temp;
		return(i + 1);
	}
	
	void print(int array[], int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}

} 
