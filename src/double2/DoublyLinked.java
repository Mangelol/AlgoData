package double2;

public class DoublyLinked {
	int head;
	DoublyLinked prev;
	DoublyLinked next;

	public DoublyLinked(int item, DoublyLinked prev, DoublyLinked next) {
		head = item;
		this.prev = prev;
		this.next = next;
	}

	public int head() {
		return this.head;
	}

	public DoublyLinked prev() {
		return this.prev;
	}

	public void setPrev(DoublyLinked prev) {
		this.prev = prev;
	}

	public DoublyLinked next() {
		return this.next;
	}

	public void append(DoublyLinked newNode) {
		DoublyLinked current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		newNode.prev = current;
	}

	public void remove(DoublyLinked itemToRemove) {
		DoublyLinked current = this;
		
		//If we have a reference to an item in the middle
		if(itemToRemove.prev != null && itemToRemove.next != null) {
		itemToRemove.prev.next = itemToRemove.next;
		itemToRemove.next.prev = itemToRemove.prev;
		return;
		}
		// If it is the first element
		if (current.prev == null && current.head == itemToRemove.head) {
			current.head = current.next.head;
			current.next.next.prev = current;
			current.next = current.next.next;
		}

		while (current.next != null) {
			// If it is the last element
			if (current.next.next == null && current.next.head == itemToRemove.head) {
				current.next = null;
				break;
			}

			else if (current.head == itemToRemove.head) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
			current = current.next;
		}

	}
	
	public void removeWithRef(DoublyLinked itemToRemove) {

	}
	

//	public DoublyLinked addWithReturn(int headToAdd) {
//		DoublyLinked newCell = new DoublyLinked(headToAdd, null, this);
//		this.prev = newCell;
//		return newCell;
//	}

	public void add(DoublyLinked cellToAdd) {
		int temporary = this.head ;
		this.head = cellToAdd.head;
		cellToAdd.head = temporary;
		cellToAdd.prev = this;
		cellToAdd.next = this.next;
		if (this.next != null) {
			this.next.prev = cellToAdd;
			cellToAdd.next = this.next;
			this.next = cellToAdd;
		}
		// If it is one cell in the list
		else if (this.next == null) {
			this.next = cellToAdd;
		}

	}
	
	public void print() {
		DoublyLinked current = this;
		while(current != null ) {
			if (current.prev == null && current.next == null) { 
				System.out.println("Head " + current.head +  " prev " + current.prev + " next " + current.next );
				break;
			}
			if (current.prev == null && current.next != null) 
				System.out.println("Head " + current.head + " prev " + current.prev + " next " + current.next.head);
			
			if(current.prev != null && current.next == null) { 
				System.out.println("Head " + current.head + " prev " + current.prev.head + " next " + current.next);
				break;
			}
			if(current.prev != null && current.next != null) 
				System.out.println("Head " + current.head + " prev " + current.prev.head +  " next " + current.next.head );
			current = current.next;
		}
	}

}
