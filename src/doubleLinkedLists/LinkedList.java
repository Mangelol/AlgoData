package doubleLinkedLists;


public class LinkedList {
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
	
	public void add(LinkedList addCell) {
		int temp = this.head;
		addCell.tail = this.tail;
		this.head = addCell.head;
		this.tail = addCell;
		addCell.head = temp;
	}
	
	public void delete(LinkedList itemDelete) {
		LinkedList now = this;
		
		if(now.head == itemDelete.head) {
			now.head = now.tail.head();
			now.tail = now.tail.tail;
		}
		
		while(now.tail != null) {
			
			if(now.tail.tail == null && now.tail.head == itemDelete.head) {
				now.tail = null;
				break;
			}
			
			else if(now.tail.head == itemDelete.head) {
				now.tail = now.tail.tail;
			}
			
			now = now.tail;
		}
	}
	
	@Override
	public String toString() {
		return "LinkedList [head = " + head + ", tail = " + tail + "]";
	}
}
