package queue;

public class DynamicArrayQueue {
	private int[] array;
	public int capacity = 10;
	private int firstPlace;
	private int nextPlace;
	private boolean emptyQueue;
	
	public DynamicArrayQueue() {
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
			int[] newArray = new int[capacity * 2];
			
			for(int i = 0; i < capacity; i++) {
				newArray[i] = array[firstPlace++];
				
				if(firstPlace == capacity) {
					firstPlace = 0;
				}
			}
			
			firstPlace = 0;
			nextPlace = capacity;
			capacity = capacity * 2;
			array = newArray;
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
