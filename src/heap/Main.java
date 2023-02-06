package heap;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		int n = 100;
		Random rnd = new Random(n);
		long sum = 0;
		int runs = 5000;
		for(int k = 0; k < runs; k++) {
			LinkedListPrioAdd list = new LinkedListPrioAdd();
			
			
			for(int i = 0; i < n; i++) {
				long t1 = System.nanoTime();
				list.add(rnd.nextInt(n));
				long t2 = System.nanoTime() - t1;
				sum += t2;
			}
			
		}
		System.out.println(sum/n);
	}
}
