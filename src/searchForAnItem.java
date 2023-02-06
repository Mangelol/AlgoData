import java.util.*;
public class searchForAnItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	bench();
	}
	public static void bench() {
		int m = 100;
		int n = 100000;
		int k = 100;
		
		int[] keys = new int[m];
		int[] array = new int[n];
		
		Random rand = new Random();
		
		for(int j = 0; j < k; j++) {
			keys[j] = rand.nextInt(10 * n);
			array[j] = rand.nextInt(10 * n);
		
		
		int sum = 0;
		long t0 = System.nanoTime();
		for(int ki = 0; ki < m; ki++) {
			int key = keys[ki];
			for(int i = 0; i < n; i++) {
				if(array[i] == key) {
					sum++;
					break;
				}
			}
		}
		long t_total = 0;
		t_total += (System.nanoTime() - t0);
		
		System.out.println(t_total);
		}
	}
}
