package heap;

public class ArrayHeap {
	int[] array;
	int size;
	
	public ArrayHeap(int lngth) {
		this.array = new int[lngth];
		this.size = -1;
	}
	
	public int parent(int n) {
		return (n - 1) / 2;
	}
	
	public int lChild(int n) {
		return (n * 2) + 1;
	}
	
	public int rChild(int n) {
		return (n * 2) + 2;
	}
	
	public void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public void moveUp(int i) {
		while(array[parent(i)] > array[i] && i > 0) {
			swap(parent(i), i);
			i = parent(i);
		}
	}
	
	public void moveDown(int i) {
		int indxMax = i;
		int lft = lChild(i);
		if(lft <= size && array[lft] < array[indxMax]) {
			indxMax = lft;
		}
		int rght = rChild(i);
		if(rght <= size && array[rght] < array[indxMax]) {
			indxMax = rght;
		}
		if(i != indxMax) {
			swap(i, indxMax);
			moveDown(indxMax);
		}
	}
	
	public void add(int value) {
		array[++size] = value;
		moveUp(size);
	}
	
	public int remove() {
		int result = array[0];
		array[0] = array[size];
		size = size - 1;
		moveDown(0);
		return result;
	}
	
	public int getMax() {
		return array[0];
	}
	
	public void printArray() {
		int i = 0;
		System.out.println("Priority queue: ");
		while(i <= size) {
			System.out.print(array[i] + " ");
			i++;
		}
	}
}
