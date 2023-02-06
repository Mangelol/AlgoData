package sorting;
import java.util.*;


public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		int runs = 10000;
		for(int k = 0; k < runs; k++) {
		Random rnd = new Random();
		int[] array = new int[800];
		for(int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(50);
		}
		
		long t0 = System.nanoTime();
		sort(array);
		//selectionSort(array);
		//insertionSort(array);
		long t1 = (System.nanoTime() - t0);
		sum += t1;
		}
		System.out.println(sum / runs);
		//System.out.println(Arrays.toString(array));
		
		//selectionSort(array);
		//insertionSort(array);
	/*	
		//int[] testArray = {1, 8, 5, 3, 7, 6, 10, 2};
		//int[] tempArray = {0, 0, 0, 0, 0, 0, 0, 0};
	//	sort(testArray);
		//System.out.println(Arrays.toString(testArray));
		System.out.println(Arrays.toString(testArray));
		merge(testArray, tempArray, 0, 3, 7);
		System.out.println(Arrays.toString(testArray));
		//System.out.println(Arrays.toString(array));
		//sort(array);
		//System.out.println(Arrays.toString(array)); */

	}
	
	public static boolean selectionSort(int[] array) {
	//	long t0 = System.nanoTime();
		for(int i = 0; i < array.length - 1; i++) {
			//Lets set the first candidate to the index itself
			int cand = i;
			for(int j = 1; j < array.length; j++) {
				if(array[j] < array[cand]) {
					cand = j;
					
				}
			}
			int temp = array[i];
			array[i] = array[cand];
			array[cand] = temp;
			
			//Swap the item at position i with the item at the candidate position
			
		}
	//	long t1 = (System.nanoTime() - t0);
	//	System.out.println(t1);
		return false;
	}
	
	public static boolean insertionSort(int[] array) {
	//	long t0 = System.nanoTime();
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j > 0 && array[j] < array[j - 1]; j--) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
		}
		//long t1 = (System.nanoTime() - t0);
	//	System.out.println(t1);
		return false;
	}
	
	public static void sort(int[] org) {
		if(org.length == 0) {
			return;
		}
		int[] aux = new int[org.length];
		sort(org, aux, 0, org.length - 1);
		
	} 
	
	private static void sort(int[] org, int[] aux, int lo,  int hi) {
		if(lo != hi) {
			int mid = lo + (hi - lo) / 2;
			
			sort(org, aux, lo, mid);
			sort(org, aux, mid + 1, hi);
			merge(org, aux, lo, mid, hi);
		}
	}
	
	private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
		//COpy all items from lo to hi from org to aux
		for(int i = lo; i <= hi; i++) {
			aux[i] = org[i];
		}
			
		int i = lo;
		int j = mid + 1;
		
		for(int k = lo; k <= hi; k++) {
			//If i is greater than mid, move the j item to the org array, update j
			if(i > mid) {
				org[k] = aux[j];
				j++;
			}
			//else if j is greater than hi, move the i item to the org array, update i
			else if(j > hi) {
				org[k] = aux[i];
				i++;
			}
			//else if the i item is smaller than the j item, move it to the org array, update i
			else if(aux[i] < aux[j]) {
				org[k] = aux[i];
				i++;
			}
			//else you can move the j item to the org array, update j
			else {
				org[k] = aux[j];
				j++;
			}
		}
	}
}
