package linkedLists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		long sum = 0;
		int runs = 1000;
		
		for(int k = 0; k < runs; k++) {
			
			
			LinkedList listA = new LinkedList(0, null);
			
		
			long t0 = System.nanoTime();
			for(int i = 1; i <= 1600; i++) {
				listA.append(new LinkedList(i, null));
			}
			long t1 = (System.nanoTime() - t0);
			sum += t1;
			
			LinkedList listB = new LinkedList(0, null);
			
			for(int i = 1; i <= 100; i++) {
				listB.append(new LinkedList(i, null));
			} 
			
			listB.append(listA);
			
		}
		
		System.out.println(sum / runs);  
		
		
		long sum2 = 0;
		int runs2 = 1000;
		for(int k = 0; k < runs2; k++) {
		int[] arrayA = new int[1000];
		
		
		int[] arrayB = new int[1000];

		
		long t0 = System.nanoTime();
		for(int i = 0; i < arrayA.length; i++) {
			arrayA[i] = i;
		}
		long t1 = (System.nanoTime() - t0);
		sum2 += t1;
		
		for(int i = 0; i < arrayB.length; i++) {
			arrayB[i] = i;
		}
		
		
		int[] newArray = appendArrays(arrayB, arrayA);

		}
		System.out.println(sum2 / runs2);
		/*
		for(int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i]);
		} */
		
	}
	
	public static int[] appendArrays(int[] a, int[] b) {
		int[] newArray = new int[a.length + b.length];
		
		int pos = 0;
		for(int element : a) {
			newArray[pos] = element;
			pos++;
		}
		
		for(int element : b) {
			newArray[pos] = element;
			pos++;
		}
		return newArray;
	}

}
