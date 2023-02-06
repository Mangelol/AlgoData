package stack;

public class DynamicStack {
	private int[] items = new int[4];
	private int pointer = -1;
	int sizeCounter = 4;
	
	public void push(int value) {
		if(pointer == items.length - 1) {
			int[] newItems = new int[items.length * 2];
			sizeCounter = newItems.length;
			for(int i = 0; i <= pointer; i++) {
				newItems[i] = this.items[i];
			}
			
			this.items = newItems;
		}
		items[++pointer] = value;
	}
	
	public int pop() {
		if(pointer == -1) {
			System.out.println("The stack is empty");
			return 0;
		}
		if(pointer < ((sizeCounter/2) - 1)) {
			int[] newItems = new int[items.length / 2];
			sizeCounter = newItems.length;
			for(int i = 0; i <= pointer; i++) {
				newItems[i] = this.items[i];
			}
		}
		int x = items[pointer];
		items[pointer--] = 0;
		return x;
	}
}


