package searchSorted;
import java.util.*;

public class Search_unsorted {
	public static void main(String[] args) {
		Random rnd = new Random();
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(50);
		}
		
		int[] sortedArray1 = sorted(100000);
		int[] sortedArray2 = sorted(100000);
		
	//	betterAccess(sortedArray1, sortedArray2);
	//	binaryAccess(sortedArray1, sortedArray2);
	//	access(sortedArray1, sortedArray2);
	//	search_unsorted(arr, 100);
	//	binary_search(sortedArray1, rnd.nextInt(100));
	//	search_sorted(sorted(100000),20);
	}
	
	public static boolean search_unsorted(int[] array, int key) {
		long t0 = System.nanoTime();
		for(int index = 0; index < array.length; index++) {
			if(array[index] == key) {
				long t1 = (System.nanoTime() - t0);
				System.out.println(t1 + " ns");
				return true;
			}
		}
		long t1 = (System.nanoTime() - t0);
		System.out.println("Unsorted search: " + t1 + " ns");
		return false;
	} 
	
    public static boolean search_sorted(int[] array, int key) {
    	long t0 = System.nanoTime();
    	for(int index = 0; index < array.length; index++) {
    		if(array[index] == key) {
    			long t1 = (System.nanoTime() - t0);
    			System.out.println(t1 + " ns");
    			return true;
    		}
    	}
    	System.out.println("Not found");
    	return false;
    }
	
	private static int[] sorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = 0;
		//long t0 = System.nanoTime();
		for(int i = 0; i < n; i++) {
			nxt += rnd.nextInt(10) + 1;
			array[i] = nxt;
		}
		//long t1 = (System.nanoTime() - t0);
		//System.out.println("Sorted: " + t1);
		return array;
	} 
	
	public static boolean binary_search(int[] array, int key) {
		int first = 0;
		int last =  array.length - 1;
		long t0 = System.nanoTime();
		
		while(true) {
			//Jump to the middle
			int index = (first + last) / 2;
			
			if(array[index] == key) {
				long t1 = (System.nanoTime() - t0);
				System.out.println("Binary search: " + t1 + " ns");
				return true;
			}
			
			if(array[index] < key && index < last) {			
				first = index + 1;
				continue;
			}
			
			if(array[index] > key && index > first) {
				last = index - 1;
				continue;
			}
			//why do we land here? what should we do=
			System.out.println("The element is not found");
			break;
		}
		return false;
	}
	
	public static double access(int[] array, int[] keys) {
		int indexFirst = 0;
		int indexSecond = 0;
		int sum = 0;
		double t_total = 0;
		
		long t0 = System.nanoTime();
		
		while(indexFirst < keys.length) {
			
			if(indexSecond == array.length ) {
				indexSecond = 0;
				indexFirst++;
			}
			
			else if(array[indexSecond] < keys[indexFirst]) {
				indexSecond++;
			}
			
			else if(array[indexSecond] == keys[indexFirst]) {
				sum++;
				indexSecond = 0;
				indexFirst++;
			}
			
			else if(array[indexSecond] > keys[indexFirst]) {
				indexSecond = 0;
				indexFirst++;
			}
		}
		
		t_total += (System.nanoTime() - t0);
		System.out.println("access time: " + t_total + " ns");
		
		return t_total;
	}
	
	public static double betterAccess(int[] array, int[] keys) {
		int indxFirst = 0;
		int indxSecond = 0;
		int sum = 0;
		double t_total = 0;
		
		long t0 = System.nanoTime();
		while(indxFirst < keys.length && indxSecond < array.length) {
			
			if(array[indxSecond] < keys[indxFirst]) {
				indxSecond++;
			}
			
			else if(array[indxSecond] == keys[indxFirst]) {
				sum++;
				indxFirst++;
			}
			
			else if(array[indxSecond] > keys[indxFirst]) {
				indxFirst++;
			}
		}
		
		t_total += (System.nanoTime() - t0);
		System.out.println("BetterAccess time: " + t_total + " ns");
		
		return t_total;
	}
	
	private static int binaryAccess(int[] array, int[] keys) {
		int duplicates = 0;
		
		for(int x : keys) {
			if(binary_search(array, x) == true) {
				duplicates++;
			}
		}
		return duplicates;
	}
	
}
