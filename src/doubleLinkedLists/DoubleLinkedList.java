package doubleLinkedLists;


public class DoubleLinkedList {
	int head;
	DoubleLinkedList prev;
	DoubleLinkedList nxt;
	
	public DoubleLinkedList(int item, DoubleLinkedList prev, DoubleLinkedList nxt) {
		head = item;
		this.prev = prev;
		this.nxt = nxt;
		
	}
	
	public int head() {
		return this.head;
	}
	
	public DoubleLinkedList prev() {
		return this.prev;
	}
	
	public DoubleLinkedList nxt() {
		return this.nxt;
	}
	
	public void selectPrev(DoubleLinkedList prev) {
		this.prev = prev;
	}
	
	
	public void append(DoubleLinkedList newNode) {
		DoubleLinkedList now = this;
		
		while(now.nxt != null) {
			now = now.nxt;
		}
		
		now.nxt = newNode;
		newNode.prev = now;
	}
	
	public void add(DoubleLinkedList addCell) {
		int temp = this.head;
		this.head = addCell.head;
		addCell.head = temp;
		addCell.prev = this;
		addCell.nxt = this.nxt;
		
		if(this.nxt != null) {
			this.nxt.prev = addCell;
			addCell.nxt = this.nxt;
			this.nxt = addCell;
		}
		
		else if(this.nxt == null) {
			this.nxt = addCell;
		}
		
	}
	
	public void delete(DoubleLinkedList itemDelete) {
		DoubleLinkedList now = this;
		
		if(itemDelete.prev != null && itemDelete.nxt != null) {
			itemDelete.prev.nxt = itemDelete.nxt;
			itemDelete.nxt.prev = itemDelete.prev;
			return;
		}
		
		if(now.prev == null && now.head == itemDelete.head) {
			now.head = now.nxt.head;
			now.nxt.nxt.prev = now;
			now.nxt = now.nxt.nxt;
		}
		
		while(now.nxt != null) {
			
			if(now.nxt.nxt == null && now.nxt.head == itemDelete.head) {
				now.nxt = null;
				break;
			}
			
			else if(now.head == itemDelete.head) {
				now.prev.nxt = now.nxt;
				now.nxt.prev = now.prev;
			}
			
			now = now.nxt;
		}
	}
	
	public void removeWithRef(DoubleLinkedList itemDelete) {
		
	}
	
	public void printList() {
		DoubleLinkedList now = this;
		
		while(now != null) {
			
			if (now.prev == null && now.nxt == null) { 
				System.out.println("Head " + now.head +  " prev " + now.prev + " next " + now.nxt );
				break;
			}
			if (now.prev == null && now.nxt != null) 
				System.out.println("Head " + now.head + " prev " + now.prev + " next " + now.nxt.head);
			
			if(now.prev != null && now.nxt == null) { 
				System.out.println("Head " + now.head + " prev " + now.prev.head + " next " + now.nxt);
				break;
			}
			if(now.prev != null && now.nxt != null) {
				System.out.println("Head " + now.head + " prev " + now.prev.head +  " next " + now.nxt.head );
			}
			now = now.nxt;
		}
	}
}
