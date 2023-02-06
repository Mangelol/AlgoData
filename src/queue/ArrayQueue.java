package queue;

public class ArrayQueue {
	private int[] array;
	private int capacity = 10;
	private int firstPlace;
	private int nextPlace;
	private boolean emptyQueue;
	
	public ArrayQueue() {
		array = new int[capacity];
		nextPlace = 0;
		firstPlace = 0;
		emptyQueue = true;
	}
	
	public void add(int lastPlace) {
		array[nextPlace] = lastPlace;
		nextPlace++;
		emptyQueue = false;
		
		if(nextPlace == capacity) {
			nextPlace = 0;
		}
		
		if(nextPlace == firstPlace) {
			System.out.println("The stack is full, next number will overwrite the first in the queue");
		}
	}
	
	public int remove() {
		if(emptyQueue) {
			return 0;
		}
		
		int temp = array[firstPlace];
		array[firstPlace] = 0;
		firstPlace++;
		
		if(firstPlace == capacity) {
			firstPlace = 0;
		}
		
		if(nextPlace == firstPlace) {
			emptyQueue = true;
		}
		
		return temp;
	}
}
