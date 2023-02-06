package double2;

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
		while (nxt.tail != null) {
			nxt = nxt.tail;
		}
		nxt.tail = b;
	}

	public void remove(LinkedList itemToRemove) {
		LinkedList current = this;
		// If it is the first element
		if (current.head == itemToRemove.head) {
			current.head = current.tail.head();
			current.tail = current.tail.tail;
		}

		while (current.tail != null) {
			// If it is the last element
			if (current.tail.tail == null && current.tail.head == itemToRemove.head) {
				current.tail = null;
				break;
			}
			else if (current.tail.head == itemToRemove.head) {
				current.tail = current.tail.tail;
			}
			current = current.tail;
		}

	}
	
//	public LinkedList  addWithReturn(int headToAdd) {
//		LinkedList cellToAdd = new LinkedList (headToAdd, this);
//		return cellToAdd;
//	}
	
	public void add(LinkedList cellToAdd) {
		int temporary = this.head;
		cellToAdd.tail = this.tail;
		this.head = cellToAdd.head;
		this.tail = cellToAdd;
		cellToAdd.head = temporary;
	
	
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", tail=" + tail + "]";
	}
}
