import java.util.*;
public class ArraysAndPerformance {
	public static void main(String[] args) {
		
		System.out.println(access(10000));
		
	
		/*
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = i;
		}
		
		Random rnd = new Random();
		
		sum = 0;
		long t0 = System.nanoTime();
		for(int i = 0; i < n; i++) {
			sum += array[rnd.nextInt(n)];
		}
		long t1 = System.nanoTime();
		
		int[] indx = new int[l];
		for(int i = 0; i < l; i++) {
			indx[i] = rnd.nextInt(n);
		} 
*/
	}
	
	private static double access(int n) {
		int k = 100_000;
		int l = n;
		
		Random rnd = new Random();
		
		int[] indx = new int[l];
		for(int i = 0; i < l; i++) {
			indx[i] = rnd.nextInt(n);
		}
		//fill the indx array with random number from 0 to n (not including n)
		
		int[] array = new int[n];
		for(int i = 0; i < l; i++) {
			array[i] = 1;
		}
		//fill the array with dummy values (why not 1)
		
		int sum = 0;
		long t0 = System.nanoTime();
		for(int j = 0; j < k; j++) {
			for(int i = 0; i < l; i++) {
				sum += indx[rnd.nextInt(n)];
			}
		}
		long t_access = (System.nanoTime() - t0);
		
		t0 = System.nanoTime();
		for(int j = 0; j < k; j++) {
			for(int i = 0; i < l; i++) {
				
				sum += array[i];
			}
		}
		//do the same loop iteration but only do a dummy add operation
		long t_dummy = (System.nanoTime() - t0);
		//System.out.println((double)(t_access - t_dummy)/((double)k*(double)l)); //egen kod, står ej i uppgift
		
		return ((double)(t_access - t_dummy))/((double)k*(double)l);
	}
}	
