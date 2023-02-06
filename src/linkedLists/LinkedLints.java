package linkedLists;

public class LinkedLints {
	int head;
	LinkedList tail;
	
	public LinkedList(int item, LinkedList list) {
		head = item;
		tail = list;	
		
	}
		public int head() {
		return this.head;
	}
	
	public LinkedList tail() {
		return this.tail;
	}
	
	
	public void append(LinkedList b) {
		LinkedList nxt = this;
		while(nxt.tail != null) {
			nxt = nxt.tail;
		}
		nxt.tail = b;
	}
}
