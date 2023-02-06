package stack;

public class StaticStack {
	private int[] items = new int[3];
	private int pointer = -1;
	
	public void push(int value) {
		if(pointer == items.length - 1) {
			System.out.println("The stack is full");
		}
		
		items[++pointer] = value;
	}
	
	public int pop() {
		if(pointer == -1) {
			System.out.println("The stack is empty");
			return 0;
		}
		int x = items[pointer];
		items[pointer--] = 0;
		return x;
	}
}

